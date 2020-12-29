package lec.p2oop

object AnonymousClasses19 extends App {
  abstract class Animal(name:String) {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal("sa") {
    override def eat: Unit = println("inside anonymous class")
  }
  /*
    class AnonymousClasses$$anon$1 extends Animal("sa") {
      def eat = println("inside anony class")
    }
   */
  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi = println(s"Hi my name is $name, how can I help you")
  }

  val jim = new Person("Jim") {
    override def sayHi = println(s"Hi, my name is Jim")
  }

}
