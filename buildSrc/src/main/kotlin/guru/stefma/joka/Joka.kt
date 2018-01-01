package guru.stefma.joka;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

open class Joka: DefaultTask() {

    var message = ""
    var recipient = ""

    @TaskAction
    fun sayGreeting() {
        println("$message, $recipient");
    }
}
