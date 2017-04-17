package com.combinators.epgmweb.dao

import dao.DBConfigFactory._
import dao.{DBConfigFactory, EPGMDaoInterface}
import scala.collection.JavaConverters._
import model.entites.masterdata.{MasterChildData, MasterChildRawData}
import org.junit.Test

/**
  * Created by kirankumarbs on 16/4/17.
  */
class EPGMAdminTest {

  @Test
  def testMasterChildDataIntoDatabase(): Unit ={
    //given
    val masterChildRawData = MasterChildRawData("27511010507", "102", "010417",'M',"OMPRAKASH ","KALYANKAR ")
    val masterChildData     = MasterChildData(masterChildRawData).right.get
    val dao = EPGMDaoInterface()
    //when
    val status = dao.insertMasterChildData(masterChildData)
    getMasterChildData
    //then
  }

  @Test
  def getMasterChildData() = {
    val document = documentClient.queryDocuments(s"dbs/$databaseId/colls/$collectionId",
      "SELECT * FROM tyrion where tyrion.doctype = \"child\" and tyrion.aanganwadicode = \"27511010507\" and tyrion.childcode=\"002\"", null)
      .getQueryIterable.asScala.headOption.get

    println(document)
  }
}
