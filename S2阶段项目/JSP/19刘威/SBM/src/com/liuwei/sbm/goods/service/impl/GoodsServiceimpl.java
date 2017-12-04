package com.liuwei.sbm.goods.service.impl;

import com.liuwei.sbm.goods.bean.Goods;
import com.liuwei.sbm.goods.dao.impl.GoodsDaoimpl;
import com.liuwei.sbm.goods.service.GoodsService;

public class GoodsServiceimpl implements GoodsService {

	@Override
	public Goods getGoodsInfoByName(String goodsName) {
		// TODO Auto-generated method stub
		return new GoodsDaoimpl().getGoodsInfoByName(goodsName);
	}

	@Override
	public int updateStore(int num, int goodsId) {
		// TODO Auto-generated method stub
		return new GoodsDaoimpl().updateStore(num, goodsId);
	}

}
