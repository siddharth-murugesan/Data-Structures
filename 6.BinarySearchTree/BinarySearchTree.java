import java.util.*;
import java.lang.*;
import java.io.*;


class BinarySearchTree
{
    static class BinaryTreeNode<T> {
        T data;
        int pos;
        BinaryTreeNode left, right;
        
        BinaryTreeNode(T data, int pos) {
            this.data = data;
            this.pos = pos;
            left = right = null;
        }
    }
    
    static BinaryTreeNode<Long> insert(BinaryTreeNode<Long> root, long data, int pos) {
        if (root == null) {
            System.out.println(pos);
            return new BinaryTreeNode<Long>(data, pos);
        }
        
        if (root.data > data) {
            root.left = insert(root.left, data, 2*pos);
        } else {
            root.right = insert(root.right, data, 2*pos + 1);
        }
        
        return root;
    }
    
    static long minElement(BinaryTreeNode<Long> root) {
        if (root.left == null) {
            return root.data;
        }
        
        return minElement(root.left);
    }
    
    static BinaryTreeNode<Long> delete(BinaryTreeNode<Long> root, long data) {
        
        if (root == null) {
            return null;
        } 
        
        if (root.data == data) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null && root.right != null) {
                root = root.right;
            } else if (root.left != null && root.right == null) {
                root = root.left;
            } else {
                long minvalue = minElement(root.right);
                root.data = minvalue;
                root.right = delete(root.right, minvalue);
            }
            
            return root;
        }
        
        if (root.data > data) {
            root.left = delete(root.left, data);
        } else {
            root.right = delete(root.right, data);
        }
        
        return root;
    }
    
    static int pos(BinaryTreeNode<Long> root, long data) {
        if (root == null) {
            return -1;
        }
        
        if (root.data == data) {
            return root.pos;
        }
        
        if (root.data > data) {
            return pos(root.left, data);
        }
        
        return pos(root.right, data);
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    FastReader in = new FastReader();
	    PrintWriter out = new PrintWriter(System.out, true);
	    
	    // start to code
	    int q = in.nextInt();
	    BinaryTreeNode<Long> root = null;
	    while(q-->0) {
	        char command = in.next().charAt(0);
	        if (command == 'i') {
	            long data = in.nextLong();
	            root = insert(root, data, 1);
	        } else {
	            long data =in.nextLong();
	            int value = pos(root, data);
	            out.println(value);
	            root = delete(root, data);
	        }
	    }
	   
	    out.flush();
	    out.close();
	}
	
	static class FastReader {
	    BufferedReader in;
	    StringTokenizer st;
	    
	    public FastReader() {
	        in = new BufferedReader(new InputStreamReader(System.in));
	    }
	    
	    String next() {
	        while (st == null || !st.hasMoreElements()) {
	            try {
	                st = new StringTokenizer(in.readLine());
	            }
	            catch (Exception IO) {
	                IO.printStackTrace();
	            }
	        }
	        
	        return st.nextToken();
	    }
	    
	    long nextLong() {
	        return Long.parseLong(next());
	    }
	    
	    int nextInt() {
	        return Integer.parseInt(next());
	    }
	    
	    Double nextDouble() {
	        return Double.parseDouble(next());
	    }
	    
	    String nextLine() {
	        String str = "";
	        try {
	            str = in.readLine();
	        } catch(Exception IO) {
	            IO.printStackTrace();
	        }
	        
	        return str;
	    }
	    
	    long[] nextLongArray(int size) {
	        long[] arr = new long[size];
	        
	        for (int i = 0; i < size; i++) {
	            arr[i] = this.nextLong();
	        }
	        
	        return arr;
	    }
	    
	    int[] nextIntegerArray(int size) {
	        int[] arr = new int[size];
	        
	        for (int i = 0; i < size; i++) {
	            arr[i] = this.nextInt();
	        }
	        
	        return arr;
	    }
	    
	    double[] nextDoubleArray(int size) {
	        double[] arr = new double[size];
	        
	        for (int i = 0; i < size; i++) {
	            arr[i] = this.nextDouble();
	        }
	        
	        return arr;
	    }
	    
	    void printArray(Object[] arr) {
	        for (int i = 0; i < arr.length; i++) {
	            System.out.println(arr[i] + " ");
	        }
	        System.out.println();
	    }
	}
}
