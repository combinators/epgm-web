import dao.DBConfigFactory._

/**
  * Created by kirankumarbs on 14/2/17.
  */
package object dao {
  implicit val documentDB = DocumentDB(getDocumentClient)
  implicit val documentDBMock = DocumentDBMock()
}
