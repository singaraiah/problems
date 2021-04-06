package examples.scala.categories.lists

object Sort2SortedArrays extends App {

  def sort2SortedArrays(arr1: Array[Int], arr2: Array[Int], resArr: Array[Int] = Array[Int]()): Array[Int] = {
    if (arr1.isEmpty) resArr ++ arr2
    else if (arr2.isEmpty) resArr ++ arr1
    else if (arr1(0) > arr2(0)) sort2SortedArrays(arr1, arr2.tail, resArr ++ Array(arr2(0)))
    else sort2SortedArrays(arr1.tail, arr2, resArr ++ Array(arr1(0)))
  }

  val l1 = Array(11, 15, 17)
  val l2 = Array(14, 16, 20, 25)

  println(sort2SortedArrays(l1, l2).toList)
  println(List(1, 3).reverse ::: List(2))

}
