package co.edu.unbosque.model;

import java.util.ArrayList;

public class UserDTO {

	private String name;
	private String password;
	private ArrayList<UserDTO> friends;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String name, String password, ArrayList<UserDTO> friends) {
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

	public ArrayList<UserDTO> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<UserDTO> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Name: " + this.name);
		sb.append("List of Friends: " + this.friends.toString());
		return sb.toString();
	}

}
