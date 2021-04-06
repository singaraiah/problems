package examples.scala

object test extends App {

  case class Foo(n: Int)

  val foo = Foo(1)

  implicit def fooToInt(foo: Foo) = foo.n

  println(foo + 1)

  println(List(1, 2, 4, 5).map(_ > 3))

  def sum(x: Int, y: Int) = x + y

  def first(x: Int) = (y: Int) => x + y

  val second = first(5)

  def twice(op: Double => Double, x: Double) = op(op(x))

  println(twice(_ + 1, 5))
}
