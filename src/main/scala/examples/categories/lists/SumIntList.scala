package examples.categories.lists

object SumIntList extends App {
  val l1 = List(1, 2, 8)
  val l2 = List(2, 4, 9)

  def problem2V2(l1: List[Int], l2: List[Int], carry: Int, ind: Int, resultList: List[Int]): List[Int] = {
    val sum = l1(ind) + l2(ind)
    if (ind != 0) {
      problem2V2(l1, l2, sum / 10, ind - 1, (carry + sum % 10) :: resultList)
    } else {
      sum % 10 :: resultList
    }
  }

  println(problem2V2(l1, l2, 0, l1.length - 1, List()))

}
