package examples.scala

object lecture2 {
  def main(args: Array[String]): Unit = {
    println("lecture 2")

    //    println(contains(singletonSet(1), 2))
    //    println(union(singletonSet(1), singletonSet(2)))
  }

  type FunSet = Int => Boolean

  def contains(s: FunSet, elem: Int): Boolean = s(elem)

  def singletonSet(elem: Int): FunSet = { x => x == elem }

  def union(s: FunSet, t: FunSet): FunSet = (x: Int) => (contains(s, x) || contains(t, x))

  def intersect(s: FunSet, t: FunSet): FunSet = (x: Int) => (contains(s, x) && contains(t, x))

  def diff(s: FunSet, t: FunSet): FunSet = (x: Int) => (contains(s, x) && !(contains(t, x)))

  def filter(s: FunSet, p: Int => Boolean): FunSet = (x: Int) => p(x)
}
