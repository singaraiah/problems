package examples.categories.lists

import scala.collection.mutable

object Sorts extends App {

  def mergeSort(a: List[Int]): List[Int] = {
    val n = a.length
    if (n < 2) return a
    val mid: Int = n / 2

    val left = mergeSort(a.slice(0, mid))
    val right = mergeSort(a.slice(mid, a.length))
    merge(left, right)
  }

  def merge(left: List[Int], right: List[Int]): List[Int] = {
    val list = mutable.ListBuffer.fill(left.length + right.length)(0)
    var i = 0
    var j = 0
    var k = 0
    while (i < left.length && j < right.length) {
      if (left(i) > right(j)) {
        list(k) = right(j)
        j = j + 1
      }
      else {
        list(k) += left(i)
        i = i + 1
      }
      k = k + 1
    }
    while (i < left.length) {
      list(k) += left(i)
      i = i + 1
      k = k + 1
    }
    while (j < right.length) {
      list(k) += right(j)
      j = j + 1
      k = k + 1
    }
    list.toList
  }


  def selectSort(list: mutable.ArrayBuffer[Int]) = {
    for (i <- 0 to list.length - 1) {
      var minele = list(i)
      var minInx = i
      for (j <- i + 1 to list.length - 1) {
        if (minele > list(j)) {
          minele = list(j)
          minInx = j
        }
      }
      var temp = minele
      list(minInx) = list(i)
      list(i) = minele
      println(list)
    }
  }

  //  selectSort(list)

  def insertionSort(list: mutable.ArrayBuffer[Int]) = {
    //10,3,8,6,1,2,4,12
    for (i <- 1 to list.length - 1) {
      val unsortrdEle = list(i)
      var hole = i
      while (hole > 0 && unsortrdEle < list(hole - 1)) {
        list(hole) = list(hole - 1)
        hole = hole - 1
      }
      list(hole) = unsortrdEle
    }
    list
  }

  val testArrayBuff = mutable.ArrayBuffer(10, 3, 8, 6, 1, 2, 4, 12)

  val testList = List(10, 3, 8, 6, 1, 2, 4, 12)

  def newMergeSort(xs: List[Int]): List[Int] = {
    val m = xs.length / 2
    if (m == 0) xs
    else {
      @scala.annotation.tailrec
      def merge2(ls: List[Int], rs: List[Int], acc: List[Int] = List()): List[Int] =
        (ls, rs) match {
          case (Nil, _) => acc ++ rs
          case (_, Nil) => acc ++ ls
          case (l :: ls1, r :: rs1) =>
            if (l < r) merge2(ls1, rs, acc :+ l)
            else merge2(ls, rs1, acc :+ r)
        }

      val (l, r) = xs splitAt m
      merge2(newMergeSort(l), newMergeSort(r))
    }
  }

  newMergeSort(testList)
}
