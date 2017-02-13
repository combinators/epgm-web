package com.combinators.epgmweb.dao

import controllers.StateDetailsController
import dao.WHOIndexData
import org.junit.Test

/**
  * Created by kirankumarbs on 12/2/17.
  */
class WHOIndexDataTest {

  @Test
  def itShouldGetSpecificStateData(): Unit ={
    //given
    val sCode = "27"
    //when
    val actual = new StateDetailsController().getSpecificStateData(sCode)
    //then
    println(actual)
  }

  @Test
  def itShouldGetAllStateData(): Unit ={
    //given
    //when
    val actual = WHOIndexData.getAllStateData()
    //then
    println(actual)
  }

}
