package model.entites


import play.api.libs.json._
/**
  * DTO for displaying Consolidated State Level Information
  */
case class ConsolidatedStateResource
  (beneficieriesWeighed:Int,
   severlyUnderWeightBenefeciaries:Int,
   moderatelyUnderWeightBenefeciaries:Int,
   normalBenefeciaries:Int)

object ConsolidatedStateResource{
  /**
    * Mapping to write a PostResource out as a JSON value.
    */
  implicit val implicitWrites = new Writes[ConsolidatedStateResource] {
    override def writes(csr: ConsolidatedStateResource): JsValue = {
      Json.obj(
        "totalBenefeciariesWeighed" -> csr.beneficieriesWeighed,
        "numberOfSeverlyUnderWeightBenefeciaries" -> csr.severlyUnderWeightBenefeciaries,
        "numberOfModeratelyUnderWeightBenefeciaries" -> csr.moderatelyUnderWeightBenefeciaries,
        "numberOfNormalBenefeciaries" -> csr.normalBenefeciaries
      )
    }
  }
}