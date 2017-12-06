package com.qhit.smb.Account.bean;

import java.util.Date;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2017年11月15日 下午3:24:18 账单类
 */
public class AccountDetail {
	//帐单编号
	private int accountId;
	//商品名称
	private String goodsName;
	//商品数量
	private int businessNum;
	//商品单价
	private float totalPrice;
	//是否付款
	private int isPayed;
	//供应商名称
	private String providerName;
	//商品简介
	private String goodsIntro;
	//账单时间
	private Date accountDate;

	@Override
	public String toString() {
		return "AccountDetail [accountId=" + accountId + ", goodsName=" + goodsName + ", businessNum=" + businessNum
				+ ", totalPrice=" + totalPrice + ", isPayed=" + isPayed + ", providerName=" + providerName
				+ ", goodsIntro=" + goodsIntro + ", accountDate=" + accountDate + "]";
	}

	public AccountDetail(int accountId, String goodsName, int businessNum, int isPayed) {
		super();
		this.accountId = accountId;
		this.goodsName = goodsName;
		this.businessNum = businessNum;
		this.isPayed = isPayed;
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

	public int getBusinessNum() {
		return businessNum;
	}

	public void setBusinessNum(int businessNum) {
		this.businessNum = businessNum;
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

	public AccountDetail() {
		super();
	}

	public AccountDetail(int accountId, String goodsName, int businessNum, float totalPrice, int isPayed,
			String providerName, String goodsIntro, Date accountDate) {
		super();
		this.accountId = accountId;
		this.goodsName = goodsName;
		this.businessNum = businessNum;
		this.totalPrice = totalPrice;
		this.isPayed = isPayed;
		this.providerName = providerName;
		this.goodsIntro = goodsIntro;
		this.accountDate = accountDate;
	}

}
