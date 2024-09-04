package arrays

object DutchFlag {
  def main(args: Array[String]): Unit = {
    println(sort(Array(1, 0, 2, 1, 0)).mkString(" "))
  }

  def sort(input: Array[Int]) = {
    var array = input
    var low = 0
    var high = input.length - 1
    var i = 0

    def swap(a: Int, b: Int): Unit = {
      var temp = array(a)
      array(a) = array(b)
      array(b) = temp
    }

    while(i <= high) {
      if(array(i) == 0) {
        swap(i, low)
        i += 1
        low += 1
      } else if(array(i) == 1) {
        i += 1
      } else {
        swap(i, high)
        high -= 1
      }
    }
    array
  }

}
