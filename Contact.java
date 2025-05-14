package ContactManagementSystem;

public class Contact {
	
	private int id;
	private String name;
	private String num;
	private String email;
	public Contact(int id, String name, String num, String email) {
		
		this.id = id;
		this.name = name;
		this.num = num;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ID:" + id +", Name:" +name+ ", Number:" +num+ ", Email:" +email;
	}


}
