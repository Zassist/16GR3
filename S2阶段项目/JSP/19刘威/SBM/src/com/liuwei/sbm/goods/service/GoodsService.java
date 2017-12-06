package com.liuwei.sbm.goods.service;

import com.liuwei.sbm.goods.bean.Goods;

public interface GoodsService {
	public Goods getGoodsInfoByName(String goodsName);
	public int updateStore(int num, int goodsId);
}
