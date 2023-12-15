package arrays

object TwoSum extends App {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
      var i = 0
      var j = nums.length-1
      while(i <= nums.length/2  ) {
       // println(i + " " + j)
        val sum = nums(i) + nums(j)
        if(sum > target)
          j -= 1
        else if ( sum < target )
          i +=1
        else return Array(nums(i), nums(j))
      }
      Array(-1,-1)
    }
    println(twoSum(Array(2,7,11,15), 9).mkString)

    println(twoSum(Array(3,2,4), 6).mkString)

}

/*
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 */