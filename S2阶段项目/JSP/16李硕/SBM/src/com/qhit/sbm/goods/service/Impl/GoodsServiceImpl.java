package com.qhit.sbm.goods.service.Impl;

import com.qhit.sbm.goods.bean.Goods;
import com.qhit.sbm.goods.dao.Impl.GoodsDaoImpl;

public class GoodsServiceImpl implements com.qhit.sbm.goods.service.GoodsService {

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
