plugins {
  kotlin("jvm") version("1.2.10")
  id("java-gradle-plugin")
}

repositories {
  jcenter()
}

dependencies {
  compile(kotlin("stdlib"))
}

gradlePlugin {
  plugins(object: Action<NamedDomainObjectContainer<PluginDeclaration>> {

    override fun execute(pluginDeclarationContainer: NamedDomainObjectContainer<PluginDeclaration>) {
      pluginDeclarationContainer.create("joka", object: Action<PluginDeclaration> {

        override fun execute(pluginDeclaration: PluginDeclaration) {
          pluginDeclaration.setId("guru.stefma.joka")
          pluginDeclaration.setImplementationClass("guru.stefma.joka.JokaPlugin")
        }

      })
    }

  })
}
