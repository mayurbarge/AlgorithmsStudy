package collectionexamples

import java.util.Date

object StackDemo extends App {
  // FIFO
  val stack = scala.collection.mutable.Stack[Int]()
  stack += 10
  stack += 9
  stack += 1

  println(stack.top)
  println(stack.pop)
  println(stack.pop)
  println(stack.pop)

  println("FIFO----------------------------------")
  // always use push for Stack behaviour
  stack.push(10)
  stack.push(9)
  stack.push(1)
  println(stack.pop)
  println(stack.pop)
  println(stack.pop)

  println("LIFO-----------")
  // List is LIFO
  val list = List()
  val newlist = list.appended(10) ++ list.appended(12) ++ list.appended(14)
  println(newlist.head)

  case class Rec(date: Date, id: Int, amount: Double)
  /*Date 		Id Amount cumSum
  2022-02-20	1  10	10
  2022-02-20	2  10   10
  2022-02-21	1  10  20
  2022-02-22	1  10  30
  2022-02-22	2  10  20
*/

}
