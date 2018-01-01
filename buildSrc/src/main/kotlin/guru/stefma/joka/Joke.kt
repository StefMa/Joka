package guru.stefma.joka;

data class Joke(
  val type: String,
  val value: JokeValue
)

data class JokeValue(
  val id: Int,
  val joke: String,
  val categories: List<Any>
)
