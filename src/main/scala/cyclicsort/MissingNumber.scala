package cyclicsort

object MissingNumber {

  def main(args: Array[String]): Unit = {
    println(sort(Array(8, 3, 5, 2, 4, 6, 0, 1))) // 7
  }
  def sort(input: Array[Int]): Int = {
    var source: Array[Int] = input
    var i = 0
    while(i < source.length) {
      if(source(i) < source.length && source(i) != source(source(i))) {
        val temp = source(source(i))
        source(source(i)) = source(i)
        source(i) = temp
      } else {
        i += 1
      }
    }
    for(i <- source.indices) {
      if(i != source(i))
        return i
    }
    source.length
  }
}
