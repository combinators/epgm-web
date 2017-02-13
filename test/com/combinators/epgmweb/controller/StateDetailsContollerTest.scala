package com.combinators.epgmweb.controller

import controllers.StateDetailsController
import org.junit.Test

/**
  * Created by kirankumarbs on 12/2/17.
  */
class StateDetailsContollerTest {

  @Test
  def itShouldGetSpecificWHOIndexedData(): Unit ={
    //given
    val sCode = "27"
    //when
    val actual = new StateDetailsController().getSpecificStateData(sCode)
    //then
    println(actual)
  }

}
