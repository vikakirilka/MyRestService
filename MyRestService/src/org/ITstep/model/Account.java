package org.ITstep.model;

public class Account {
	
	private String login;
	private long birthday;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public long getBirthday() {
		return birthday;
	}
	public void setBirthday(long birthday) {
		this.birthday = birthday;
	}
	public Account(String login, long birthday) {
		this.login = login;
		this.birthday = birthday;
	}
	public Account() {
		
	}
	

}
