
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

/** Class D-ary Heap **/
public class DHeap
{
    /** The number of children each node has **/
    private int d;
    private int heapSize;
    private Vertex[] heap;

    /** Constructor **/
    public DHeap(int capacity, int numChild)
    {
        heapSize = 0;
        d = numChild;
        heap = new Vertex[capacity + 1];
        Arrays.fill(heap, null);
    }

    /** Function to check if heap is empty **/
    public boolean isEmpty( )
    {
        return heapSize == 0;
    }

    /** Check if heap is full **/
    public boolean isFull( )
    {
        return heapSize == heap.length;
    }

    /** Clear heap */
    public void clear( )
    {
        heapSize = 0;
    }

    /** Function to  get index parent of i **/
    private int parent(int i)
    {
        return (i - 1)/d;
    }

    /** Function to get index of k th child of i **/
    private int kthChild(int i, int k)
    {
        return d * i + k;
    }

    /** Function to insert element */
    public void insert(Vertex x)
    {
        if (isFull( ) )
            throw new NoSuchElementException("Overflow Exception");
        /** Percolate up **/
        heap[heapSize++] = x;
        heapifyUp(heapSize - 1);
    }
    public int findIndex(Vertex v){
        for (int i = 0; i < heapSize; i++) {
            if (v == heap[i])
                return  i;
        }
        return -1;
    }
    /** Function to find least element **/
    public Vertex findMin( )
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return heap[0];
    }

    /** Function to delete element at an index **/
    public Vertex delete(int ind)
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        Vertex keyItem = heap[ind];
        heap[ind] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(ind);
        return keyItem;
    }

    /** Function heapifyUp  **/
    public void heapifyUp(int childInd)
    {
        Vertex tmp = heap[childInd];
        while (childInd > 0 && tmp.compareTo(heap[parent(childInd)]) < 0)
        {
            heap[childInd] = heap[ parent(childInd) ];
            childInd = parent(childInd);
        }
        heap[childInd] = tmp;
    }

    /** Function heapifyDown **/
    public void heapifyDown(int ind)
    {
        int child;
        Vertex tmp = heap[ ind ];

        while (kthChild(ind, 1) < heapSize)
        {
            child = minChild(ind);
            if (heap[child].compareTo(tmp) < 0)
                heap[ind] = heap[child];
            else
                break;
            ind = child;
        }
        heap[ind] = tmp;
    }

    /** Function to get smallest child **/
    private int minChild(int ind)
    {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k <= d) && (pos < heapSize))
        {
            if (heap[pos].compareTo(heap[bestChild]) < 0)
                bestChild = pos;
            pos = kthChild(ind, k++);
        }
        return bestChild;
    }

    /** Function to print heap **/
    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }
    public int getHeapSize(){
        return  this.heapSize;
    }
}
