package examples.scala.categories.lists

object SortListOfSortedLists extends App {

  val l1 = List(11, 15, 17)
  val l2 = List(14, 16, 20, 25)
  val l3 = List(12, 13, 21, 27)

  def sortListOfSortedListsV2(list: List[List[Int]], resList: List[Int] = List[Int]()): List[Int] = {
    val firstEle = list.map(_ (0))
    val minEle = firstEle.min
    val indexOfMinEle = firstEle.indexOf(minEle)

    val newList = list.map(x => {
      if (x.equals(list(indexOfMinEle))) {
        if (x.tail.isEmpty) List() else x.tail
      } else x
    }).filter(!_.isEmpty)

    if (newList.isEmpty) resList ++ List(minEle) else sortListOfSortedListsV2(newList, resList ++ List(minEle))
  }

  println(sortListOfSortedListsV2(List(l1, l2, l3)))
}
