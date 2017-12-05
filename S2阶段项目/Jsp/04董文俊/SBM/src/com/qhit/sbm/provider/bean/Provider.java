package com.qhit.sbm.provider.bean;

/**
 * @author Dong
 * 供应商
 */
public class Provider {
	private int providerId;//id
	private String providerName = "";//名字
	private String providerDetail = "";//描述
	private String contact = "";//联系人
	private String telephone = "";//电话
	private String facsimile = "";//传真
	private String address = "";//地址
	
	public Provider() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Provider(int providerId, String providerName, String providerDetail,
			String contact, String telephone, String facsimile, String address) {
		super();
		this.providerId = providerId;
		this.providerName = providerName;
		this.providerDetail = providerDetail;
		this.contact = contact;
		this.telephone = telephone;
		this.facsimile = facsimile;
		this.address = address;
	}

	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getProviderDetail() {
		return providerDetail;
	}
	public void setProviderDetail(String providerDetail) {
		this.providerDetail = providerDetail;
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
