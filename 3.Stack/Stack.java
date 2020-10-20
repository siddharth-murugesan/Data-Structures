package stack;

public class Stack<T> {
	
	private ListNode<T> head;
	private int size = 0;
	public Stack() {
		head = null;
	}
	
	public void push(T data) {

		size++;
		if (head == null) {
			head = new ListNode<T>(data);
			return;
		}
		
		ListNode<T> newNode = new ListNode<>(data);
		newNode.next = head;
		head = newNode;
		
	}
	
	public T pop() {
		
		if (head == null) {
			return null;
		}
		
		size--;
		T data = head.data;
		head = head.next;
		
		return data;
	}
	
	public int getsize() {
		
		return size;
	}
	
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		
		return false;
	}
	
	public T top() {
		if (head == null) {
			return null;
		}
		return head.data;
	}
	
}
