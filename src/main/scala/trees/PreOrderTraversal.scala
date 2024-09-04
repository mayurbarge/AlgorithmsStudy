package trees

object PreOrderTraversal {

  case class TreeNode(data: Int, var left: TreeNode = null, var right: TreeNode = null)
  case object TreeNode {
    def preOrderTraversal(input: TreeNode) = {
      var traveralArray: Array[Int] = Array.empty
      var tree = input

      def go(current: TreeNode): Unit = {
        //println(s" Current: ${current.data}")
        traveralArray = traveralArray ++ Array(current.data)
        if (current.left != null) {
          go(current.left)
        }
        if (current.right != null) {
          go(current.right)
        }
      }
      go(tree)
      traveralArray
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
    println(TreeNode.preOrderTraversal(root).mkString(" "))
  }
}
