package co.edu.unbosque.util.doublelist;

public class DNode<T> {

	private DNode<T> next;
	private DNode<T> prev;
	private T info;

	public DNode() {
	}

	public DNode(T info) {
		this(null, null, info);
	}

	public DNode(DNode<T> next, DNode<T> prev, T info) {
		this.next = next;
		this.prev = prev;
		this.info = info;
	}

	public DNode<T> getNext() {
		return next;
	}

	public void setNext(DNode<T> next) {
		this.next = next;
	}

	public DNode<T> getPrev() {
		return prev;
	}

	public void setPrev(DNode<T> prev) {
		this.prev = prev;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "(" + this.next + ", " + this.prev + ", " + this.info + ")";
	}

}
