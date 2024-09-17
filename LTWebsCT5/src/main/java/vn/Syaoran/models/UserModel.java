package vn.Syaoran.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id;
	private String email;
	private String userName;
	private String fullName;
	private String passWord;
	private String Images;
	private int roleid;
	private String phone;
	private Date createdDate;
	
	
	
	public UserModel() {
		super();
	}


	public UserModel(int id, String username, String password, String images, String fullname, String email,
			String phone, int roleid, Date createdate) {
		super();
		this.id = id;
		this.userName = username;
		this.passWord = password;
		this.Images = images;
		this.fullName = fullname;
		this.email = email;
		this.phone = phone;
		this.roleid = roleid;
		this.createdDate = createdate;
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
