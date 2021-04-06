package examples.scala

import scala.collection.mutable

object CreateCollections extends App {
  // matrix or 2d Array
  val matrix = Array.ofDim[Int](2, 2)
  matrix(0)(1) = 1

  //Array Buffers
  val arrayBuf = mutable.ArrayBuffer.empty[Int]
  arrayBuf += 1
  arrayBuf += 10

  //List Buffers
  val listBuf = mutable.ListBuffer.empty[Int]
  listBuf += 1
  listBuf += 10

  //StringBuilders
  val strBuf = new StringBuilder
  strBuf += 'a'
  strBuf ++= "bcdef"

  case class Emp(name: String, age: Int)

  val a = scala.collection.mutable.LinkedList(Emp("a", 1), Emp("b", 2), Emp("c", 3))
  val b = a.next

}
