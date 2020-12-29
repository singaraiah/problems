package examples.categories.strings

object CheckBalExp extends App {
  val str = "(a+(b*c) + (d + (e/(f*g))) -k )"

  var balFact = 0
  var maxdepth = 0

  for (i <- 0 to str.length - 1) {
    if (str(i) == '(') {
      balFact = balFact + 1
      if (maxdepth < balFact) {
        maxdepth = balFact
      }
    } else if (str(i) == ')') {
      balFact = balFact - 1
    }
  }

  if (balFact == 0) println(s"balanced and max depth is $maxdepth") else println(-1)
}
