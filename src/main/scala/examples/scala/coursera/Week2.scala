package examples.scala.coursera

object Week2 extends App {

  // higher order functions
  def sum(f: Int => Int, a: Int, b: Int ): Int = {
    if(a > b) 0 else f(a) + sum(f, a+1, b)
  }

  sum(id _, 1, 4)
  sum(id, 1, 4)

  def id(a: Int) = a

  // A => B is a type of a function
  // def str = "abcd" println(str) or println("abcd")
  // analogous to the above anonymous function

  def sumInts(a: Int, b: Int) = sum(x => x, 1, 4)
  def sumSquares(a: Int, b: Int) = sum(x => x*x, 1, 4)

  def sumTail(f: Int => Int, a: Int, b: Int) = {
    def loop(a: Int, acc: Int): Int = {
      if( a > b) acc
      else loop(a+1, f(a) + acc)
    }
    loop(a, 0)
  }

  // currying
  // from where sumF gets the arguments
  def sumCurry(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = {
      if(a>b) 0 else f(a) + sumF(a+1,b)
    }
    sumF
  }

  def sumInts2 = sumCurry( x => x)
  def sumSqure2 = sumCurry( x => x * x)
  def sumCubes2 = sumCurry( x => x * x * x )

  def cubes(x: Int) = x * x * x

  sumInts2(1,4)
  sumCurry(cubes) (1,4)

  //parameter list
  def sumPL(f: Int => Int )(a: Int, b: Int): Int = {
    if(a > b) 0 else f(a) + sumPL(f)(a+1, b)
  }

  val abc = sumPL(cubes) _

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if(a > b) 1 else f(a) * product(f)(a + 1, b)
  }

  println(product(x => x)(1,5))

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a>b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a+1,b))

  def product2(f: Int => Int)(a: Int, b: Int) = mapReduce(f, (x, y) => x*y, 1)(a,b)

  //////////////        2.5           //////////////////////


}
