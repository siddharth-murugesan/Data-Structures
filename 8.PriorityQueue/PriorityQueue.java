import java.util.ArrayList;

// MAX HEAP or MAX PRIORITYQUEUE

public class PriorityQueue {
	
    private ArrayList<Integer> heap;
    
    PriorityQueue() {
        heap = new ArrayList<>();
    }
    
	public int getSize() {
        
        return heap.size();
    }
    
    public boolean isEmpty() {
        
        return heap.size() == 0;
    }
    
    public int getMax() {
        if (this.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        
        return heap.get(0);
    }
    
    public void insert(int element) {
        
        int childIndex = heap.size();
        heap.add(element);
        int parentIndex = (childIndex - 1)/2;
        
        while (childIndex > 0) {
            if (heap.get(childIndex) > heap.get(parentIndex)) {
                int tmp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, tmp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1)/2;
            }
            else {
                break;
            }
        }
    }
    
    public int removeMax() {
        if (this.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        
        int maxElement = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        
        int parentIndex = 0;
        int leftChildIndex = 2*parentIndex + 1, rightChildIndex = 2*parentIndex + 2;
        
        while(leftChildIndex < heap.size()) {
            int maxIndex = parentIndex;
            
            if (heap.get(maxIndex) < heap.get(leftChildIndex)) {
                maxIndex = leftChildIndex;
            }
            
            if (rightChildIndex < heap.size() && heap.get(maxIndex) < heap.get(rightChildIndex)) {
                maxIndex = rightChildIndex;
            }
            
            if (parentIndex == maxIndex) {
                break;
            }
            
            int tmp = heap.get(maxIndex);
            heap.set(maxIndex, heap.get(parentIndex));
            heap.set(parentIndex, tmp);
            
            parentIndex = maxIndex;
            leftChildIndex = 2*parentIndex + 1;
            rightChildIndex = 2*parentIndex + 2;
        }
        
        return maxElement;
    }
}