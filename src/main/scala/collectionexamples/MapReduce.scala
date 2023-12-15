package collectionexamples

import java.time.{DayOfWeek, Month}

object MapReduce extends App {

  // Example 4
  import java.time.LocalDate
  case class Product(id: String, saleDate: LocalDate, listPrice: Double, discPrice: Double)

  val products = List(
    Product("p001", LocalDate.of(2019, 9, 11), 10, 8.5),
    Product("p002", LocalDate.of(2019, 9, 18), 12, 10),
    Product("p003", LocalDate.of(2019, 9, 27), 10, 9),
    Product("p004", LocalDate.of(2019, 10, 6), 15, 12.5),
    Product("p005", LocalDate.of(2019, 10, 20), 12, 8),
    Product("p006", LocalDate.of(2019, 11, 8), 15, 12),
    Product("p007", LocalDate.of(2019, 11, 16), 10, 8.5),
    Product("p008", LocalDate.of(2019, 11, 25), 10, 9)
  )

  println(products.groupBy(_.saleDate.getMonth).view.mapValues(_.map(_.id)).toList)
  // groupBy - mapValues(map) is same as groupMap
  println(products.groupMap(_.saleDate.getMonth)(_.id).toList)

  // groupMapReduce
  // total of listPrice in a year
  println(products.groupMapReduce(_.saleDate.getYear)(_.listPrice)((p1,p2) => p1+p2))
  products.groupBy(_.id).fold(("",List.empty))((acc, e) => {
    val (oldId, productsWithThisId) = e
  // concatenate all id and add all products back to acc to create original list
    (acc._1+oldId, acc._2 ++ productsWithThisId)
  })

  val x: Map[String, List[Product]] = products.groupBy(_.id)
  println(products.partition(_.saleDate.getMonth == Month.NOVEMBER)._1)
  println(products.partition(_.saleDate.getMonth == Month.NOVEMBER)._2)
  println(products.partitionMap(p => {
    if(p.saleDate.getMonth == Month.NOVEMBER)
      Right(p)
    else
      Left(p)
  })._1)
}
