package slidingwindow

object MaxSumSubArrayOfSizeK {
  def main(args: Array[String]): Unit = {

    val input = Array(2, 1, 5, 1, 3, 2)
    println(s"Max sub array sum Efficient: ${maxSubArray(input, 3)}")
    println(s"Max sub array sum : ${findMaxSumSubArray(3, input)}")

  }

  def maxSubArray(arr: Array[Int], k: Int) = {
    var maxValue = Integer.MIN_VALUE
    var currentRunningSum = 0
    for (i <- arr.indices) {
      currentRunningSum += arr(i)
      if (i >= (k - 1)) {
        maxValue = Math.max(currentRunningSum, maxValue)
        currentRunningSum -= arr(i - (k - 1))
      }
    }
    maxValue
  }
  def findMaxSumSubArray(k: Int, array: Array[Int]) = {
    var windowStart = 0
    var maxSum = 0.0
    var windowSum = 0.0
    for(windowEnd <- array.indices) {
      windowSum += array(windowEnd)
      maxSum = Math.max(windowSum, maxSum)
      if(windowEnd >= k -1) {
        windowSum -= array(windowStart)
        windowStart += 1
      }
    }
    maxSum
  }
}
