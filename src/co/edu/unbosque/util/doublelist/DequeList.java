package co.edu.unbosque.util.doublelist;

public class DequeList<T> extends MyDoubleLinkedList<T> implements Deque<T> {

	private DNode<T> tail;
	private int size;

	public DequeList() {
		head = new DNode<T>();
		tail = new DNode<T>();
		head.setNext(tail);
		tail.setPrev(head);
		size = 0;
	}

	public DequeList(DNode<T> tail, int size) {
		super();
		this.tail = tail;
		this.size = size;
	}

	@Override
	public void insertLast(T info) {
		DNode<T> t = this.tail;
		DNode<T> temp = new DNode<T>();
		temp.setInfo(info);
		temp.setPrev(t);
		t.setNext(temp);
		this.tail = temp;
		if (size == 0)
			this.head = temp;
		size++;
	}

	@Override
	public T removeLast() {
		if (tail == null)
			return null;
		T value = this.tail.getInfo();
		this.tail = this.tail.getPrev();
		size--;
		return value;
	}

	@Override
	public void insertFirst(T info) {
		DNode<T> h = this.head;
		DNode<T> temp = new DNode<T>();
		temp.setInfo(info);
		temp.setNext(h);
		h.setPrev(temp);
		this.head = temp;
		if (size == 0)
			this.tail = temp;
		size++;
	}

	@Override
	public T removeFirst() {
		if (head == null)
			return null;
		T value = this.head.getInfo();
		this.head = this.head.getNext();
		size--;
		return value;
	}

	@Override
	public int size() {
		return size;
	}

	public DNode<T> getTail() {
		return tail;
	}

	public void setTail(DNode<T> tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Head [");
		DNode<T> aux = head;
		for(int i = 0; i < size; i++) {
			sb.append(aux.getInfo() + " - ");
			if(aux == tail) break;
			aux = aux.getNext();
		}
		sb.append("] Tail");
		return sb.toString();
	}
	
	

}
