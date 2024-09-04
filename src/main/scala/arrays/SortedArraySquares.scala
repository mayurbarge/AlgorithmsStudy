package arrays

import scala.+:

object SortedArraySquares {

  def makeSquares(array: Array[Int]) = {
    var result: Array[Int] = Array.empty[Int]
    var left = 0
    var right = array.length-1
    while(left <= right) {
      if(square(array(left)) > square(array(right))) {
        result = result.+:(square(array(left)))
        left += 1
      } else {
        result = result.+:(square(array(right)))
        right -= 1
      }
    }
    result
  }

  def square(i: Int) = i*i

  def main(args: Array[String]): Unit = {
   println(makeSquares(Array(-2, -1, 0, 2, 3)).mkString(" "))
  }
}
