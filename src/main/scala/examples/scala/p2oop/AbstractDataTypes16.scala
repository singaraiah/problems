package examples.scala.p2oop

object AbstractDataTypes16 extends App {
  // fields, methods or classes unimplemented are abstract
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  // override is not mandatory for abstract methods/members
  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat = println("Crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    def preferredMeal = "Meat "
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomm eating")
    def eat(animal: Animal): Unit = println(s"I'm croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc eat dog

  // traits vs abstract classes
  // 1- both can have abstract & not-abstract members/methods
  // 2- traits don't have constructor parameters
  // 3- multiple traits can be inherited by the same class
  // 4- traits = "behaviour", abstract = "things"

  // Scala's type hierarchy
  // 1- all types are derived from scala.Any
  // 2- all objects string, set, list and used defined objects are derived from
  //    scala.any ---> scala.AnyRef
  //    scala.Null <----- every AnyRefs extends
  // 3- all primitive types(int, booleans, floats, unit)  are derived from scala.Any
  //    scala.any ---> scala.AnyVal
  // 4- scala.Nothing(sub type of all) <----- everything extends

}
