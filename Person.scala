

case class Person(firstName: String, lastName: String) {
  def sayHi(p: Person) = p match {
    case Person("Piotr", "Kowalski") => println("Oh, it's just Piotr Kowalski.")
    case Person("Ania", "Kowalska") => println("Oh, it's just Ania Kowalska.")
    case Person("Ania", lastN) => println(s"Oh, hi Ania ${lastN}!")
    case Person(firstN, "Kowalski") => println(s"Oh, hi ${firstN} Kowalski!")
    case Person(firstN, lastN) => println(s"Hi, ${firstN} ${lastN}!")
  }

}