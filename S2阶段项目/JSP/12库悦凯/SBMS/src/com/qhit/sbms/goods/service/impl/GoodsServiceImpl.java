package com.qhit.sbms.goods.service.impl;

import com.qhit.sbms.goods.bean.Goods;
import com.qhit.sbms.goods.dao.impl.GoodsDaoImpl;
import com.qhit.sbms.goods.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {

	@Override
	public Goods getGoodsInfoByName(String goodsName) {
		// TODO Auto-generated method stub
		return new GoodsDaoImpl().getGoodsInfoByName(goodsName);
	}

	@Override
	public int updateStore(int num, int goodsId) {
		// TODO Auto-generated method stub
		return new GoodsDaoImpl().updateStore(num, goodsId);
	}

}
