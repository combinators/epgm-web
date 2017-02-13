package com.combinators.epgmweb.model

import controllers.StateDetailsController
import model.WHOIndexedDataModel
import org.junit.Test

/**
  * Created by kirankumarbs on 12/2/17.
  */
class WHOIndexedDataModelTest {

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
    val actual = new WHOIndexedDataModel().create(None)
    //then
    println(actual)
  }

}
