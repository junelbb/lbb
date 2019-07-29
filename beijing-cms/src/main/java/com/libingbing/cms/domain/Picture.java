package com.libingbing.cms.domain;

public class Picture {
	private String pictureFile;
	private String pictureDesc;
	public String getPictureFile() {
		return pictureFile;
	}
	public void setPictureFile(String pictureFile) {
		this.pictureFile = pictureFile;
	}
	public String getPictureDesc() {
		return pictureDesc;
	}
	public void setPictureDesc(String pictureDesc) {
		this.pictureDesc = pictureDesc;
	}
	public Picture(String pictureFile, String pictureDesc) {
		super();
		this.pictureFile = pictureFile;
		this.pictureDesc = pictureDesc;
	}
	public Picture() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Picture [pictureFile=" + pictureFile + ", pictureDesc="
				+ pictureDesc + "]";
	}
	
	
	
}
