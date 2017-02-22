package constants

/**
  * Created by kirankumarbs on 22/2/17.
  */
object WHOConstants {
  def apply(who: String):WHO = who match {
    case "0" => NORMAL
    case "1" => MUW
    case "2" => SUW
    case _   => INVALID
  }

  trait WHO
  private case object SUW extends WHO
  private case object MUW extends WHO
  private case object NORMAL extends WHO
  private case object INVALID extends WHO



  implicit class convertToInt(who: WHO){
    def toInt: Int = who match {
      case NORMAL => 0
      case MUW => 1
      case SUW => 2
      case INVALID => 7
    }
  }
}
