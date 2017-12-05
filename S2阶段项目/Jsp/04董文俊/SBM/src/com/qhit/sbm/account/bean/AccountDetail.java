package com.qhit.sbm.account.bean;

import java.util.Date;

public class AccountDetail {
	private int accountId;//账单编号
	private String goodsName;//商品名称
	private int goodsNum;//商品数量
	private int businessNum;//交易数量
	private float totalPrice;//交易金额
	private int isPayed;//是否付款
	private String providerName;//供应商名称
	private String goodsIntro;//商品描述
	private Date accountDate;//账单时间
	public AccountDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBusinessNum() {
		return businessNum;
	}
	public void setBusinessNum(int businessNum) {
		this.businessNum = businessNum;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getIsPayed() {
		return isPayed;
	}
	public void setIsPayed(int isPayed) {
		this.isPayed = isPayed;
	}
	public AccountDetail(int accountId, String goodsName, int goodsNum, int businessNum, float totalPrice, int isPayed,
			String providerName, String goodsIntro, Date accountDate) {
		super();
		this.accountId = accountId;
		this.goodsName = goodsName;
		this.goodsNum = goodsNum;
		this.businessNum = businessNum;
		this.totalPrice = totalPrice;
		this.isPayed = isPayed;
		this.providerName = providerName;
		this.goodsIntro = goodsIntro;
		this.accountDate = accountDate;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getGoodsIntro() {
		return goodsIntro;
	}
	public void setGoodsIntro(String goodsIntro) {
		this.goodsIntro = goodsIntro;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	
	
}
