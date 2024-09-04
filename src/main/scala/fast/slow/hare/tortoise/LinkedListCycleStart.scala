package fast.slow.hare.tortoise

object LinkedListCycleStart {
  def hasCycle(head: LinkedList): LinkedList = {
    var slow = head
    var fast = head
    while(fast != null && fast.next != null) {
      println(s"slow ${slow.data} fast ${fast.data}")
      fast = fast.next.next
      slow = slow.next
      if(slow == fast) {
        val cycleLen = cycleLength(slow)
        println("Cycle length: " + cycleLen)
        return findStart(head, cycleLen)
      }
    }
    null
  }
  def cycleLength(head: LinkedList): Int = {
    var cycleLength = 0
    var current = head
    do {
      current = current.next
      cycleLength += 1
    } while(current != head)
    cycleLength
  }

  def findStart(head: LinkedList, cycleLength: Int) = {
    var fast = head
    var slow = head
    var length = cycleLength

    while(length > 0) {
      fast = fast.next
      length -= 1
    }
    println("Fast moved at " + fast.data)
    while(slow != fast) {
      slow = slow.next
      fast = fast.next
    }
    slow
  }
  def main(args: Array[String]): Unit = {
    val head = LinkedList(1)
    head.next = LinkedList(2)
    head.next.next = LinkedList(3)
    head.next.next.next = LinkedList(4)
    head.next.next.next.next = LinkedList(5)
    head.next.next.next.next.next = LinkedList(6)
    /*
      1->2->3->4->5->6
            3<-------6
     */

    //println(head)
    //println(hasCycle(head))
    head.next.next.next.next.next.next = head.next.next
    //println(head)
    println("The cycle has started at: " + hasCycle(head).data)
  }

}
