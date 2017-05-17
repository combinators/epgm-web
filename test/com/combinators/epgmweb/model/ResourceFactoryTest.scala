package com.combinators.epgmweb.model

import model.ResourceRouter
import model.entites.masterdata.{MasterChildData, MasterChildRawData}
import org.junit.Test

/**
  * Created by kirankumarbs on 12/2/17.
  */
class ResourceFactoryTest {

  @Test
  def itShouldGetWHOIndexedData_SpecificState(): Unit ={
    //given
    val sCode = "27"
    //when
    val actual = ResourceRouter.getSpecificStateDetails(sCode,"dashboard")
    //then
    println(sCode)
  }

  @Test
  def itShouldGetAllInitData(): Unit ={
    //given
    val sCode = "27"
    //when
//    val actual = ResourceRouter.epgmDashboardData(sCode,"dashboard")
    //then
  }

  @Test
  def testEPGMAdminDataInsertIntoDatabase: Unit ={
    //given
    val masterChildRawData = MasterChildRawData("27511010507", "103", "010417","M","OMPRAKASH ","KALYANKAR ")
    val masterChildData     = MasterChildData(masterChildRawData).right.get
    //when
    val resource = ResourceRouter.insertAdminDataIntoDB(masterChildData)
    //then
  }


}
