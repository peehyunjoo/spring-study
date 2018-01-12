package com.zzu.domain;

public class SampleVO {
	private Integer mno;
	private String firsName;
	private String lastName;
	public Integer getMno() {
		return mno;
	}
	public void setMno(Integer mno) {
		this.mno = mno;
	}
	public String getFirsName() {
		return firsName;
	}
	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "SampleVO [mno=" + mno + ", firsName=" + firsName + ", lastName=" + lastName + "]";
	}
}
