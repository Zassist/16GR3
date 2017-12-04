package com.qhit.smb.User.bean;

public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private String userSex;
    private int userAge;
    private int telephone;
    private String address;
    private String pic;
    private int type;

	public User() {
		super();
	}

	public User(int userId, String userName, String userPassword, String userSex, int userAge, int telephone,
			String address, String pic, int type) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.userAge = userAge;
		this.telephone = telephone;
		this.address = address;
		this.pic = pic;
		this.type = type;
	}

	public User(String userName, String userPassword, String userSex, int userAge, int telephone,
			String address, String pic, int type) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.userAge = userAge;
		this.telephone = telephone;
		this.address = address;
		this.pic = pic;
		this.type = type;
	}

	public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserpassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUsersex(String userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserage(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}