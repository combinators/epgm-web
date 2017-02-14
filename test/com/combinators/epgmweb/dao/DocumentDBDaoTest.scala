package com.combinators.epgmweb.dao

import controllers.StateDetailsController
import dao.DocumentDBDao
import org.junit.Test

/**
  * Created by kirankumarbs on 12/2/17.
  */
class DocumentDBDaoTest {

  @Test
  def itShouldgetWHOIndexedData_SpecificState(): Unit ={
    //given
    val sCode = "27"
    //when
    val actual = new StateDetailsController().getSpecificStateData(sCode)
    //then
    println(actual)
  }

  @Test
  def itShouldgetWHOIndexedData_AllState(): Unit ={
    //given
    //when
    val actual = new DocumentDBDao().getWHOIndexedData(None)
    //then
    println(actual)
  }

}
