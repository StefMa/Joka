plugins {
  kotlin("jvm") version("1.2.10")
  id("java-gradle-plugin")
}

repositories {
  jcenter()
}

dependencies {
  implementation(kotlin("stdlib"))

  implementation("com.squareup.okhttp3:okhttp:3.9.1")

  // Moshi
  implementation("com.squareup.moshi:moshi-kotlin:1.5.0")
  implementation(kotlin("reflect"))
}

gradlePlugin {
  plugins {
    create("joka") {
      id = "guru.stefma.joka"
      implementationClass = "guru.stefma.joka.JokaPlugin"
    }
  }
}
