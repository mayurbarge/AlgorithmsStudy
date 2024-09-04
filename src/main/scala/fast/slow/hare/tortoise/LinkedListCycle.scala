package fast.slow.hare.tortoise

case class LinkedList(data: Int, var next: LinkedList = null)
object LinkedListCycle {

  def hasCycle(head: LinkedList): Boolean = {
    var slow = head
    var fast = head
    while(fast != null && fast.next != null) {
      println(s"slow ${slow.data} fast ${fast.data}")
      fast = fast.next.next
      slow = slow.next
      if(slow == fast) {
        return true
      }
    }
    false
  }
  def main(args: Array[String]): Unit = {
    val head = LinkedList(1)
    head.next = LinkedList(2)
    head.next.next = LinkedList(3)
    head.next.next.next = LinkedList(4)
    head.next.next.next.next = LinkedList(5)
    head.next.next.next.next.next = LinkedList(6)

    //println(head)
    //println(hasCycle(head))
    head.next.next.next.next.next.next = head.next.next
    //println(head)
    println(hasCycle(head))
  }

}
