package examples

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Unsolved extends App {
  val arr = Array(1,231,313,31,321,10)
  //  a[w], a[x], a[y], a[z] such that w > x > y > z and a[w] - a[x] + a[y] - a[z] is maximum


  val abc = Array(1, 20, 6, 4, 5)
  def getInvCount(arr: Array[Int]) = {
    var count = 0
    for(i <- 0 to arr.length-1) {
      for (j <- i +1 to arr.length-1){
        if(arr(i)> arr(j)){
          println(arr(i), arr(j))
          count = count + 1
        }
      }
    }
    println(count)
  }


}
