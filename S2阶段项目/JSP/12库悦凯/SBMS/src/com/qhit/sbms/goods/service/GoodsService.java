package com.qhit.sbms.goods.service;

import com.qhit.sbms.goods.bean.Goods;

public interface GoodsService {
	/**
	 * @param GoodsName
	 * @return
	 * ������Ʒ����ȥ��ѯ��Ʒ��Ϣ
	 */
	public Goods getGoodsInfoByName(String goodsName);
	/**
	 * @param num
	 * @param goodsId
	 * @return
	 * ���¿��
	 */
	public int updateStore(int num, int goodsId);
}
