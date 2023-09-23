package co.edu.unbosque.doublelist;

public interface Deque<T> {

	public void insertLast(T info);
	
	public T removeLast();
	
	public void insertFirst(T info);
	
	public T removeFirst();
	
	public int size();
	
}
