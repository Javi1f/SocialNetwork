package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.UserDTO;

public class UserDAO {

	private ArrayList<UserDTO> users;

	public UserDAO() {
		users = new ArrayList<UserDTO>();
	}

	public ArrayList<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<UserDTO> users) {
		this.users = users;
	}

	public void create(Object o) {

		users.add((UserDTO) o);
	}

	public void update(int i, Object o) {
		users.set(i, (UserDTO) o);
	}

	public void delete(int i) {
		users.remove(i);
	}

	public String show() {

		StringBuilder sb = new StringBuilder();
		users.forEach(u -> sb.append(u.toString() + "\n"));

		return sb.toString();

	}

}
