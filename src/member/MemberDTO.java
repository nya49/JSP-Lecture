package member;

public class MemberDTO {
	private int id;
	private String pass;
	private String name;
	private String birthday;
	private String address;
	
	public MemberDTO() {
	}
	
	public MemberDTO(int id, String pass, String name, String birthday, String address) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
	}
	
	public MemberDTO(String pass, String name, String birthday, String address) {
		this.pass = pass;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", pass=" + pass + ", name=" + name + ", birthday=" + birthday + ", address=" + address + "]";
	}
}
