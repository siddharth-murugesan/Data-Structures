import java.util.*;

public class HashMap<K, V> {
	
	private ArrayList<Node<K, V>> bucket;
	private int numberOfNodes;
	private int sizeofMap = 20;
	
	HashMap() {
		bucket = new ArrayList<>();
		numberOfNodes = 0;
		
		for (int i = 0; i < sizeofMap; i++) {
			bucket.add(null);
		}
		
	}
	
	private double loadFactor() {
		return 1.0*numberOfNodes/sizeofMap;
	}
	
	private void reHash() {
		
		ArrayList<Node<K, V>> temp = bucket;
		bucket = new ArrayList<>();
		
		sizeofMap = 2*sizeofMap;
		
		for (int i = 0; i < sizeofMap; i++) {
			bucket.add(null);
		}
		
		for (int i = 0; i < temp.size(); i++) {
			
			Node<K, V> head = temp.get(i);
			
			while(head != null) {
				K key = head.key;
				V value = head.value;
				insert(key, value);
				head = head.next;
			}
			
		}
		
	}
	
	public V remove(K key) {
		
		int bucketIndex = key.hashCode()%sizeofMap;
		
		Node<K, V> head = bucket.get(bucketIndex), prev = null, output = null;
		
		while(head != null) {
			
			if (key.equals(head.key)) {
				if (prev == null) {
					output = head.next;
					bucket.set(bucketIndex, head.next);
				} else {
					output = head;
					prev.next = head.next;
				}
				numberOfNodes--;
				break;
			}
			
			prev = head;
			head = head.next;
		}
		
		
		return output == null ? null : output.value ;
	}
	
	public V getValue(K key) {
		
		int bucketIndex = key.hashCode()%sizeofMap;
		Node<K, V> head = bucket.get(bucketIndex);
		
		while(head != null) {
			
			if (key.equals(head.key)) {
				return head.value;
			}
			head = head.next;
			
		}
		
		return null;
	}
	
	public void insert(K key, V value) {
		
		int bucketIndex = key.hashCode()%sizeofMap;
		
		Node<K, V> head = bucket.get(bucketIndex);
		
		while(head != null) {
			
			if (key.equals(head.key)) {
				head.value = value;
				return;
			}
			
			head = head.next;
		}
		
		Node<K, V> newNode = new Node<>(key, value);
		newNode.next = bucket.get(bucketIndex);
		bucket.set(bucketIndex, newNode);
		numberOfNodes++;
		
		double loadfactor = this.loadFactor();
		
		if (loadfactor > 0.7) {
			this.reHash();
		}
		
	}
	
}
