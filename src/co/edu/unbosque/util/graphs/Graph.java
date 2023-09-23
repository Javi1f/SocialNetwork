package co.edu.unbosque.util.graphs;

import co.edu.unbosque.util.simplelist.MyLinkedList;

public class Graph {
	private MyLinkedList<Vertex<?>> listOfNodes;
	
	public Graph() {
		listOfNodes= new MyLinkedList<Vertex<?>>();
	}
	
	public void addVertex(Vertex<?> v) {
		listOfNodes.addLast(v);
	}

	public MyLinkedList<Vertex<?>> getListOfNodes() {
		return listOfNodes;
	}

	public void setListOfNodes(MyLinkedList<Vertex<?>> listOfNodes) {
		this.listOfNodes = listOfNodes;
	}
	
	@Override
	public String toString() {
		return "lista de nodos en el grafo: "+listOfNodes+" \n";
	}
	
}
