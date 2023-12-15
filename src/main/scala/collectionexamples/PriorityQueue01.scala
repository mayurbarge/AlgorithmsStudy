package collectionexamples

import scala.collection.mutable

object PriorityQueue01 extends App {
  case class Fruit(weight: Int)

  case class Fish(weight: Int) extends Ordered[Fish] {
    override def compare(that: Fish): Int = this.weight compare that.weight
  }

  val queue = scala.collection.mutable.PriorityQueue[Fruit]()(Ordering.by(fruit => fruit.weight))
  queue += Fruit(1)
  queue += Fruit(9)
  queue += Fruit(12)
  println(queue.clone().dequeueAll)

  val fishQueue = scala.collection.mutable.PriorityQueue[Fish]()
  fishQueue += Fish(2000)
  fishQueue += Fish(20)
  fishQueue += Fish(200)
  println(fishQueue.reverse.clone().dequeueAll)





  val maxQueue = mutable.PriorityQueue(4,5,6,3,3,74,32)
  implicit val minOrder = new Ordering[Int] {
    override def compare(x: Int, y: Int): Int = if(x == y) 0 else if(x < y ) 1 else -1
    // or even x compare y
    // which basically calls java.lang.Integer.compare
    /*
    def compare(x: Int, y: Int): Int =  { return if ((x < y))  { -(1)}
      else  { (if ((x == y))  { 0}
      else  { 1})}
      }
     */
  }
  //val minQueue = mutable.PriorityQueue(4,5,6,3,3,74,32)(minOrder)
  // same as
  val minQueue = mutable.PriorityQueue(4,5,6,3,3,74,32)(Ordering[Int])// by default order is minHeap
  // same as
  val minQueue2 = mutable.PriorityQueue(4,5,6,3,3,74,32)(Ordering.fromLessThan[Int]((a,b) => b < a))

  println(maxQueue.toList)
  println(maxQueue.dequeueAll)
  println(minQueue.dequeueAll)
  println(minQueue2.dequeueAll)
}
