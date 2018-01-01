package guru.stefma.joka;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Action;

open class JokaPlugin: Plugin<Project> {


    override fun apply(project: Project) {
        project.tasks.create("hello", Joka::class.java, object: Action<Joka> {

          override fun execute(joka: Joka) {
              joka.message = "Hello"
              joka.recipient = "World"
          }

        })
    }

}
