package com.qhit.sbms.goods.dao;

import com.qhit.sbms.goods.bean.Goods;

public interface GoodsDao {
	/**
	 * @param GoodsName
	 * @return
	 * ������Ʒ���Ʋ�ѯ��Ʒ��Ϣ
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
