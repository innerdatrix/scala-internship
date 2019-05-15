package ch9

object Currying {
  
  def plainOldSum(x: Int, y: Int) = x + y
  
  def curriedSum(x: Int)(y: Int) = x + y
  
  def first(x: Int) = (y: Int) => x + y
  
  def main(args: Array[String]){
    
    println(curriedSum(4)_)
    
    val second = first(2)
    println(second(2))
    
    val onePlus = curriedSum(1)_
    println(onePlus(2))
    
  }
}