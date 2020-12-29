package lec.exercises

abstract class MyList17 {
  /*
    head
    tail
    isEmpty
    add(int)
    toString
   */
  def head: Int
  def tail: MyList17
  def isEmpty: Boolean
  def add(element: Int): MyList17
  // polymorphic call
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList17 {
  def head: Int = throw new NoSuchElementException
  def tail: MyList17 = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList17 = new Cons(element, Empty)
  override def printElements: String = ""
}

class Cons(h: Int, t: MyList17) extends MyList17 {
  def head: Int = h
  def tail: MyList17 = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList17 = new Cons(element, this)

  def printElements: String =
    if(t.isEmpty) "" + h else h + " " + t.printElements
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.toString)
}