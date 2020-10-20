import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
	public static BinaryTreeNode<Integer> takeInput() {
		Queue<BinaryTreeNode<Integer>>  pendingNodes = new LinkedList<BinaryTreeNode<Integer>>(); 
		int start = 0;

		String[] nodeDatas = br.readLine().trim().split(" ");// level Order data

		if (nodeDatas.length == 1) {
			return null;
		}

		int rootData = Integer.parseInt(nodeDatas[start]);
		start += 1;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode = pendingNodes.poll(); 

			int leftChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.add(leftChild);
			}

			int rightChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.add(rightChild);
			}
		}

		return root;
	}


	public static void printLevelWise(BinaryTreeNode<Integer> root){
		
            Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
            q.add(root);
            q.add(null);
        
            while(!q.isEmpty()) {
            
                BinaryTreeNode<Integer> currNode = q.poll();
            
                if(currNode == null) {
                   System.out.println();
                   q.add(null);
                   currNode = q.poll();
                }
                if(currNode != null) {
                   System.out.print(currNode.data + " ");
                }
                
                if(currNode != null && currNode.left != null) {
                   q.add(currNode.left);
                }  
            
               if(currNode != null && currNode.right != null) {
                  q.add(currNode.right);
               }
                
            }

	}

        public static void preOrder(BinaryTreeNode<Integer> root) {
		
           if(root == null) {
              return;
           }
        
           System.out.print(root.data + " ");
        
           preOrder(root.left);
           preOrder(root.right);
		
	}
	public static void postOrder(BinaryTreeNode<Integer> root) {
		
             if(root == null) {
                return;
             }
        
        
            postOrder(root.left);
            postOrder(root.right);
        
           System.out.print(root.data + " ");
	}
 
        public static void main(String[] args) throws NumberFormatException, IOException {
	     BinaryTreeNode<Integer> root = takeInput();
		
             BinaryTree.printLevelWise(root);

	}

}