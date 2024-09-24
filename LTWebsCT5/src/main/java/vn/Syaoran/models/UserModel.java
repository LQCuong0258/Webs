package vn.Syaoran.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id;
	private String fullName;
	private String userName;
	private String email;
	private String passWord;
	private String Images;
	private String phone;
	private int roleid;
	private Date createdDate;
	
	
	
	public UserModel() {
		super();
	}


	
	
	


	


	public UserModel(String fullName, String userName, String email, String passWord, String images, String phone,
			int roleid, Date createdDate) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.email = email;
		this.passWord = passWord;
		Images = images;
		this.phone = phone;
		this.roleid = roleid;
		this.createdDate = createdDate;
	}










	public UserModel(int id, String fullName, String userName, String email, String passWord, String images,
			String phone, int roleid, Date createdDate) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.userName = userName;
		this.email = email;
		this.passWord = passWord;
		Images = images;
		this.phone = phone;
		this.roleid = roleid;
		this.createdDate = createdDate;
	}










	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return passWord;
	}

	public void setPassword(String passWord) {
		this.passWord = passWord;
	}
	
	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int int1) {
		// TODO Auto-generated method stub
		
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getImages() {
		return Images;
	}

	public void setImages(String images) {
		Images = images;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName
				+ ", passWord=" + passWord + ", avatar=" + Images + ", roleID=" + roleid + ", phone=" + phone
				+ ", createdDate=" + createdDate + "]";
	}

	
	


	
	
	
	
	
	
	
	
}
