package com.kh.movie.vo;

public class Member {
	private int userNo;
	private String id;
	private String pwd;
	private String name;
	private String hp;
	
	public Member() {
		super();
	}

	public Member(int userNo, String id, String pwd, String name, String hp) {
		super();
		this.userNo = userNo;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.hp = hp;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	@Override
	public String toString() {
		return userNo + ", " + id + ", " + pwd + ", " + name + ", " + hp;
	}
	
	
	
	
	
}
