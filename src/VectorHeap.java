/*
 *  Nombre: Daniel Gonzalez Carrillo
 *  Clase: VectorHeap
 *  Modificacion: 21.04.2021
 *  Descripcion: Clase que permite implementar una PriorityQueue por medio de la
 *               utilizacion de un vector.
 *
 */

import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    private Vector<E> vector;

    public VectorHeap(){
        vector = new Vector<E>();
    }

    @Override
    public E getFirst() {
        //Pre: Validar que la cola no este vacia.
        //Post: Retorna el primer valor de la cola, que es el que mas prioridad tiene.
        if(!isEmpty())
            return vector.get(0);

        return null;
    }

    @Override
    public E remove() {
        //Pre: Validar que la cola este vacia.
        //Post: Se cambia el ultimo valor de la cola por el primero y se reduce en uno su tamaño. Posteriormente se modifica
        //      el arbol para que vuelva a ser un heap.
        if(!isEmpty()){
            E minVal = getFirst();
            vector.set(0, vector.get(vector.size()-1));
            vector.remove(vector.size()-1);
            if(vector.size() > 1)
                pushDownRoot(0);
            return minVal;
        }

        return null;
    }

    private void pushDownRoot(int root){
        //Post: Se recorre toda la cola para evaluar si es necesario intercambiar valores al momento de eliminar el valor más pequeño.
        //      Se hace que el arbol resultante vuelva a ser un heap.
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
        //Post: Se añade un valor a la cola.
        vector.add(value);
        percolate(vector.size()-1);
    }

    @Override
    public boolean isEmpty() {
        //Post: Retorna si el heap esta vacio o no.
        return vector.isEmpty();
    }

    @Override
    public int size() {
        //Post: Retorna el tamaño del vector.
        return vector.size();
    }

    @Override
    public void clear() {
        //Post: Hace un reset del vector que almacena los datos.
        vector.clear();
    }

    protected static int left(int i){
        /**Post: Retorna la posicion del hijo izquierdo.*/
        return 2*i+1;
    }

    protected static int right(int i){
        /**Post: Retorna la posicion del hijo derecho.*/
        return 2*(i+1);
    }

    protected static int parent(int i){
        /**Post: Retorna la posicion del padre.*/
        return (i-1)/2;
    }

    protected void percolate(int leaf){
        /**Post: Evalua y modifica el arbol donde se almacenan datos para cambiar de posicion el valor ingresado y volverlo heap de nuevo.*/
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
