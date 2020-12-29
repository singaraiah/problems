package lec.p2oop

object OOBasics11 extends App {
  //11
  //val author = new Writer("Singa", "J", 1992)
  //val imposter = new Writer("Singa", "J", 1992)
  //val novel = new Novel("abcd", 2020, author)
  //println(novel.isWrittenBy(imposter ))

  //  val counter = new Counter
  //  counter.inc.inc.print
  class Writer(firstName: String, surname: String, val year: Int) {
    def fullName = firstName + "_" + surname
  }

  class Novel(name: String, year: Int, author: Writer) {
    def authorAge = year - author.year
    def isWrittenBy(author: Writer) = author == this.author
    def copy(newYear: Int) = new Novel(name, newYear, author)
  }

  class Counter(val count: Int=0) {
    def inc = {
      println("ince")
      new Counter(count + 1)
    }
    def dec = {
      println("dec")
      new Counter(count - 1)
    }

    def inc(n: Int): Counter = {
      if(n == 0) this else inc(n-1).inc
    }
    def dec(n: Int): Counter = if(n == 0) this else dec(n-1).dec

    def print = println(count)
  }

  // 10
  // Primary  constructor
  // class parameters are not fields unless declared with vals
  //val person = new Person("singa", 23)
  class Person(name: String, val age: Int){
    //  class field
    val abc = 23

    def greet(name: String) = println(s"${this.name} says Hi, $name")

    //  auxliary  constructor
    def this(name: String) = this(name, 10)
    def this() = this("default")
  }

}


