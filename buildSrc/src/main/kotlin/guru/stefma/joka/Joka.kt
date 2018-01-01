package guru.stefma.joka;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.squareup.moshi.Moshi

const val DOWNLOAD_ERROR = "Can't download joke :("
const val BODY_ERROR = "HTTP body is empty :/"

open class Joka : DefaultTask() {

    var message = ""
    var recipient = ""

    @TaskAction
    fun printJoke() {
        val client = OkHttpClient();
        val request = Request.Builder()
                .url("http://api.icndb.com/jokes/random")
                .build()

        var response: Response?
        try {
            response = client.newCall(request).execute()
        } catch (e: IOException) {
            println(DOWNLOAD_ERROR)
            return
        }

        val json = response?.let {
          it.body()?.string() ?: BODY_ERROR
        }

        if (json != BODY_ERROR) {
          val moshi = Moshi.Builder().build()
          val jokeAdapter = moshi.adapter(Joke::class.java)
          val joke = jokeAdapter.fromJson(json!!)
          println(joke?.value?.joke)
        } else {
          println(json)
        }
    }
}
