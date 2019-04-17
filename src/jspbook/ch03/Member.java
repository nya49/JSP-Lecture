package jspbook.ch03;

import java.util.Objects;

public class Member {
	private int id;
	private String name;
	private String email;
	private String tel;

	
	public Member(String name, String email, String tel) {
		super();
		this.name = name;
		this.email = email;
		this.tel = tel;
	}

	public int getId() {
		if (tel != null) {
			id = Objects.hash(name, email, tel);
			System.out.println(toString());
		}
		return id;
	}

	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", tel=" + tel + "]";
	}
}
