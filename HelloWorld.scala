

object HelloWorld {
      def main(args: Array[String]) {
        //1 zadanie
        val days: List[String] = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
        
        //1a
        println("1a")
        for (i <- 0 until days.size) {
          println(days(i))
        }
        //1a alternatywa
        println("\n1a alternatywa")
        for (day <- days) {
          println(day)
        }
        
        //1b 
        println("\n1b")
        for (i <- 0 until days.size) {
          if (days(i).take(1) == "P") {
             println(days(i))
          }
        }
        //1b alternatywa
        println("\n1b alternatywa")
        for (day <- days if day.startsWith("P")) {
          println(day)
        }
        
        //1c
        println("\n1c")
        days.foreach { println }
        
        //1d
        println("\n1d")
        var i = 0
        while (i < days.size) {
          println(days(i))
          i += 1 
        }
        
        //1e
        println("\n1e")
        def printList(myList: List[String]) : String = { 
          if(myList.tail == Nil) {
            myList.head
          } else {
            myList.head + "\n" + printList(myList.tail)
          }
        }
        println(printList(days))
        
        //1f 
        println("\n1f")        
        def reverse(myList : List[String]) : List[String] = myList match {
          case Nil => Nil
          case head::tail => reverse(tail) ++ List(head)
        }
        
        val reversedDays: List[String] = reverse(days)
        println(printList(reversedDays))
      
        //1f alternatywa
        println("\n1f alternatywa")
        def printListRev(myList: List[String], i: Int) {
          var j : Int = i
          if (j != 0) {            
            println(myList(j-1))
            j -= 1
            printListRev(myList, j)
          }
        }
        printListRev(days, days.size)
        
        //1g 
        println("\n1g foldl")   
        //println(s"${days.foldLeft("")((a, b) => a + b + "\n")}")
        println(s"${days.foldLeft("")(_ + _ + "\n")}")
        println("\n1g foldr") 
        //println(s"${days.foldRight("")((a, b) =>  a + "\n" + b)}")
        println(s"${days.foldRight("")(_ + "\n" + _)}")
        
        //1h
        println("\n1h") 
        println(s"${days.foldLeft("")( (a, b) =>
            if (b.startsWith("P")) a + b + "\n" else a
        )}")
        
        
        //2
        println("\n2")   
        val products = Map("jabłka" -> 5, "pomarańcze" -> 10, "batony" -> 2, "banany" -> 3, "ziemniaki" -> 4, "nożyczki" -> 8)
        println(products)
        val newProducts = products.map { case (k, v) => k -> 0.9 * v }
        println(newProducts)
        
        //3
        println("\n3")   
        def printTuple(tuple: Tuple3[Int, String, Double]) {
          println(tuple._1, tuple._2, tuple._3)
        }
        val tuple = Tuple3(2, "Tekst", 10.12)
        printTuple(tuple)
        
        //4
        println("\n4")
        val age = Map("Marta" -> 24, "Jaś" -> 13, "Staś" -> 20, "Małgosia" -> 24, "Kasia" -> 17, "Jola" -> 27)
        val namesToFind = List("Kasia", "Krzysiek", "Stefan", "Jola")
        
        for(i <- 0 until namesToFind.size) {
          val a:Option[Int] = age.get(namesToFind(i))
          if (a.isEmpty) {
            println(s"Nie znaleziono osoby o imieniu ${namesToFind(i)}. Przypisano domyślny wiek: ${a.getOrElse(20)}")
          } else {
            println(s"Osoba o imieniu ${namesToFind(i)} ma ${age(namesToFind(i))} lat")
          }
        }
        
        //5
        println("\n5")
        def whatKindOfDay(day: String) = day match {
          case "Poniedziałek" => s"${day} => praca"
          case "Wtorek" => s"${day} => praca"
          case "Środa" => s"${day} => praca"
          case "Czwartek" => s"${day} => praca"
          case "Piątek" => s"${day} => praca"
          case "Sobota" => s"${day} => weekend"
          case "Niedziela" => s"${day} => weekend"
          case _ => s"${day} => Nie ma takiego dnia"
        }        
        days.foreach { day => println(whatKindOfDay(day)) }
        
        //6
        println("\n6")
        val bank = new BankAccount()
        println(bank.CheckAccountBalance())
        bank.PutMoney(20)
        println(bank.CheckAccountBalance())
        bank.Withdraw(10)
        println(bank.CheckAccountBalance())
        
        val bank2 = new BankAccount(100)
        println(bank2.CheckAccountBalance())
        bank2.Withdraw(10)
        println(bank2.CheckAccountBalance())
        bank2.PutMoney(20)
        println(bank2.CheckAccountBalance())
        
        //7
        println("\n7")
        val person1 = new Person("Ania", "Kowalska")
        person1.sayHi(person1)
        val person2 = new Person("Ktośtam", "Jakiśtam")
        person2.sayHi(person2)
        val person3 = new Person("Piotr","Kowalski")
        person3.sayHi(person3)
        val person4 = new Person("Ania","Jakaśtam")
        person4.sayHi(person4)
        val person5 = new Person("Ktośtam","Kowalski")
        person5.sayHi(person5)
        
        //8
        println("\n8")
        def filterZeros(num : List[Int]) : List[Int] = {
          //num.filter(_ != 0)
          num.filterNot(_ == 0)
        }
        
        val numbers = List(2,3,0,7,0,3,7,123,345,-4,-7,0,6,0,34,0)
        println(s"Lista przed modyfikacją: ${numbers}")
        println(s"Lista po modyfikacji:\t ${filterZeros(numbers)}")
        
        //9
        println("\n9")
        def incrementValues(num : List[Int]) : List[Int] = {
          num.map { i => i+1 }
        }
        println(s"Lista przed modyfikacją: ${numbers}")
        println(s"Lista po modyfikacji:\t ${incrementValues(numbers)}")
        
        //10
        println("\n10")        
        def absList (myList:List[Double]) : List[Double] = {
          //myList.filter(listEl => (listEl > -5 && listEl < 12)).map { case k => math.abs(k) }
          myList.filter(_ > -5).filter(_ < 12).map(_ abs)
        }
        
        val numbers2 : List[Double] = List(2,-3,0,7,0,3,7,123,345,-4,-7,0,6,0,34,12,10,4)
        println(s"Lista przed modyfikacją: ${numbers2}")
        println(s"Lista po modyfikacji:\t ${absList(numbers2)}")
      }
     
}



