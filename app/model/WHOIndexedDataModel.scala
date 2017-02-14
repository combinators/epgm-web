package model

import dao.DocumentDBDao
import model.entites.ConsolidatedStateResource


/**
  * Created by kirankumarbs on 5/2/17.
  */





class WHOIndexedDataModel() {

  def create(sCode: Option[String]): List[ConsolidatedStateResource] =
    createConsolidatedStateResource(sCode)

  private def createConsolidatedStateResource(sCode: Option[String]): List[ConsolidatedStateResource] = {
    //val whoIndexGrouped = new DocumentDBDao().getWHOIndexedData(sCode)

/*    ConsolidatedStateResource(
      whoIndexGrouped.toList.map(x=>x._2).sum,
      whoIndexGrouped.get(under).getOrElse(0),
      whoIndexGrouped.get(severe).getOrElse(0),
      whoIndexGrouped.get(normal).getOrElse(0)) :: Nil*/

    ConsolidatedStateResource(100,0,0,100) :: Nil
  }

}
