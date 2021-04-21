import org.junit.Test;


import static org.junit.Assert.*;

public class VectorHeapTest {

    @Test
    public void remove() {
        VectorHeap<Paciente> vHeap = new VectorHeap<Paciente>();
        Paciente p1 = new Paciente("Juan", "Gripe", "A");
        Paciente p2 = new Paciente("Luis", "Tos", "B");

        vHeap.add(p1);
        vHeap.add(p2);

        Paciente temp = vHeap.remove();

        assertEquals(temp, p1);

    }

    @Test
    public void add() {
    }
}