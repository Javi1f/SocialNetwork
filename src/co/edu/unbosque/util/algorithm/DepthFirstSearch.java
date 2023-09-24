package co.edu.unbosque.util.algorithm;

import co.edu.unbosque.util.graphs.Edge;
import co.edu.unbosque.util.graphs.Vertex;
import co.edu.unbosque.util.simplelist.MyLinkedList;
import co.edu.unbosque.util.stackqueue.StackImp;

public class DepthFirstSearch extends AbstractSearch {

	private StackImp<Vertex<?>> nodeStack;
	private MyLinkedList<Vertex<?>> visitedNodes;

	public DepthFirstSearch(Vertex<?> sourceVertex, Vertex<?> destinationVertex) {
		super(sourceVertex, destinationVertex);

	}

	public StackImp<Vertex<?>> getNodeStack() {
		return nodeStack;
	}

	public void setNodeStack(StackImp<Vertex<?>> nodeStack) {
		this.nodeStack = nodeStack;
	}

	public MyLinkedList<Vertex<?>> getVisitedNodes() {
		return visitedNodes;
	}

	public void setVisitedNodes(MyLinkedList<Vertex<?>> visitedNodes) {
		this.visitedNodes = visitedNodes;
	}

	@Override
	public String runSearch() {

		nodeStack = new StackImp<Vertex<?>>();
		visitedNodes = new MyLinkedList<Vertex<?>>();

		if (this.sourceVertex.equals(this.destinationVertex)) {
//			System.out.println("Nodo destino encontrado a 0 de profundidad");
//			System.out.println(sourceVertex.getInfo());
			return sourceVertex.getInfo() + "";
		}

		nodeStack.push(this.sourceVertex);
//		System.out.println("Ruta a seguir para ubicar el nodo");

		String temp = "";
		while (nodeStack.size() != 0) {

			Vertex<?> current = nodeStack.pop();
			if (current.equals(this.destinationVertex)) {
//				System.out.println(destinationVertex.getInfo());
//				System.out.println("nodo buscado encontrado\n");
				return temp + "," + destinationVertex.getInfo();
			} else {
//				System.out.print(current.getInfo() + " -> ");
				temp += current.getInfo() + ",";
				visitedNodes.addLast(current);
				MyLinkedList<Edge> adjacents = current.getAdyacentEdges();
				for (int i = 0; i < adjacents.size(); i++) {
					Vertex<?> adjacentVertex = adjacents.get(i).getData().getDestination();

					if (!visitedNodes.contains(adjacentVertex)) {
						nodeStack.push(adjacentVertex);
					}

				}
			}
		}
		return temp;
	}

}
