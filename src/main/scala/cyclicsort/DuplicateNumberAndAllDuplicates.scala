package cyclicsort

object DuplicateNumberAndAllDuplicates {

  def main(args: Array[String]): Unit = {
    println(duplicate(Array(1, 4, 4, 3, 2)))
    println("-----------------------")
    println(duplicateAll(Array(3, 4, 4, 5, 5)).mkString(" "))
  }

  def duplicate(input: Array[Int]): Int = {
    var source: Array[Int] = input

    var i = 0
    while(i < source.length) {
      //println(" array: " + source.mkString(" "))
      if(source(i) != (i+1)) {
        var correctPlace = source(i) - 1
        if(source(i) == source(correctPlace)){
          println("duplicate " + source(i))
          return source(i)
        }
        else {
          var temp = source(correctPlace)
          source(correctPlace) = source(i)
          source(i) = temp
        }
      }
      else {
        i += 1
      }
    }
    -1
  }
  def duplicateAll(input: Array[Int]) = {
    var source: Array[Int] = input
    var result: Array[Int] = Array.empty

    var i = 0
    while(i < source.length) {
      println(" array: " + source.mkString(" "))
      if(source(i) != (i+1)) {
        var correctPlace = source(i) - 1
        if(source(i) == source(correctPlace)){
          println("duplicate " + source(i))
          result +:= source(i)
          i += 1
        }
        else {
          var temp = source(correctPlace)
          source(correctPlace) = source(i)
          source(i) = temp
        }
      }
      else {
        i += 1
      }
    }
    result
  }
}
