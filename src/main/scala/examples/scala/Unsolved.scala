package examples.scala

object Unsolved extends App {


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
