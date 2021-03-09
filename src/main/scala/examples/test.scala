package examples

import scala.collection.mutable

object test extends App {
  case class Foo(n: Int)

  val foo = Foo(1)

  implicit def fooToInt(foo: Foo) = foo.n
  println(foo + 1)

}



