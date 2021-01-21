package examples

import scala.collection.mutable

object test extends App {

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
  getInvCount(abc)
}



