package co.edu.unbosque.util.simplelist;

public class MyLinkedList<E> {

	protected Node<E> first;

	public MyLinkedList() {
		this.first = null;
	}

	public Node<E> getFirst() {
		return first;
	}

	public void setFirst(Node<E> first) {
		this.first = first;
	}

	public boolean isEmpty() {
		return (this.first == null ? true : false);
		// return (this.first == null);
	}

	public void add(E data) {
		Node<E> newNode = new Node<E>(data);
		newNode.setNext(this.first);
		this.first = newNode;
	}

	public void insert(E data, Node<E> prev) {
		if (prev != null) {
			Node<E> newNode = new Node<E>(data);
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);
		}
	}

	public void addLast(E data) {
		Node<E> lastNode = getLastNode();
		if (lastNode != null) {
			insert(data, lastNode);
		} else if (lastNode == null) {
			// Lista vacia
			this.first = new Node<E>(data);
		}

	}

	public Node<E> getLastNode() {
		Node<E> currentNode = this.first;
		while (currentNode != null && currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}

	public int size() {
		int size = 0;
		Node<E> currentNode = this.first;
		while (currentNode != null) {
			size++;
			currentNode = currentNode.getNext();
		}
		return size;
	}

	// Elimina el primer nodo, lo que obliga a todos los demas nodos a moverse hacia
	// atras
	public E extract() {
		E data = null;
		if (this.first != null) {
			data = this.first.getData();
			first = this.first.getNext();
		}
		return data;
	}

	// Elimina x nodo, lo que obliga a juntar los dos nodos separados por el que se
	// extrajo
	public E extract(Node<E> prev) {
		E data = null;
		if (prev != null && prev.getNext() != null) {
			data = prev.getNext().getData();
			prev.setNext(prev.getNext().getNext());
		}
		return data;
	}

	// Elimina el ultimo nodo
	public E extractLast() {
		E data = null;
		Node<E> currentNode = this.first;
		int listSize = size();
		if (!isEmpty()) {
			if (listSize == 1) {
				data = currentNode.getData();
				this.first = null;
			} else {
				Node<E> prevLastNode = get(listSize - 2);
				data = extract(prevLastNode);
			}
		}
		return data;
	}

	// Obtiene el dato dada la posicion
	public Node<E> get(int index) {
		Node<E> targetNode = null;
		Node<E> currentNode = this.first;
		int counter = 0;

		if (index < 0 || index >= size())
			return null;

		while (currentNode != null && counter < index) {
			counter++;
			currentNode = currentNode.getNext();
		}

		if (currentNode != null)
			targetNode = currentNode;
		return targetNode;
	}

	public void remove(int index) {
		if (index < 0 || index >= size())
			return;
		if (index == 0) {
			if (this.first.getNext() != null)
				this.first = this.first.getNext();
			else
				this.first = null;
		} else {
			get(index - 1).setNext(get(index).getNext());
		}
	}

	public void replace(int index, E data) {
		Node<E> newNode = new Node<E>(data, get(index).getNext());
		if (index < 0 || index >= size())
			return;
		if (index == 0)
			this.first = newNode;
		else
			get(index - 1).setNext(newNode);
	}

	// Obtiene la posicion dado el dato
	public int indexOf(E data) {
		Node<E> currentNode = this.first;
		int dataPos = -1;
		if (!isEmpty()) {
			dataPos = 0;
			while (currentNode != null && !(currentNode.getData().equals(data))) {
				dataPos++;
				currentNode = currentNode.getNext();
			}
		}
		return dataPos;
	}

	@Override
	public String toString() {
		String textList = "";
		Node<E> currentNode = this.first;
		while (currentNode != null) {
			textList += currentNode.getData().toString();
			if (currentNode.getNext() != null) {
				textList += " -> ";
			}
			currentNode = currentNode.getNext();
		}
		return textList;

	}

}
