package co.edu.unbosque.util.algorithm;

import co.edu.unbosque.view.Console;
import co.edu.unbosque.util.graphs.Edge;
import co.edu.unbosque.util.graphs.Vertex;
import co.edu.unbosque.util.simplelist.MyLinkedList;
import co.edu.unbosque.util.stackqueue.QueueImp;

public class BreadthFirstSearch extends AbstractSearch {

	MyLinkedList<Vertex<?>> visitedNodes;

	public BreadthFirstSearch(Vertex<?> source, Vertex<?> destination) {
		super(source, destination);
		this.visitedNodes = new MyLinkedList<>();
	}

	@Override
	public int runSearch() {

		if (sourceVertex.equals(destinationVertex)) {
			Console.printSuccessLine("Objetico encontrado en la anchura 0");
			Console.printSuccessLine(sourceVertex.getInfo().toString());
			return 0;
		}

		QueueImp<Vertex<?>> queueOfNodes = new QueueImp<>();
		Console.printLine("Ruta para seguir y llegar al destino:");
		queueOfNodes.enqueue(sourceVertex);
		visitedNodes.addLast(sourceVertex);
		int count = 0;
		while (queueOfNodes.size() != 0) {

			Vertex<?> actual = queueOfNodes.dequeue();
			if (actual.equals(destinationVertex)) {
				Console.printSuccessLine(actual.getInfo().toString());
				Console.printSuccessLine("Nodo de destino encontrado");
				return count;
			} else {
				System.out.print(actual.getInfo() + "->");
				if (actual.getAdyacentEdges().isEmpty()) {
					continue;
				} else {
					MyLinkedList<Edge> adjacents = actual.getAdyacentEdges();
					count++;
					while (!adjacents.isEmpty()) {
						queueOfNodes.enqueue(adjacents.extract().getDestination());
					}

				}
			}
			visitedNodes.addLast(actual);

		}
		return -1;
	}

}
