package dto;

public class MemberDTO {
	private String userId;
	private String name;
	private String password;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	public MemberDTO(String userId, String name, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
	}
	
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "MemberDTO [userId=" + userId + ", name=" + name + ", password=" + password + "]";
	}	
}
