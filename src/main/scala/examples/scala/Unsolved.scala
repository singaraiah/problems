package examples.scala

object Unsolved extends App {
  val arr = Array(1, 231, 313, 31, 321, 10)
  //  a[w], a[x], a[y], a[z] such that w > x > y > z and a[w] - a[x] + a[y] - a[z] is maximum

  val abc = Array(1, 20, 6, 4, 5)

  def getInvCount(arr: Array[Int]) = {
    var count = 0
    for (i <- 0 to arr.length - 1) {
      for (j <- i + 1 to arr.length - 1) {
        if (arr(i) > arr(j)) {
          println(arr(i), arr(j))
          count = count + 1
        }
      }
    }
    println(count)
  }


  val arr1 = Array(34, 8, 10, 3, 2, 80, 30, 33, 1)
  var gap = 0
  var cnt = 0
  for(i <- 0 to arr1.length - 1) {
    if( gap < arr1.length - i) {
      for (j <- i + 1 to arr1.length - 1 ){
        if(arr1(j) > arr1(i) && gap < j - i) {
          gap = j - i
          println(gap)
        }
        cnt = cnt + 1
        println(i,j)
    }
    }
  }


}
