
public class ArrayList<T> {
	
	private Node<T> data[];
	private int size, listSize;
	
	ArrayList() {
		size = 10;
		data = new Node[size];
		listSize = 0;
	}
	
	ArrayList(int size) {
		this.size = size;
		data = new Node[size];
		listSize = 0;
	}
	
	private void doubleUp() {
		
		Node<T> tmp[] = new Node[size];
		data = new Node[2*size];
		
		for (int i = 0; i < size; i++) {
			data[i] = tmp[i];
		}
		
		size = 2*size;
	}
	
	private void set(Node<T> data) {
		this.data[listSize] = data;
	}
	
	public void add(T data) {
		
		if (listSize >= size) {
			this.doubleUp();
		}
		
		Node<T> newnode = new Node<>(data);
		this.data[listSize++] = newnode; 
	}
	
	public void remove(int index) {
		
		if (index >= listSize) {
			return;
		}
		
		for (int i = index; i < listSize - 1; i++) {
			this.data[i] = this.data[i + 1];
		}
		listSize--;
		
	}
	
	
	public T get(int index) {
		
		if (index >= listSize) {
			return null;
		}
		
		return this.data[index].data;
	}
	
	public int size() {
		return this.listSize;
	}
	
}
