import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    private Vector<E> vector;

    public VectorHeap(){
        vector = new Vector<E>();
    }

    @Override
    public E getFirst() {
        return vector.get(0);
    }

    @Override
    public E remove() {
        E minVal = getFirst();
        vector.set(0, vector.get(vector.size()-1));
        vector.remove(vector.size()-1);
        if(vector.size() > 1)
            pushDownRoot(0);

        return minVal;
    }

    private void pushDownRoot(int root){
        int heapSize = vector.size();
        E value = vector.get(root);
        while (root < heapSize){
            int childpos = left(root);

            if(childpos < heapSize){
                if(right(root) < heapSize && (vector.get(childpos+1).compareTo(vector.get(childpos)) < 0)){
                    childpos++;
                }

                if(vector.get(childpos).compareTo(vector.get(root)) < 0){
                    vector.set(root, vector.get(childpos));
                    root = childpos;
                }
                else{
                    vector.set(root, value);
                    return;
                }
            }
            else{
                vector.set(root, value);
                return;
            }
        }
    }

    @Override
    public void add(E value) {
        vector.add(value);
        percolate(vector.size()-1);
    }

    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }

    @Override
    public int size() {
        return vector.size();
    }

    @Override
    public void clear() {
        vector.clear();
    }

    protected static int left(int i){
        return 2*i+1;
    }

    protected static int right(int i){
        return 2*(i+1);
    }

    protected static int parent(int i){
        return (i-1)/2;
    }

    protected void percolate(int leaf){
        int parent = parent(leaf);
        E value = vector.get(leaf);
        while(leaf > 0 && value.compareTo(vector.get(parent)) < 0){
            E temp = vector.get(parent);
            vector.set(leaf, temp);
            leaf = parent;
            parent = parent(leaf);
        }

        vector.set(leaf, value);
    }
}
