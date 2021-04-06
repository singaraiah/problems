package examples.scala.p2oop

object Objects14 extends App {
  // scala does not have class level functionality("Static")
  object Person { // type + only instance (Singleton object)
    // static/class level functionality
    val N_EYES = 2
    def canFly = false

    // factory methods bcuz it creates new Class object
    def apply(father: Person, mother: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    // instance level functionality
  }
  // Companions (if object and class are defined with same name in same scope)


  println(Person.N_EYES)

  // Scala object == singleton instance
  val mary = new Person("Mary")
  val john = new Person("John")
  val bobbie = Person(john, mary)
  println(mary == john )

  // scala applcations == scala objects with main method implemented
}

