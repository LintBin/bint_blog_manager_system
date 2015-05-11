package com.bint.util;

/**
 * 分页工具类
 * @author kklt21cn
 */
public class PagingUtil {
	public static int FRONT_ATICLE_PAGE_SIZE = 5;
	//在前台右边标签云显示的数量
	public static int FRONT_LABEL_SHOW_SIZE = 8;
	
	
	/**
	 * 由总数结算页数
	 * @param amount
	 * @return
	 */
	public static int getPageAmount(Long amount,int size){
		//模
		int m = (int) (amount/FRONT_ATICLE_PAGE_SIZE);
		//余数
		int remainde = (int) (amount%5);
		if(remainde != 0){
			return m+1;
		}else{
			return m;
		}
	}
	
	public static int getPageAmount(int amount ,int size){
		Long amountLong = new Long(amount);
		return getPageAmount(amountLong,size);
	}
}
