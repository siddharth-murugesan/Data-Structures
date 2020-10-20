package queue;

public class Queue<T> {
	private ListNode<T> head, tail;
	private int size = 0;
	public Queue() {
		head = tail = null;
	}
	
	public void enqueue(T data) {
		size++;
		ListNode<T> newnode = new ListNode<>(data);
		
		if (head == null) {
			head = tail = newnode;
			return;
		}
		
		tail.next = newnode;
		tail = newnode;
	}
	
	public T dequeue() {
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
	
	public T peek() {
		if (head == null) {
			return null;
		}
		
		return head.data;
	}
	
	public boolean isEmpty() {
		
		return size == 0;
	}
}
