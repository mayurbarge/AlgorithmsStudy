package slidingwindow

object LargestSubstringKDistinct {

  def main(args: Array[String]): Unit = {
    println(s"Largest substring of araaci with no more than 2 distinct chars is ${findLength("araaci", 2)}")
    println("--------------")
    println(s"Largest substring of araaci with no more than 1 distinct chars is ${findLength("araaci", 1)}")
    println("--------------")
    println(s"Largest substring of araaci with no more than 3 distinct chars is ${findLength("araaci", 3)}")
    println("--------------")
  }
  def findLength(str: String, k: Int) = {
    val charArray = str.toCharArray
    var frequencyMap = scala.collection.mutable.Map.empty[Char, Int]
    var windowStart = 0
    var maxLengthForK = 0

    for(windowEnd <- 0 until charArray.length) {
      val currentChar = charArray(windowEnd)
      frequencyMap += ( currentChar -> (frequencyMap.getOrElse(currentChar, 0) + 1))
      //println(s"current char - $currentChar map - $frequencyMap start - $windowStart end - $windowEnd len - $maxLengthForK")

      while(frequencyMap.keySet.size > k) {
        frequencyMap.put(charArray(windowStart), frequencyMap.getOrElse(charArray(windowStart), 0) - 1)
        frequencyMap = frequencyMap.filter(pair => !frequencyMap.get(pair._1).contains(0))
        //println(s">> current char - $currentChar map - $frequencyMap start - $windowStart end - $windowEnd len - $maxLengthForK")
        windowStart += 1
      }
      maxLengthForK = Math.max(maxLengthForK, windowEnd - windowStart + 1)
    }
    maxLengthForK
  }
}
