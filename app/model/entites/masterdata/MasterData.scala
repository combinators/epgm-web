package model.entites.masterdata

import scala.collection.mutable.ListBuffer

/**
  * Created by kirankumarbs on 15/4/17.
  */
case class MasterChildData(doctype: String, dayofbirth: String, monthofbirth: String, yearofbirth: String,
                           address: String, sex: String, recordnumber: String, childcode: String,
                           category: String, name: String, fathername: String,
                           aanganwadiCode: String)

case class MasterChildRawData(aanganwadiCode: String, code: String, dob: String, gender: String, name: String, father: String)

object MasterChildData {

  type Messages = List[String]

  def apply(m: MasterChildRawData): Either[Messages, MasterChildData] = {
    createMasterChildDataEntity(m)
  }

  private def createMasterChildDataEntity(m: MasterChildRawData): Either[Messages, MasterChildData] = {
    validateMasterRawData(m) match {
      case Nil => Right(parseMasterRawData(m))
      case messages: List[String] => Left(messages)
    }
  }

  private def validateMasterRawData(m: MasterChildRawData): List[String] = {
    val msgs: ListBuffer[String] = ListBuffer()
    if (m.aanganwadiCode.length != 11) msgs += formatLengthMsg("aanganwadi", "11")
    if (isNotNaN(m.aanganwadiCode)) msgs += formatNaNMsg("aanganwadi")
    if (m.code.length != 3) msgs += formatLengthMsg("child code", "3")
    if (isNotNaN(m.code)) msgs += formatNaNMsg("child code")
    if (m.dob.length != 6) msgs += formatLengthMsg("date of birth", "6")
    if (isNotNaN(m.dob)) msgs += formatNaNMsg("date of birth")
    if (isNotGender(m.gender)) msgs += "gender is neither M nor F"

    def formatLengthMsg(name: String, length: String): String = s"$name length is not $length characters"
    def formatNaNMsg(name: String): String = s"$name contains other than number"
    def isNotNaN(s: String): Boolean = !s.matches("[0-9]+")
    def isNotGender(g: String): Boolean = !(m.gender.toUpperCase == "M" || m.gender.toUpperCase =="F")

    msgs.toList

  }

  private def parseMasterRawData(m: MasterChildRawData) = {
    val (dayofbirth, monthyear) = m.dob.splitAt(2)
    val (monthofbirth, yearofbirth) = monthyear.splitAt(2)
    MasterChildData("child", dayofbirth, monthofbirth, yearofbirth, "", m.gender, "0", m.code
      , "", m.name, m.father, m.aanganwadiCode)
  }


}