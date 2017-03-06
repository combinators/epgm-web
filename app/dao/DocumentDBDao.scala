package dao

import constants.WHOConstants
import services.GmrResource

/**
  * Created by chocoklate on 5/2/17.
  */

class DocumentDBDao {

  def getWHOIndexedData(sCode: Option[String]):Map[AnyRef, Int] = sCode match {
    case Some(x) => WHOIndexData.getSpecificStateData(x)
    case None => WHOIndexData.getAllStateData()
  }

  def getGrowthMonitoringReport(aanganwadiCode:String):List[GmrResource] = {
    GmrResource(
      1,"GANESH", "A KHADE", "M", "08/24/2014","OBC",
      List("08/13/2016","07/08/2016","06/10/2016"),
      List(14.140,13.975,13.745), List(WHOConstants("0"))) :: Nil
  }

}

object DbRun{
  def main(args: Array[String]): Unit = {
    println("==========="+new DocumentDBDao().getWHOIndexedData(Option("27")))
  }
}
