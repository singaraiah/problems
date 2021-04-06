package examples.scala.p2oop

object CaseClasses21 extends App {
  /*
  for light weight objects companion object, serialization, equals, hashcode, toString
   */
  case class Person(name: String, age: Int)
  // 1. class parameters are fields
  val jim = Person("Jim", 34)
//  println(jim.name)
  // 2. toString
  // println(instance) = println(instance.toString) // syntactic sugar
//  println(jim)

  // 3. equals and hashcode are implemented
  val jim2 = Person("Jim", 34)
//  println(jim == jim2)

  // 4. CCs have copy methods
  val jim3 = jim.copy(age = 23)
  println(jim3 == jim)

  // 5. CCs have companion objects || no need to use new key word to create an instance
  val thePerson = Person
  val mary = Person("Mary", 25)

  // 6. CCs are serializable
  // Akka

  // 7. CCs have extractor patterns == CCs can be used in pattern matching

  // case objects

  case object UnitedKingdom {
    def name = "UK"
  }
}
