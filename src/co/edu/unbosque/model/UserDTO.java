package co.edu.unbosque.model;

import co.edu.unbosque.util.simplelist.MyLinkedList;

public class UserDTO {

	private String name;
	private String password;
	private MyLinkedList<UserDTO> friends;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String name, String password, MyLinkedList<UserDTO> friends) {
		super();
		this.name = name;
		this.password = password;
		this.friends = friends;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MyLinkedList<UserDTO> getFriends() {
		return friends;
	}

	public void setFriends(MyLinkedList<UserDTO> friends) {
		this.friends = friends;
	}

	public void addFriend(UserDTO friend) {
		this.friends.add(friend);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Name: " + this.name);
		sb.append("List of Friends: ");
		this.friends.forEach(u -> sb.append("\n" + u.getName()));
		return this.name;
	}

}
