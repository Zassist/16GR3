package com.qhit.smb.Provide.bean;

public class Provider {
	//供应商id
	private int providerid;
	//供应商姓名
	private String providername;
	//供应商描述
	private String providerdetail;
	//联系人
	private String contact;
	//供应商电话
	private String telephone;
	//供应商传真
	private String facsimile;
	//供应商地址
	private String address;

	public Provider() {
		super();
	}

	public Provider(String providername, String providerdetail, String contact, String telephone, String facsimile,
			String address) {
		super();
		this.providername = providername;
		this.providerdetail = providerdetail;
		this.contact = contact;
		this.telephone = telephone;
		this.facsimile = facsimile;
		this.address = address;
	}

	public Provider(int providerid, String providername, String providerdetail, String contact, String telephone,
			String facsimile, String address) {
		super();
		this.providerid = providerid;
		this.providername = providername;
		this.providerdetail = providerdetail;
		this.contact = contact;
		this.telephone = telephone;
		this.facsimile = facsimile;
		this.address = address;
	}

	public int getProviderid() {
		return providerid;
	}

	public void setProviderid(int providerid) {
		this.providerid = providerid;
	}

	public String getProvidername() {
		return providername;
	}

	public void setProvidername(String providername) {
		this.providername = providername;
	}

	public String getProviderdetail() {
		return providerdetail;
	}

	public void setProviderdetail(String providerdetail) {
		this.providerdetail = providerdetail;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFacsimile() {
		return facsimile;
	}

	public void setFacsimile(String facsimile) {
		this.facsimile = facsimile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}