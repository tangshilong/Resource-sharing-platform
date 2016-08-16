package com.smates.dbc2.po;

import java.io.Serializable;

public class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String accountNumber;
	
    private String nickName;

    private String password;

    private Integer role;

    private String enable;

    private String createDate;
    
    private String eMail;

    public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


   
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User() {
	}
    
	@Override
	public String toString() {
		return "User [id=" + id + ", accountNumber=" + accountNumber + ", nickName=" + nickName + ", password="
				+ password + ", role=" + role + ", enable=" + enable + ", createDate=" + createDate + ", eMail=" + eMail
				+ "]";
	}
}