package examples.scala.categories.lists

object MedianOfSortedArr {


  def medianOfSortedArr(arr1: Array[Int], arr2:Array[Int]): Int = {
    val x = arr1.length
    val y = arr2.length

    if(x > y) {
      medianOfSortedArr(arr2, arr1)
    }

    var low = 0
    var high = x
    var median = Int.MinValue

    while (low <= high) {

      var partX = (low + high)/2
      var partY = (x + y + 1) /2 - partX

      var arr1LeftMax = arr1(partX-1)
      var arr1RightMin = arr1(partX)
      var arr2LeftMax = arr2(partY-1)
      var arr2RightMin = arr2(partY)

      if(arr1LeftMax < arr2RightMin && arr2LeftMax < arr1RightMin){

        if((x+y)%2 == 0 ) {
          median = (Math.max(arr1LeftMax, arr2LeftMax) + Math.min(arr1RightMin, arr2RightMin)) / 2
        } else {
          median = Math.max(arr1LeftMax, arr2LeftMax)
        }
        low = x + 1
      } else if (arr2LeftMax > arr1RightMin){
        low = partX + 1
      } else {
        high = partX - 1
      }
    }
    return median
  }


}
