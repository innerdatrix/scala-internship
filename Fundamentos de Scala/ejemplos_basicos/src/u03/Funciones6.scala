package u03

class Funciones6
{
  def factorial(n: BigInt): BigInt = {
      if(n == 0) 1 else n * factorial(n - 1)
  }
}

object Funciones60
{
  def main(args: Array[String])
  {
    val f50 = new Funciones6
    val f99 = new Funciones6
    val f9950 = new Funciones6
    
    println("fact 50 = ["+f50.factorial(50)+"]")
    println("fact 99 = ["+f99.factorial(99)+"]")
    println("fact 99/50 = ["+f9950.factorial(99/50)+"]")
  }  
}
