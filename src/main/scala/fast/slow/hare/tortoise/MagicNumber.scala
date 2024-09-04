package fast.slow.hare.tortoise

object MagicNumber {
  /*
    Input: 23
  Output: true (23 is a happy number)
  Explanations: Here are the steps to find out that 23 is a happy number:

  2*2 + 3*3 = 13
  1*1 + 3*3 = 10
  1*1 + 0 = 1

  For 12 the numbers are
  89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89


  Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

   */
  def main(args: Array[String]): Unit = {
    println(isMagic(23))
    println(isMagic(12))
    //println(sumOfSquaresOfDigits(23))
    //println(sumOfSquaresOfDigits(13))
  }

  def isMagic(i: Int) = {
    var slow = i
    var fast = i
    do {
      slow = sumOfSquaresOfDigits(slow)
      fast = sumOfSquaresOfDigits(sumOfSquaresOfDigits(fast))
      println("slow: " + slow + " fast: " + fast)
    }
    while(slow !=  fast)
    slow == 1
  }
  def sumOfSquaresOfDigits(i: Int) = {
    var sum = 0
    var number = i
    while(number != 0) {
      val digit = number % 10
      sum += digit*digit
      number /= 10
    }
    sum
  }
}
