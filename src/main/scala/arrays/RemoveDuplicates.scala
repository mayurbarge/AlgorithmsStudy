package arrays

object RemoveDuplicates {

  def remove(input: Array[Int]) = {
    // in-place modification of input is not possible in scala hence this solution works only in java.
    var nextNonDuplicate = 1 // index of next non-duplicate
    var result: Array[Int] = Array[Int]()

    result +:= input(0)
    for(i <- 1 until input.length) {
      if(input(i) != input(nextNonDuplicate-1)) {
        result +:= input(i)
        println(result.mkString(" "))
        nextNonDuplicate += 1
      }
    }
    result

  }
  def main(args: Array[String]) = {
    println(remove(Array(2, 3, 3, 3, 6, 9, 9)).mkString(" "))
  }
}
