package lec.p2oop

object Inheritance15 extends App {

  // single class inheritance
  class Animal {
//    val creatureType = "wild"
    val creatureType = "wild"
    def eat = println("eatingggg")
  }
  // Animal is super class and cat is sub class
  // extend meaning inheriting all the non-private fields and methods
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch")
    }
  }

  // we need to pass the correct constructor to super class
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding
  class Dog(override val creatureType: String ) extends Animal {
//    override val creatureType: String = "domestic"
//    override def eat: Unit = println("overriden eat")
    val abc = 100
  }

//  val dog = new Dog("K9")
//  dog.eat

  // type substitution (polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overriding overloading
  // super

  // preventing overriding
  // 1- using final before methods or members
  // 2- use final on class to prevent from inheriting
  // 3- use sealed to allow extending within the file and restrict outside the file


}
