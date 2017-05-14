package com.combinators.epgmweb.dashboard

import model.entites.dashboard.LastModified
import org.junit.Test

/**
  * Created by kirankumarbs on 14/5/17.
  */
class LastModified {

  @Test
  def shouldGiveMonthAndYear(): Unit ={
    //given
    val input = Map("currentmonth" -> "02", "currentyear" -> "17")
    val expected = LastModified("FEBRUARY", "2017")
    //when
    val actual = LastModified(input)
    //then
  }

}
