package com.fashion.legou.entity;

import java.io.Serializable;

import java.sql.Date;


public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date createdAt;
	private Date updatedAt;
	private String creator;
	private String modifier;
    private String username;  
    private String userPwd;
    private Long roleId;
    private String lastLoginTime;
    private Long roleType;
    private Long disableFlag;
    private boolean loginStatus;
    private String email;
    private String lastname;
    
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Long getRoleType() {
		return roleType;
	}
	public void setRoleType(Long roleType) {
		this.roleType = roleType;
	}
	
	public Long getDisableFlag() {
		return disableFlag;
	}
	public void setDisableFlag(Long disableFlag) {
		this.disableFlag = disableFlag;
	}
	public boolean isLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}
	

	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", creator=" + creator
				+ ", modifier=" + modifier + ", username=" + username + ", userPwd=" + userPwd + ", roleId=" + roleId
				+ ", lastLoginTime=" + lastLoginTime + ", roleType=" + roleType + ", disableFlag=" + disableFlag
				+ ", loginStatus=" + loginStatus + ", email=" + email + "]";
	}
	

    
}
