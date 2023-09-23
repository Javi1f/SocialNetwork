package co.edu.unbosque.util.simplelist;

//<E> Generico permite crear un objeto de tal forma que los datos que pueda tener sea cualquiera.
public class Node <E>{

	private E data;
	private Node<E> next;
	
	public Node() {
	}
	
	//Cuando se vaya a crear el primer nodo, porque todavía no tiene siguiente (null)
	public Node(E data) {
		this(data, null); //Referencia al constructor completo (el de abajo)
	}

	//Cuando se vaya a crear otro nodo despues del primero
	public Node(E data, Node<E> next) {
		super();
		this.data = data;
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
	
	
	
}
