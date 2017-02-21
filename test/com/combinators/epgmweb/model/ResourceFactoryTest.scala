package com.combinators.epgmweb.model

import model.ResourceFactory
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
    val actual = ResourceFactory().getSpecificStateDetails(sCode)
    //then
    println(sCode)
  }

  @Test
  def itShouldGetWHOIndexedData_AllState(): Unit ={
    //given
    //when
    val actual = ResourceFactory().getAllStateDetails()
    //then
    println(actual)
  }

  @Test
  def itShouldGetAllInitData(): Unit ={
    //given
    val sCode = "27"
    //when
    val actual = ResourceFactory().epgmDashboardData(sCode,"dashboard")
    //then
  }

}
