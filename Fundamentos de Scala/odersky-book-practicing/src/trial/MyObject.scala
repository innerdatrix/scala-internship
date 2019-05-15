package trial

class MyObject(override protected val initialName: String = "") extends MyTrait {

  private var myName: String = initialName

  def name_=(newName: String) {
    myName = newName
  }
  override def name = myName
  
  trait aaa{
    
  }
  
  object bbb{
    
  }
}
