package com.qhit.zdgl.account.bean;

public class Account {
	private int accountId;
	private int providerId;
	private double totalPrice;
	private int isPayed;
	private String accountDate;
	private int goodsId;
	private int businessNum;
	private String providerName;
	private String goodsName;
	private String goodsIntro;
	public Account(int accountId, int providerId, double totalPrice,
			int isPayed, String accountDate, int goodsId, int businessNum,
			String providerName, String goodsName, String goodsIntro) {
		this.accountId = accountId;
		this.providerId = providerId;
		this.totalPrice = totalPrice;
		this.isPayed = isPayed;
		this.accountDate = accountDate;
		this.goodsId = goodsId;
		this.businessNum = businessNum;
		this.providerName = providerName;
		this.goodsName = goodsName;
		this.goodsIntro = goodsIntro;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(int providerId, double totalPrice, int isPayed,
			String accountDate, int goodsId, int businessNum) {
		this.providerId = providerId;
		this.totalPrice = totalPrice;
		this.isPayed = isPayed;
		this.accountDate = accountDate;
		this.goodsId = goodsId;
		this.businessNum = businessNum;
	}
	
	public Account(int accountId, int providerId, double totalPrice,
			int isPayed, String accountDate, int goodsId, int businessNum) {
		this.accountId = accountId;
		this.providerId = providerId;
		this.totalPrice = totalPrice;
		this.isPayed = isPayed;
		this.accountDate = accountDate;
		this.goodsId = goodsId;
		this.businessNum = businessNum;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getIsPayed() {
		return isPayed;
	}
	public void setIsPayed(int isPayed) {
		this.isPayed = isPayed;
	}
	public String getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(String accountDate) {
		this.accountDate = accountDate;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getBusinessNum() {
		return businessNum;
	}
	public void setBusinessNum(int businessNum) {
		this.businessNum = businessNum;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsIntro() {
		return goodsIntro;
	}
	public void setGoodsIntro(String goodsIntro) {
		this.goodsIntro = goodsIntro;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", providerId=" + providerId
				+ ", totalPrice=" + totalPrice + ", isPayed=" + isPayed
				+ ", accountDate=" + accountDate + ", goodsId=" + goodsId
				+ ", businessNum=" + businessNum + ", providerName="
				+ providerName + ", goodsName=" + goodsName + ", goodsIntro="
				+ goodsIntro + "]";
	}
	
}
