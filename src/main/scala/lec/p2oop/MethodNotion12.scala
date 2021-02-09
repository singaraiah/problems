package lec.p2oop

object MethodNotion12 extends App {

  // 12
  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String) = movie == favoriteMovie
    def +(person: Person) = s"${this.name} hanging out with ${person.name}"
    def unary_! : String = s"$name whhhatt"
    def isAlive = true
    def apply()  = s"this is demo of apply on $name"
    // 13
    def +(nickName: String): Person = new Person(s"$name ($nickName)", favoriteMovie)
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def learns(thing: String) = s"$name learning $thing"
    def learnsScala = this learns "Scala"
    def apply(n: Int) = s"$name watched $favoriteMovie $n times"
  }


  val p1 = new Person("P1", "M1")
//  println(p1 likes "M1")
  // infix notation (syntactic sugar) are applicable to single parameter methods
  // all operators in scala are methods
  // no reserved operator symbols
  val p2 = new Person("P2", "M2")
//  println(p1 + p2)
//  println(!p1)

  // prefix notation
  var neg = -1 //  is equivalent to 1.unary_-
  // unary prefix operators works only with - + ! ~

  // postfix notation
  // postfix are applicable to no parameter methods
//  println(p1.isAlive)
//  println(p1 isAlive)

  // apply will help call objects like functions
//  println(p1.apply())
//  println(p1())

  // 13
  println((p1 + "abcd")())
  println((+p1).age)
  println(p1 learnsScala)
  println(p1(10))
}
