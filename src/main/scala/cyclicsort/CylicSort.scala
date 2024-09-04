package cyclicsort

object CylicSort {
  def main(args: Array[String]): Unit = {
    println(sort(Array(3, 1, 5, 4, 2)).mkString)
  }
  def sort(input: Array[Int]) = {
    var source: Array[Int] = input

    var i = 0
    while(i < source.length) {
      println(" array: " + source.mkString(" "))
      if(source(i) != (i+1)) {
        var correctPlace = source(i) - 1
        var temp = source(correctPlace)
        source(correctPlace) = source(i)
        source(i) = temp
      }
      else {
        i += 1
      }
    }
    source
  }

}
