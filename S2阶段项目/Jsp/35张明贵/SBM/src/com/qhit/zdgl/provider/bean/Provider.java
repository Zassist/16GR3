package com.qhit.zdgl.provider.bean;

public class Provider {
	private int providerId;
	private String providerName;
	private String providerDetail;
	private String contact;
	private String telephone;
	private String facsimle;
	private String address;
	public Provider(int providerId, String providerName, String providerDetail,
			String contact, String telephone, String facsimle, String address) {
		super();
		this.providerId = providerId;
		this.providerName = providerName;
		this.providerDetail = providerDetail;
		this.contact = contact;
		this.telephone = telephone;
		this.facsimle = facsimle;
		this.address = address;
	}
	public Provider() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getFacsimle() {
		return facsimle;
	}
	public void setFacsimle(String facsimle) {
		this.facsimle = facsimle;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Provider [providerId=" + providerId + ", providerName="
				+ providerName + ", providerDetail=" + providerDetail
				+ ", contact=" + contact + ", telephone=" + telephone
				+ ", facsimle=" + facsimle + ", address=" + address + "]";
	}
	
}
