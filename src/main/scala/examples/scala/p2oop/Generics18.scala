package examples.scala.p2oop

object Generics18 extends App {

  // A is generic type parameter
  class MyLists[A]

  // generic methods
  // objects can't have generic type parameters
  object MyLists {
//    def empty[A]: MyLists[A] = ???
  }
//  val emptyListOfInts = MyLists.empty[Int]

  // variance
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1- yes List[Cat] extends List[Animal] = covariance
  class CovarianceList[+A]
  val animal: Animal = new Cat
  val covarianceList: CovarianceList[Animal] = new CovarianceList[Cat]

  // 2- No = invariance
  class Invarience[A]
  val invarience: Invarience[Animal] = new Invarience[Animal]

  // 3- contravariance
  //
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  // Access type A which are subclasses of Animal
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Cat)


}
