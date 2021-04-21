/*
 *  Nombre: Daniel Gonzalez Carrillo
 *  Interfaz: PriorityQueue
 *  Modificacion: 21.04.2021
 *  Descripcion: Interfaz que permite definir las acciones del ADT Priority Queue.
 *
 */


public interface PriorityQueue<E> {

    /**Pre: Se valida que la cola no este vacia.*/
    /**Post: Se devuelve el valor mas pequeño de la cola.*/
    public E getFirst();

    /**Pre: Se valida que la cola no esté vacía.*/
    /**Post: Se elimina el valor más pequeño del heap y se devuelve.*/
    public E remove();

    /**Post: Se añade un nuevo valor a la cola.*/
    public void add(E value);

    /**Post: Se determina si la cola esta vacia.*/
    public boolean isEmpty();

    /**Post: Se retorna el tamaño de la cola.*/
    public int size();

    /**Post: Se hace un reset a la cola.*/
    public void clear();
}
