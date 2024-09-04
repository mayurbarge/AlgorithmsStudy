package trees

import scala.+:
import scala.collection.mutable

object LevelOrderTraversal {

  case class TreeNode(data: Int, var left: TreeNode = null, var right: TreeNode = null)
  case object TreeNode {
    def levelOrderTraversal(input: TreeNode) = {
      var traveral: List[List[Int]] = List.empty
      var tree = input
      var queue = mutable.Queue(input)

      while(queue.nonEmpty) {
        var level: List[Int] = List.empty
        for(i <- 0 until queue.size) {
          val treeNodeOnQueue = queue.dequeue()
          level = level :+ treeNodeOnQueue.data
          if(treeNodeOnQueue.left != null) {
            queue.enqueue(treeNodeOnQueue.left)
          }
          if(treeNodeOnQueue.right != null) {
            queue.enqueue(treeNodeOnQueue.right)
          }
        }
        traveral :+= level // traveral = level :+ traversal gives error need to check.  :+= appends to the endLevelOrderTraversal$
      }
      traveral
    }
  }
  def main(args: Array[String]) = {
    /*
                12
               7    1
             9     10  5
     */
    var root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.left.left = TreeNode(9)
    root.right.left = TreeNode(10)
    root.right.right = TreeNode(5)
    println(TreeNode.levelOrderTraversal(root))

  }
}
