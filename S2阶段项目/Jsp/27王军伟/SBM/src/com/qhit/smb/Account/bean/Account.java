package com.qhit.smb.Account.bean;

import java.util.Date;

public class Account {
	private int accountid;
	private int providerid;
	private Double totalprice;
	private int ispayed;
	private Date accountdate;
	private int goodsid;
	private int businessnum;

	public Account() {
		super();
	}

	public Account(int accountid, int providerid, Double totalprice, int ispayed, Date accountdate,
			int goodsid, int businessnum) {
		super();
		this.accountid = accountid;
		this.providerid = providerid;
		this.totalprice = totalprice;
		this.ispayed = ispayed;
		this.accountdate = accountdate;
		this.goodsid = goodsid;
		this.businessnum = businessnum;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public int getProviderid() {
		return providerid;
	}

	public void setProviderid(int providerid) {
		this.providerid = providerid;
	}

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public int getIspayed() {
		return ispayed;
	}

	public void setIspayed(int ispayed) {
		this.ispayed = ispayed;
	}

	public Date getAccountdate() {
		return accountdate;
	}

	public void setAccountdate(Date accountdate) {
		this.accountdate = accountdate;
	}

	public int getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}

	public int getBusinessnum() {
		return businessnum;
	}

	public void setBusinessnum(int businessnum) {
		this.businessnum = businessnum;
	}
}