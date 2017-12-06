package com.qhit.wjk.goods.service;

import com.qhit.wjk.goods.bean.Goods;

public interface IGoodsService {
	/**
	 * @param goodsName
	 * @return
	 * 根据商品名称去查询商品信息
	 */
	public Goods getGoodsInfoByName(String goodsName);
	
	
	/**
	 * @param num
	 * @return
	 * 更新库存
	 */
	public int updateStore(int num, int goodsId);
}