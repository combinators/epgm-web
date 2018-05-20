import dao.DBConfigFactory._
import scala.collection.JavaConverters._

object removeAllData extends App{

  val documents = documentClient.queryDocuments(
    "dbs/" + databaseId + "/colls/" + collectionId,
    "SELECT * FROM tyrion",
    null).getQueryIterable().asScala.toList

  println(documents)

  documents.foreach(d => {
    documentClient.deleteDocument(d.getSelfLink(), null)
  })

}


object getAllRegistrationData extends App{
  val dashboard = documentClient.queryDocuments(
    "dbs/" + databaseId + "/colls/" + collectionId,
    "SELECT * FROM tyrion where tyrion.doctype=\"child\"",
    null).getQueryIterable().toList()

  println("master registration data ===>" + dashboard)
}
object getAllDashboardData extends App{
  val dashboard = documentClient.queryDocuments(
    "dbs/" + databaseId + "/colls/" + collectionId,
    "SELECT * FROM tyrion where tyrion.doctype=\"dashboard\"",
    null).getQueryIterable().toList()

  println("master registration data ===>" + dashboard)
}
object getLogData extends App{
  val dashboard = documentClient.queryDocuments(
    "dbs/" + databaseId + "/colls/" + collectionId,
    "SELECT * FROM tyrion where tyrion.doctype=\"log\" ",
    null).getQueryIterable().toList()

  println("master data ===>" + dashboard)
}
