package examples.scala

object test extends App {

  val x = for (x <- 1 to 5) yield x*2

  println(x)


}
