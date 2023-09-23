package co.edu.unbosque.util.stackqueue;

public interface Stack<T> {

	public void push(T info); // Insertar al final de la pila.
	
	public T pop(); // Sacar al final de la pila.
	
	public T peek(); // Mostra el dato arriba de la pila.
	
	public int size();
	
}
