package com.liuwei.sbm.goods.dao;

import com.liuwei.sbm.goods.bean.Goods;

public interface GoodsDao {
	
	public Goods getGoodsInfoByName(String goodsName);
	public int updateStore(int num, int goodsId);
}
