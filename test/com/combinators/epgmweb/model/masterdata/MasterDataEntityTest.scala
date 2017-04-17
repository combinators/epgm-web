package com.combinators.epgmweb.model.masterdata

import model.entites.masterdata.MasterChildData.Messages
import model.entites.masterdata.{MasterChildData, MasterChildRawData}
import org.junit.Test
import org.scalatest.Matchers._

class MasterDataEntityTest {

  @Test
  def testMasterDataEntity(): Unit ={
    //given
    val masterRawEntity = MasterChildRawData("27511010507", "101", "010417","M","OMPRAKASH ","KALYANKAR ")
    val masterChild     = MasterChildData(
                              "child", "01", "04", "17", "", "M", "0",
                              "101", "", "OMPRAKASH ","KALYANKAR ","27511010507")
    //when
    val masterActual: Either[Messages, MasterChildData] =
      MasterChildData(masterRawEntity)
    //then
    masterActual.isRight should equal(true)
    masterChild should equal(masterActual.right.get)
  }

  @Test
  def itShouldFailWhenAanganwadiLengthIsNot_11(): Unit ={
    //given
    val masterRawEntity = MasterChildRawData("275110105", "101", "010417", "M","OMPRAKASH ","KALYANKAR ")
    val expectedMessage = "aanganwadi length is not 11 characters"
    //when
    val masterActual: Either[Messages, MasterChildData] =
      MasterChildData(masterRawEntity)
    //then
    masterActual.isLeft should equal(true)
    masterActual.left.get.contains(expectedMessage) should equal(true)
  }

  @Test
  def itShouldFailWhenAanganwadiIsNaN(): Unit ={
    //given
    val masterRawEntity = MasterChildRawData("275110.0507", "101", "010417", "M","OMPRAKASH ","KALYANKAR ")
    val expectedMessage = "aanganwadi contains other than number"
    //when
    val masterActual: Either[Messages, MasterChildData] =
      MasterChildData(masterRawEntity)
    //then
    masterActual.isLeft should equal(true)
    masterActual.left.get.contains(expectedMessage) should equal(true)
  }

  @Test
  def itShouldFailWhenCodeLengthIsNot_3(): Unit ={
    //given
    val masterRawEntity = MasterChildRawData("27511005077", "1011", "010417", "M","OMPRAKASH ","KALYANKAR ")
    val expectedMessage = "child code length is not 3 characters"
    //when
    val masterActual: Either[Messages, MasterChildData] =
      MasterChildData(masterRawEntity)
    //then
    masterActual.isLeft should equal(true)
    masterActual.left.get.contains(expectedMessage) should equal(true)
  }

  @Test
  def itShouldFailWhenCodeIsNaN(): Unit ={
    //given
    val masterRawEntity = MasterChildRawData("27511005077", "1a1", "010417", "M","OMPRAKASH ","KALYANKAR ")
    val expectedMessage = "child code contains other than number"
    //when
    val masterActual: Either[Messages, MasterChildData] =
      MasterChildData(masterRawEntity)
    //then
    masterActual.isLeft should equal(true)
    masterActual.left.get.contains(expectedMessage) should equal(true)
  }

  @Test
  def itShouldFailWhenDOBLengthIsNot_6(): Unit ={
    //given
    val masterRawEntity = MasterChildRawData("27511005077", "101", "01041", "M","OMPRAKASH ","KALYANKAR ")
    val expectedMessage = "date of birth length is not 6 characters"
    //when
    val masterActual: Either[Messages, MasterChildData] =
      MasterChildData(masterRawEntity)
    //then
    masterActual.isLeft should equal(true)
    masterActual.left.get.contains(expectedMessage) should equal(true)
  }

  @Test
  def itShouldFailWhenDOBIsNaN(): Unit ={
    //given
    val masterRawEntity = MasterChildRawData("27511005077", "101", "010/17", "M","OMPRAKASH ","KALYANKAR ")
    val expectedMessage = "date of birth contains other than number"
    //when
    val masterActual: Either[Messages, MasterChildData] =
      MasterChildData(masterRawEntity)
    //then
    masterActual.isLeft should equal(true)
    masterActual.left.get.contains(expectedMessage) should equal(true)
  }

  @Test
  def itShouldFailWhentoGenderIsNot_M_or_F(): Unit ={
    //given
    val masterRawEntity = MasterChildRawData("27511005077", "101", "010/17", "Z","OMPRAKASH ","KALYANKAR ")
    val expectedMessage = "gender is neither M nor F"
    //when
    val masterActual: Either[Messages, MasterChildData] =
      MasterChildData(masterRawEntity)
    //then
    masterActual.isLeft should equal(true)
    masterActual.left.get.contains(expectedMessage) should equal(true)
  }
}
