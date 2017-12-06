package com.qhit.sbm.goods.service;

import com.qhit.sbm.goods.bean.Goods;

public interface GoodsService {

	Goods getGoodsInfoByName(String goodsName);

	int updateStore(int num, int goodsId);

}
