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
  plugins {
    create("joka") {
      id = "guru.stefma.joka"
      implementationClass = "guru.stefma.joka.JokaPlugin"
    }
  }
}
