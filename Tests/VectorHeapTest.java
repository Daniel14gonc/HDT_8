import org.junit.Test;


import static org.junit.Assert.*;

public class VectorHeapTest {

    @Test
    public void remove() {
        VectorHeap<Integer> vHeap = new VectorHeap<Integer>();
        vHeap.add(2);
        vHeap.add(1);
        vHeap.add(3);
        vHeap.add(-1);
        vHeap.add(-50);

        Integer temp = vHeap.remove();

        assertEquals(temp.intValue(), -50);

    }

    @Test
    public void add() {
    }
}