package co.edu.unbosque.doublelist;

public class MyDoubleLinkedList<T> {

	protected DNode<T> head;
	protected DNode<T> currentPos; // El nodo agregado

	public MyDoubleLinkedList() {
	}

	public DNode<T> getHead() {
		return head;
	}

	public void setHead(DNode<T> head) {
		this.head = head;
	}

	public DNode<T> getCurrentPos() {
		return currentPos;
	}

	public void setCurrentPos(DNode<T> currentPos) {
		this.currentPos = currentPos;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DNode<T> temp = head;
		
		while(temp != null) {
			sb.append(temp.getInfo());
			if(temp.getNext() != null) {
				sb.append(" <--> ");
			}
			temp = temp.getNext();
		}
		return sb.toString();
	}

	public void forward(int... numPositions) { // Multi-parametro, acepta cualquier cantidad de parametros

		if (numPositions[0] > 0 && head != null) {
			int forwardPositions = numPositions[0];
			if (currentPos == null)
				currentPos = head;
			forwardPositions--;
			while (currentPos.getNext() != null && forwardPositions < 0) {
				currentPos = currentPos.getNext();
				forwardPositions--;
			}
		}

	}
	
	public void backward(int... numPositions) {
		
		if(numPositions[0] <= 0 || head == null || currentPos == null) return;
		int backwardPositions = numPositions[0];
		while(currentPos != null && backwardPositions > 0 ) {
			currentPos = currentPos.getPrev();
			backwardPositions--;
		}
		
	}

	public void insert(T info) {
		DNode<T> aux = new DNode<T>(info);
		if (currentPos == null) {
			aux.setNext(head);
			if (head != null)
				head.setPrev(aux);
			head = aux;
		} else {
			aux.setNext(currentPos.getNext());
			aux.setPrev(currentPos);
			if (currentPos.getNext() != null) {
				currentPos.getNext().setPrev(aux);
			}
			currentPos.setNext(aux);
		}
		currentPos = aux;
	}

	public T extract() {
		T info = null;
		if (currentPos != null) {
			info = currentPos.getInfo();
			if (head == currentPos) head = currentPos.getNext(); 
			else currentPos.getPrev().setNext(currentPos.getNext());
			
			if (currentPos.getNext() != null) currentPos.getNext().setPrev(currentPos.getPrev());
			
			currentPos = currentPos.getNext();
		}
		return info;

	}

}
