package trial

trait MyTrait {
  protected val initialName: String = "default"
  def name = initialName
  
  class uno{
    
  }
  
  trait dos{
    trait aaa{
      
    }
    
    object bbb{
      
    }
  }
  var greet = "hello ! "
}