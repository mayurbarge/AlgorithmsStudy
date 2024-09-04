package slidingwindow

object MinSubArraySum {

  /*
    2, 1, 5, 2, 3, 2
    7
   */
  def findMinSubArray(arr: Array[Int], targetSum: Int) = {
    var minWindowSize = Integer.MAX_VALUE
    var currentWindowSum = 0
    var windowStart = 0
    for (windowEnd <- arr.indices) {
      currentWindowSum += arr(windowEnd)
      while (currentWindowSum >= targetSum) {
        minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1)
        currentWindowSum -= arr(windowStart)
        windowStart += 1
      }
    }
    minWindowSize
  }

  def main(args: Array[String]): Unit = {
    val array = Array(2, 1, 5, 2, 3, 2)
    println(s"Min sub array sum: ${findMinSubArray(array, 7)}")
  }
}
