package queue;

public class ListNode<T> {
	ListNode<T> next;
	T data;
	
	public ListNode(T data) {
		this.data = data;
		this.next = null;
	}
}
