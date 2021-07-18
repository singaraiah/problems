package examples.scala

import scala.collection.mutable

object Unsolved extends App {

  val hashMap = mutable.HashMap[Int, Int]()
  hashMap += (2 -> 1)
  hashMap += (1 -> 1)
  hashMap.remove(1)
  println(hashMap(2))
//  val arr = Array(2,1,5,3)
//  val target = 4
//
//  for( i <- 0 to arr.length-1) {
//    var diff = target - arr(i)
//    if (hashMap.contains(diff)) println(hashMap(diff),i) else hashMap += (arr(i) -> i)
//  }

}
