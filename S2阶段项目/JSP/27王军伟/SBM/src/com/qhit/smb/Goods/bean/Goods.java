package com.qhit.smb.Goods.bean;

public class Goods {
	//商品id
	private int goodsid;
	//商品名称
	private String goodsname;
	//商品库存
	private int goodsnum;
	//商品单价
	private Double goodsprice;
	//商品单位
	private String goodsunit;
	//商品简介
	private String goodsintro;

	public Goods() {
		super();
	}

	public Goods(String goodsname, int goodsnum, Double goodsprice, String goodsunit,
			String goodsintro) {
		super();
		this.goodsname = goodsname;
		this.goodsnum = goodsnum;
		this.goodsprice = goodsprice;
		this.goodsunit = goodsunit;
		this.goodsintro = goodsintro;
	}

	public int getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public int getGoodsnum() {
		return goodsnum;
	}

	public void setGoodsnum(int goodsnum) {
		this.goodsnum = goodsnum;
	}

	public Double getGoodsprice() {
		return goodsprice;
	}

	public void setGoodsprice(Double goodsprice) {
		this.goodsprice = goodsprice;
	}

	public String getGoodsunit() {
		return goodsunit;
	}

	public void setGoodsunit(String goodsunit) {
		this.goodsunit = goodsunit;
	}

	public String getGoodsintro() {
		return goodsintro;
	}

	public void setGoodsintro(String goodsintro) {
		this.goodsintro = goodsintro;
	}
}