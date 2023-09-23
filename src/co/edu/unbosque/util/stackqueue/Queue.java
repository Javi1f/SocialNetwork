package co.edu.unbosque.util.stackqueue;

public interface Queue<T> {

	public void enqueue(T info); // Insertar en la cola.

	public T dequeue(); // Sacar de la cola.
	
	public T peek(); // Mostrar el dato al principio de la cola.
	
	public int size();

}
