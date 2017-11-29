package com.qhit.zdgl.account.bean;

public class Goods {
	private int goodsId;
	private String goodsName;
	private double goodsPrice;
	private int goodsNum;
	private String goodsUnit;
	private String goodsIntro;
	
	public Goods(int goodsId, String goodsName, double goodsPrice,
			int goodsNum, String goodsUnit, String goodsIntro) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsNum = goodsNum;
		this.goodsUnit = goodsUnit;
		this.goodsIntro = goodsIntro;
	}
	
	public Goods() {
		// TODO Auto-generated constructor stub
	}

	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsUnit() {
		return goodsUnit;
	}
	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}
	public String getGoodsIntro() {
		return goodsIntro;
	}
	public void setGoodsIntro(String goodsIntro) {
		this.goodsIntro = goodsIntro;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName
				+ ", goodsPrice=" + goodsPrice + ", goodsNum=" + goodsNum
				+ ", goodsUnit=" + goodsUnit + ", goodsIntro=" + goodsIntro
				+ "]";
	}
	
}
