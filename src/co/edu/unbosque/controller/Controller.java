package co.edu.unbosque.controller;

import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.persistence.UserDAO;
import co.edu.unbosque.util.algorithm.DepthFirstSearch;
import co.edu.unbosque.util.graphs.Edge;
import co.edu.unbosque.util.graphs.Vertex;
import co.edu.unbosque.util.simplelist.MyLinkedList;
import co.edu.unbosque.view.Console;
import co.edu.unbosque.view.Sonido;

public class Controller {

	private UserDAO userDAO;
	private MyLinkedList<Vertex<UserDTO>> listNodes;
	private DepthFirstSearch dfs;
	private Sonido sound;

	public Controller() {

		userDAO = new UserDAO();
		listNodes = new MyLinkedList<Vertex<UserDTO>>();
		sound = new Sonido();

	}

	public void run() {
		playMusica(0);
		ciclo1: while (true) {
			
			
			
			Console.printLine("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			Console.printLine("\n---Welcome To Carelibro, the social network that makes the difference---");
			Console.printLine("\n----------------------------Options----------------------------                      ");	
			Console.print("                                                               |");
			Console.printLine("\n1. Add users.                                                  |");
			Console.printLine("2. Add friend to an account.                                   |");
			Console.printLine("3. Check if two users have direct or indirect messaging.       |");
			Console.printLine("4. Check the degree of friendship between two users.           |");
			Console.printLine("5. Check if there are any disconnected users.                  |");
			Console.printLine("6. Exit.                                                       |");
			Console.print("                                                               |");
			Console.printLine("\n---------------------------------------------------------------                      ");	
			Console.print("Please, enter the option you want to use:"); int op = Console.readInt();
			Console.printLine("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

			ciclo2: while(true) {
				
				

				
				switch (op) {
				case 1: {
					Console.printLine("--------Add users--------");
					Console.burnLine();
					Console.printLine("\nPlease, enter your name:");
					String name = Console.readLine();
					Console.printLine("Please, enter a password:");
					String password = Console.readLine();
					Console.printSuccessLine("User added successfully!");
					UserDTO newUser = new UserDTO(name, password, new MyLinkedList<UserDTO>());
					listNodes.addLast(new Vertex<UserDTO>(newUser));
					userDAO.create(newUser);

					break ciclo2;
				}

				case 2: {

					if (listNodes.size() == 0 || listNodes.size() == 1) {
						Console.printErr("No friends to add (single user or no users yet).\n");
						break ciclo2;
					}
					Console.printLine("--------------------------Add friend to an account-----------------------");
					Console.burnLine();
					Console.printLine("\n1. Enter the name of the account to which you want to add a friend:");
					String name = Console.readLine();
					Console.printLine("2. Enter the name of the friend you want to add to this account:");
					String nameFriend = Console.readLine();
					Console.printSuccessLine("Friend added successfully!");

					int index = 0;

					for (int i = 0; i < listNodes.size(); i++) {
						if (listNodes.get(i).getData().getInfo().getName().equalsIgnoreCase(name)) {
							index = i;
						}
					}
					int indexFriend = 0;
					for (int i = 0; i < listNodes.size(); i++) {
						if (listNodes.get(i).getData().getInfo().getName().equalsIgnoreCase(nameFriend)) {
							indexFriend = i;
						}
					}

					if (userDAO.getUsers().get(indexFriend).getFriends().contains(userDAO.getUsers().get(index))) {
						Console.printErr(
								"Both users cannot be on the same friends list, it is enough for one to add the other one.\n");
						break ciclo2;
					} else if (index == indexFriend || name.equalsIgnoreCase(nameFriend)) {
						Console.printErr("You cannot add yourself as a friend.\n");
						break ciclo2;
					}

					userDAO.getUsers().get(index).addFriend(userDAO.getUsers().get(indexFriend));
					userDAO.getUsers().get(indexFriend).addFriend(userDAO.getUsers().get(index));
					listNodes.get(index).getData()
							.addEdge(new Edge(listNodes.get(index).getData(), listNodes.get(indexFriend).getData(), 1));
					;
					listNodes.get(indexFriend).getData()
							.addEdge(new Edge(listNodes.get(indexFriend).getData(), listNodes.get(index).getData(), 1));
					;

					break ciclo2;
				}

				case 3: {

					if (listNodes.size() == 0 || listNodes.size() == 1) {
						Console.printErr("Single user or no users yet.\n");
						break ciclo2;
					}
					Console.printLine("---Check if two users have direct or indirect messaging---");
					Console.burnLine();
					Console.printLine("\nEnter the name of the first user:");
					String nameUser1 = Console.readLine();
					Console.printLine("Enter the name of the second user:");
					String nameUser2 = Console.readLine();

					int index = 0;

					for (int i = 0; i < listNodes.size(); i++) {
						if (listNodes.get(i).getData().getInfo().getName().equalsIgnoreCase(nameUser1)) {
							index = i;
						}
					}
					int indexFriend = 0;
					for (int i = 0; i < listNodes.size(); i++) {
						if (listNodes.get(i).getData().getInfo().getName().equalsIgnoreCase(nameUser2)) {
							indexFriend = i;
						}
					}
					if (index == indexFriend || nameUser1.equalsIgnoreCase(nameUser2)) {
						Console.printErr("You are indeed connected to yourself.\n");
						break ciclo2;
					}

					dfs = new DepthFirstSearch(listNodes.get(index).getData(), listNodes.get(indexFriend).getData());

					String[] count = dfs.runSearch().split(",");
					boolean cont = false;
					for (int i = 0; i < count.length; i++) {
						if (count[i].equals(userDAO.getUsers().get(indexFriend).getName())) {
							cont = true;
						}
					}
					if (!cont) {
						Console.printErrLine("No connection has been found between them.");
						break ciclo2;
					}
					if ((count.length-2) == 1) {
						if (listNodes.get(index).getData().getInfo().getFriends().isEmpty()
								|| listNodes.get(indexFriend).getData().getInfo().getFriends().isEmpty()) {
							Console.printErrLine("No connection has been found between them.");
							break ciclo2;
						}
						Console.printSuccess("Users have direct communication.\n");
					} else if ((count.length-2) > 1) {
						Console.printSuccess("Users have indirect communication.\n");
					}

					break ciclo2;
				}
				case 4: {

					if (listNodes.size() == 0 || listNodes.size() == 1) {
						Console.printErr("Single user or no users yet.\n");
						break ciclo2;
					}

					Console.printLine("---Check the degree of friendship between two users---");
					Console.burnLine();
					Console.printLine("\nEnter the name of the first user:");
					String nameUser1 = Console.readLine();
					Console.printLine("Enter the name of the second user:");
					String nameUser2 = Console.readLine();

					int index = 0;

					for (int i = 0; i < listNodes.size(); i++) {
						if (listNodes.get(i).getData().getInfo().getName().equalsIgnoreCase(nameUser1)) {
							index = i;
						}
					}
					int indexFriend = 0;
					for (int i = 0; i < listNodes.size(); i++) {
						if (listNodes.get(i).getData().getInfo().getName().equalsIgnoreCase(nameUser2)) {
							indexFriend = i;
						}
					}
					if (index == indexFriend || nameUser1.equalsIgnoreCase(nameUser2)) {
						Console.printErr("You are indeed connected to yourself.\n");
						break ciclo2;
					}

					dfs = new DepthFirstSearch(listNodes.get(index).getData(), listNodes.get(indexFriend).getData());

					
					String[] count = dfs.runSearch().split(",");
					boolean cont = false;
					for (int i = 0; i < count.length; i++) {
						if (count[i].equals(userDAO.getUsers().get(indexFriend).getName())) {
							cont = true;
						}
					}
					if (!cont) {
						Console.printErrLine("No connection has been found between them.\n");
						break ciclo2;
					}

					Console.printSuccessLine("The degree of friendship is: " + (count.length-2));

					break ciclo2;
				}

				case 5: {

					if (listNodes.size() == 2 || listNodes.size() == 1) {
						Console.printErr("Single user or no users yet.\n");
						break ciclo2;
					}

					Console.printLine("---Check if there are any disconnected users---");
					Console.burnLine();

					String temp = "Disconnected Users:";

					for (int i = 0; i < userDAO.getUsers().size(); i++) {
						if (userDAO.getUsers().get(i).getFriends().isEmpty()) {
							temp += "\n " + userDAO.getUsers().get(i).getName();
						}
					}

					Console.printLine(temp);

					break ciclo2;
				}
				case 6: {
					Console.printLine("The program was closed correctly. "
							+ "\n\nWe hope to have it again soon in our application, the only one that makes the difference.");

					break ciclo1;
				}
			}
			

			}
		}
		
		
	}
	public void playMusica(int i) {

		sound.setFile(i);
		sound.play();
		sound.loop();
	}

}
