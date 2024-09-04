package arrays

object TripletSumToZero {
  def main(args: Array[String]): Unit = {
    println(searchTriplets(Array(-3, 0, 1, 2, -1, 1, -2)).toList.map(_.toList))
    println(searchTriplets(Array(-5, 2, -1, -2, 3)).toList.map(_.toList))
  }
  def searchTriplets(arr: Array[Int]) = {
    val sortedInput: Array[Int] = arr.sorted
    println("sorted: " + sortedInput.mkString(" "))
    var triplets: Array[Array[Int]] = Array.empty

    for(i <- 0 until sortedInput.length - 1) {
      if(i > 0 && sortedInput(i) == sortedInput(i-1))
        triplets
      else
        triplets = searchPair(sortedInput, -sortedInput(i), i+1, triplets)
      println(triplets.toList.map(_.toList))
      println("------------")
    }
    triplets
  }
  def searchPair(input: Array[Int], targetSum: Int, leftIndex: Int, triplets: Array[Array[Int]]): Array[Array[Int]] = {
    var right = input.length - 1
    var left = leftIndex
    var result: Array[Array[Int]] = triplets

    while(left < right) {
      //println(s" left: ${input(left)} right: ${input(right)} target: $targetSum ")
      val currentSum = input(left) + input(right)
      if(currentSum == targetSum) {
        val triple: Array[Int] = Array(-targetSum, input(left), input(right))
        result = result ++ Array(triple)
        left +=1
        right -= 1
      } else if(currentSum < targetSum) {
        left += 1
      }
      else {
        right -= 1
      }
    }
    result
  }
}
