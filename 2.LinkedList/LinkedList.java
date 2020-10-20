
public class LinkedList<T> {
	private int size = 0;
	private ListNode<T> head, tail;

	public LinkedList() {
		head = tail = null;
	}

	public void add(T data) {
		size++;
		if (head == null) {
			head = tail = new ListNode<T>(data);
			return;
		}

		ListNode<T> newNode = new ListNode<T>(data);
		tail.next = newNode;
		tail = tail.next;
	}

	private ListNode<T> AtPosition(ListNode<T> head, boolean toDo, int index, T data) {
		if (index == 0) {
			if (toDo) {
				return head.next;
			}

			ListNode<T> newNode = new ListNode<T>(data);
			newNode.next = head.next;

			return newNode;
		}

		head.next = AtPosition(head.next, toDo, index - 1, data);
		size++;
		return head;
	}

	public void delete(int index) {
		if (head == null) {
			// throw new ListEmptyException();
			return;
		}

		if (size <= index) {
			// throw new outOfListException();
			return;
		}

		T data = head.data;
		size--;
		head = AtPosition(head, true, index - 1, data);

	}

	public void insert(T data, int index) {
		if (head == null) {
			// throw new ListEmptyException();
			return;
		}

		if (size <= index) {
			// throw new outOfListException();
			return;
		}
		size++;
		head = AtPosition(head, false, index - 1, data);
	}

	public T get(int index) {
		if (head == null) {
			// throw new ListEmptyException();
			return null;
		}

		if (index >= size) {
			// throw new outOfListException();
			return null;
		}

		int i = 0;
		ListNode<T> tmp = head;

		while (i < index) {
			tmp = tmp.next;
			i++;
		}

		return tmp.data;
	}

	public void print() {
		ListNode<T> tmp = head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
	}

	public int size() {

		return size;
	}
}
