package co.edu.unbosque.controller;

import co.edu.unbosque.view.Console;

public class Controller {
	
	private Console c;

	public Controller() {
		
		c = new Console();

	}

	public void run() {

		ciclo1: while (true) {

			c.printLine("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			c.printLine("\n---Welcome To Carelibro, the social network that makes the difference---");
			c.printLine("\n\n1. Add users");
			c.printLine("2. Add friend to an account");
			c.printLine("3. Check if two users have direct or indirect messaging");
			c.printLine("4. Check the degree of friendship between two users");
			c.printLine("5. Check if there are any disconnected users.");
			c.printLine("6. Exit");
			c.printLine("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			ciclo2: while (true) {

				int op = c.readInt();
				switch (op) {
				case 1: {
					c.printLine("---Add users---");
					c.burnLine();
					c.printLine("Please, enter your name:");
					String name = c.readLine();			
					c.printLine("Please, enter a password:");
					String password = c.readLine();			
					c.printLine("User added successfully!");
					break ciclo2;
				}

				case 2: {

					c.printLine("--- Add friend to an account---");
					c.burnLine();
					c.printLine("\n\n1. Enter the name of the account to which you want to add a friend");
					String name = c.readLine();
					c.printLine("2. Enter the name of the friend you want to add to this account");
					String nameFriend = c.readLine();
					c.printLine("Friend added successfully!");
//Falta agregar función para agregar amigos
					break ciclo2;
					}


				case 3: {
					c.printLine("---Check if two users have direct or indirect messaging---");
					c.burnLine();
					c.printLine("Enter the name of the first user");
					String nameUser1 = c.readLine();
					c.printLine("Enter the name of the second user");
					String nameUser2 = c.readLine();
					
//Falta agregar función para determinar si los usuarios se escriben o no
					//if(usuariosSeEscriben){
					//    c.printLine("Users write direct messages to each other");
				//    }else{
				//        c.printLine("Users do not write direct messages");
				//
				//    }
					break ciclo2;
				}
				case 4: {
					
					c.printLine("---Check the degree of friendship between two users---");
					c.burnLine();
					c.printLine("Enter the name of the first user:");
					String nameUser1 = c.readLine();
					c.printLine("Enter the name of the second user:");
					String nameUser2 = c.readLine();
					
//Falta agregar función para determinar el grado de amistad entre los usuarios
					break ciclo2;
				}

				case 5: {
					c.printLine("---Check if there are any disconnected users---");
					c.burnLine();
					c.printLine("Enter the name of the user you want to see if they have friends or not:");
					String nameUser1 = c.readLine();
					
					
//Falta agregar función para determinar si un usuario es desconexo(no tiene amigos) 
					break ciclo2;
				}
				case 6: {
					c.printLine("The program was closed correctly. "
							+ "\n\nWe hope to have it again soon in our application, the only one that makes the difference.");
					System.exit(0);

					break ciclo2;
				}
				}
			}
		}
	}
	
}
