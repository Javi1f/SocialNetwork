package co.edu.unbosque.util.stackqueue;

import co.edu.unbosque.doublelist.DNode;
import co.edu.unbosque.doublelist.DequeList;

public class StackImp<T> implements Stack<T> {

	private DequeList<T> data;

	public StackImp() {
		data = new DequeList<T>();
	}

	@Override
	public void push(T info) {
		this.data.insertFirst(info);
	}

	@Override
	public T pop() {
		return this.data.removeFirst();
	}

	@Override
	public T peek() {
		T temp = this.data.removeFirst();
		this.data.insertFirst(temp);
		return temp;
	}

	@Override
	public int size() {
		return this.data.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Top\n");
		DNode<T> aux = this.data.getHead();
		for (int i = 0; i < this.data.size(); i++) {
			sb.append("[" + aux.getInfo() + "]\n");
			if (aux == this.data.getTail())
				break;
			aux = aux.getNext();
		}
		sb.append("Bottom\n");
		sb.append("----------");
		return sb.toString();
	}

}
