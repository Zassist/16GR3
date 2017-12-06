package com.qhit.sbm.goods.dao;

import com.qhit.sbm.goods.bean.Goods;

public interface GoodsDao {
	
	public Goods getGoodsInfoByName(String goodsName);
}
