package com.qhit.sbm.goods.dao;

import com.qhit.sbm.goods.bean.Goods;

public interface GoodsDao {

	int updateStore(int num, int goodsId);

	Goods getGoodsInfoByName(String goodsName);

}
