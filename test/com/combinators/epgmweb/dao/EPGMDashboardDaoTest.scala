package com.combinators.epgmweb.dao

import dao.DBConfigFactory.{collectionId, databaseId}
import dao._
import org.junit._
import DBConfigFactory._
import com.google.gson.Gson
import com.microsoft.azure.documentdb.Document
import org.scalatest.Matchers._

/**
  * Created by kirankumarbs on 14/2/17.
  */
class EPGMDashboardDaoTest {

  type DB = DocumentDB
  val db = implicitly[Database[DB]]

  @Test
  def itShouldCreateGradeDataIntoDatabase(): Unit ={
    //given
    //when
//    db.set("gradewise27", Map("suwcount" -> "21", "muwcount" -> "23", "normalcount" -> "61", "totalcount" -> "105").asJava)
//    db.set("gradewise27001", Map("suwcount" -> "2", "muwcount" -> "2", "normalcount" -> "6", "totalcount" -> "10").asJava)
//    db.set("gradewise52", Map("suwcount" -> "15", "muwcount" -> "35", "normalcount" -> "30", "totalcount" -> "80").asJava)
//    db.set("gradewise52001", Map("suwcount" -> "1", "muwcount" -> "3", "normalcount" -> "3", "totalcount" -> "7").asJava)
    //then
  }
  @Test
  def itShouldCreateGenderDataIntoDatabase(): Unit ={
    //given
    //when
//    db.set("genderwise27", Map("malecount" -> "66", "femalecount" -> "37").asJava)
//    db.set("genderwise52", Map("malecount" -> "24", "femalecount" -> "36").asJava)
    //then
  }
  @Test
  def itShouldCreateAgeDataIntoDatabase(): Unit ={
    //given
    //when
//    db.set("agewise27", Map("zerotoonecount" -> "12", "onetotwocount" -> "14","twotothreecount" -> "08", "threetofourcount" -> "22",
//      "fourtofivecount" -> "27", "fivetosixcount" -> "56").asJava)
//    db.set("agewise52", Map("zerotoonecount" -> "4", "onetotwocount" -> "12","twotothreecount" -> "6", "threetofourcount" -> "16",
//      "fourtofivecount" -> "13", "fivetosixcount" -> "51").asJava)
    //then
  }
  @Test
  def itShouldCreateMonthDataIntoDatabase(): Unit ={
    //given
    //when
//    db.set("monthwise27", Map("januarycount" -> "11", "februarycount" -> "22","marchcount" -> "33", "aprilcount" -> "44",
//      "maycount" -> "55", "junecount" -> "44", "julycount" -> "33", "augustcount" -> "22", "septembercount" -> "11", "octobercount" -> "7",
//      "novembercount" -> "5", "decembercount" -> "1", "currentmonth" -> "03", "currentyear" -> "2016").asJava)
//
//    db.set("monthwise52", Map("januarycount" -> "20", "februarycount" -> "20","marchcount" -> "60", "aprilcount" -> "100",
//      "maycount" -> "20", "junecount" -> "20", "julycount" -> "60", "augustcount" -> "60", "septembercount" -> "100", "octobercount" -> "20",
//      "novembercount" -> "50", "decembercount" -> "50", "currentmonth" -> "02", "currentyear" -> "2016").asJava)
    //then
  }
  @Test
  def itShouldGetGradeDataFromDatabase(): Unit ={
    //given
    val sCode1 = "27"
    val sCode2 = "52"
    val docType = "dashboard"

    //when
/*    val stateRecord1 = EPGMDaoInterface().dashboardData(sCode1, docType)
    val stateRecord2 = EPGMDaoInterface().dashboardData(sCode2, docType)
    println(stateRecord1)*/

    //stateRecord1 shouldBe Map("suwcount" -> "20", "muwcount" -> "20", "normalcount" -> "60", "totalcount" -> "100")
    //stateRecord2 shouldBe Map("suwcount" -> "15", "muwcount" -> "35", "normalcount" -> "30", "totalcount" -> "80")
  }

  @Test
  def itShouldGetGenderDataFromDatabase(): Unit ={
    //given
    val sCode1 = "27"
    val sCode2 = "52"
    val docType = "dashboard"
    //when

/*    val stateRecord1= EPGMDaoInterface().dashboardData(sCode1, docType)
    val stateRecord2 = EPGMDaoInterface().dashboardData(sCode2, docType)
    println(stateRecord1)*/
    //then
/*    stateRecord1 shouldBe Map("malecount" -> "64", "femalecount" -> "36")
    stateRecord2 shouldBe Map("malecount" -> "24", "femalecount" -> "36")*/

  }
  @Test
  def itShouldGetAgeDataFromDatabase(): Unit ={
    //given
    val sCode1 = "27"
    val sCode2 = "52"
    val docType = "dashboard"
    //when

/*    val stateRecord1= EPGMDaoInterface().dashboardData(sCode1, docType)
    val stateRecord2 = EPGMDaoInterface().dashboardData(sCode2, docType)
    println(stateRecord1)*/
    //then
/*    stateRecord1 shouldBe
      Map("zerotoonecount" -> "12", "onetotwocount" -> "14","twotothreecount" -> "08", "threetofourcount" -> "22",
        "fourtofivecount" -> "27", "fivetosixcount" -> "5")

    stateRecord2 shouldBe  Map("zerotoonecount" -> "4", "onetotwocount" -> "12","twotothreecount" -> "6", "threetofourcount" -> "16",
      "fourtofivecount" -> "13", "fivetosixcount" -> "50")*/
  }
  @Test
  def itShouldGetMonthDataFromDatabase(): Unit ={
    //given
    val sCode1 = "27"
    val sCode2 = "52"
    val docType = "dashboard"
    //when

/*    val stateRecord1= EPGMDaoInterface().dashboardData(sCode1, docType)
    val stateRecord2 = EPGMDaoInterface().dashboardData(sCode2, docType)

    println(stateRecord1)*/

    //then
/*
    stateRecord1 shouldBe Map("januarycount" -> "11", "februarycount" -> "22","marchcount" -> "33", "aprilcount" -> "44",
      "maycount" -> "55", "junecount" -> "44", "julycount" -> "33", "augustcount" -> "22", "septembercount" -> "11", "octobercount" -> "7",
      "novembercount" -> "5", "decembercount" -> "1", "currentmonth" -> "02", "currentyear" -> "2016")

    stateRecord2 shouldBe Map("januarycount" -> "20", "februarycount" -> "20","marchcount" -> "60", "aprilcount" -> "100",
      "maycount" -> "20", "junecount" -> "20", "julycount" -> "60", "augustcount" -> "60", "septembercount" -> "100", "octobercount" -> "20",
      "novembercount" -> "50", "decembercount" -> "50", "currentmonth" -> "02", "currentyear" -> "2016")
*/

  }

}


