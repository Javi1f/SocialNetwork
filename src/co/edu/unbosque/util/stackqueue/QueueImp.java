package co.edu.unbosque.util.stackqueue;

import co.edu.unbosque.doublelist.DNode;
import co.edu.unbosque.doublelist.DequeList;

public class QueueImp<T> implements Queue<T> {

	private DequeList<T> data;

	public QueueImp() {
		data = new DequeList<T>();
	}

	@Override
	public void enqueue(T info) {
		this.data.insertFirst(info);
	}

	@Override
	public T dequeue() {
		return this.data.removeLast();
	}

	@Override
	public T peek() {
		T temp = this.data.removeLast();
		this.data.insertLast(temp);
		return temp;
	}

	@Override
	public int size() {
		return this.data.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Back [");
		DNode<T> aux = this.data.getHead();
		for (int i = 0; i < this.data.size(); i++) {
			sb.append(aux.getInfo());
			if (aux == this.data.getTail())
				break;
			sb.append(" - ");
			aux = aux.getNext();
		}
		sb.append("] Front\n");
		sb.append("----------");
		return sb.toString();
	}

}
