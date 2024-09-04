package slidingwindow

object NoRepeatingSubstring extends App {
  def findLength(input: String) = {
    val charArray = input.toCharArray
    var frequencyMap = scala.collection.mutable.Map.empty[Char, Int]
    var windowStart = 0
    var maxLength = 0

    for(windowEnd <- 0 until charArray.length) {
      val currentChar = charArray(windowEnd)
      frequencyMap += ( currentChar -> (frequencyMap.getOrElse(currentChar, 0) + 1))

      while(frequencyMap.values.toSeq.exists(_ > 1)) {
        frequencyMap.put(charArray(windowStart), frequencyMap.getOrElse(charArray(windowStart), 0) - 1)
        frequencyMap = frequencyMap.filter(pair => !frequencyMap.get(pair._1).contains(0))
        windowStart += 1
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1)
    }
    maxLength
  }
  def findLength2(input: String) = {
    val charArray = input.toCharArray
    var charIndexMap = scala.collection.mutable.Map.empty[Char, Int]
    var windowStart = 0
    var maxLength = 0

    for(windowEnd <- 0 until charArray.length) {
      val currentChar = charArray(windowEnd)
      if(charIndexMap.contains(currentChar)) {
        windowStart = Math.max(windowStart, charIndexMap.getOrElse(currentChar, 0)+1)
      }
      charIndexMap.put(currentChar, windowEnd)
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1)
     // println(s"char $currentChar start $windowStart end $windowEnd map $charIndexMap max $maxLength")
    }
    maxLength
  }

  println(findLength("aabccbb")) // expected 3
  println(findLength2("aabccbb")) // expected 3
  println(findLength("abbbb")) // expected 2
  println(findLength2("abbbb")) // expected 2
  println(findLength("abccde")) // expected 3
  println(findLength2("abccde")) // expected 3
}
