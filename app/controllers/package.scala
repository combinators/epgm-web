import model.entites.masterdata.MasterChildRawData
import play.api.libs.json._
import play.api.libs.functional.syntax._

/**
  * Created by kirankumarbs on 17/4/17.
  */
package object JsonToModelConverter {

  implicit val masterChildReads: Reads[MasterChildRawData] = (
    (JsPath \ "aanganwadiCode").read[String] and
      (JsPath \ "code").read[String] and
      (JsPath \ "dob").read[String] and
      (JsPath \ "gender").read[String] and
      (JsPath \ "name").read[String] and
      (JsPath \ "father").read[String]
    )(MasterChildRawData.apply _)

}

package object ModelToJsonConverter{


}