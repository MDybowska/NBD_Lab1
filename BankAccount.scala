

class BankAccount(money: Double) {
  private var _money: Double = money
   
  def this() {
    this(0.0)
  }
  
  def PutMoney(x: Double) {
    _money += x
  }
  
  def Withdraw(x: Double) {
    _money -= x
  }
  
  def CheckAccountBalance() : Double = {
    _money
  }
}