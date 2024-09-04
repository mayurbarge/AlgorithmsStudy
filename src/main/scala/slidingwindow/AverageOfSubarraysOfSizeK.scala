package slidingwindow

object AverageOfSubarraysOfSizeK {
  def main(args: Array[String]): Unit = {
    val array: Array[Int] = Array(1, 3, 2, 6, -1, 4, 1, 8, 2)
    println(s"The sum of subarrays of size 5:  ${findAverage(5, array).mkString(" ")} ")

  }
  def findAverage(k: Int, array: Array[Int]): Array[Double] = {
    var result = new Array[Double](array.length - k + 1)
    var windowSum = 0.0
    var windowStart = 0
    for(windowEnd <- 0 until array.length) {
      windowSum += array(windowEnd)
      if(windowEnd >= k-1) {
        result(windowStart) = windowSum / k
        windowSum -= array(windowStart)
        windowStart += 1
      }
    }
    result
  }
}

