package examples.scala.categories.lists

import scala.collection.mutable

object MaxSubArray extends App {

  val list = List(-2, 1, -3, 4, -1, 2, 1, -6, 10)
  val resList = mutable.ListBuffer[Int]()

  def maxSubArray(list: List[Int]) = {
    resList += list(0)
    for( i <- 1 to list.length-1) {
      val ele = if (resList(i-1)+list(i) > list(i)) resList(i-1)+list(i) else list(i)
      resList += ele
    }
    resList
  }

  maxSubArray(list)

//  println(resList)


  def maxSubArrayWithLoops = {
    val list = List(-2, 1, -3, 4, -1, 2, 1, -6, 1)
    val n = list.length
    var flag = true
    var maxSum = 0
    var finalList = mutable.ListBuffer[Int]()
    for (i <- 0 to n - 1) {
      if (list(i) > 0) {
        for (j <- i + 1 to n if flag) {
          val subList = list.splitAt(i)._2.splitAt(j - i)._1
          if (subList.sum <= 0) flag = false
           else {
            if (maxSum < subList.sum) {
              maxSum = subList.sum
              finalList = subList.to[mutable.ListBuffer]
            }
          }
        }
      }
      flag = true
    }
    println(maxSum, finalList)
  }


}
