package examples.scala.categories.lists

object NQueens extends App {

  val n = 4
  val board = Array.ofDim[Int](n,n)

  def printBoard(board: Array[Array[Int]]) = {
    board.foreach(x => {
      x.foreach(x => print(s"$x\t"))
      println()
    })
  }

  def isSafe(row: Int, col: Int) = {
    var topFlag = true
    for (i <- 0 to col if row - i >= 0) {
      if (board(row - i)(col - i) == 1) topFlag = false
    }
    var botFlag = true
    for (i <- col to 0 by -1 if row + i < n) {
      if (board(row + i)(col - i) == 1) botFlag = false
    }

    board(row).filter(_ == 1).isEmpty && topFlag && botFlag
  }

  var iii: Int = 0
  def nQueens(col: Int): Boolean = {
    if (col >= n) true
    else {
      (0 until n).exists(i => {
        if (isSafe(i, col)) {
          board(i)(col) = 1
          iii += 1
          val abc = nQueens(col+1)
          if(abc == false) {
            board(i)(col) = 0
          }
          abc
        } else false
      })
    }

  }

  nQueens(0)
  println(iii)
  printBoard(board)

}
