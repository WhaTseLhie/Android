package com.example.loveexam;

public class Person {
	private int image;
	private String txtName, txtNum;
	
	public Person(int image, String txtName, String txtNum) {
		super();
		this.image = image;
		this.txtName = txtName;
		this.txtNum = txtNum;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public String getTxtName() {
		return txtName;
	}

	public void setTxtName(String txtName) {
		this.txtName = txtName;
	}

	public String getTxtNum() {
		return txtNum;
	}

	public void setTxtNum(String txtNum) {
		this.txtNum = txtNum;
	}
}
