package com.bint.vo;

import java.util.List;

public class PageVo {
	private List<?> list;
	private long startIndex =1;
	private int size = 20;
	
	private long amount ;
	private int currentPage =1;
	private int pageNum = 1;
	private int pageAmount ;
	
	public int getPageAmount() {
		return pageAmount;
	}
	public void setPageAmount(int pageAmount) {
		this.pageAmount = pageAmount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	//封装查询的条件
	private Object object;
	
	
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public long getStartIndex() {
		return (pageNum-1)*size;
	}
	public void setStartIndex(long startIndex) {
		this.startIndex = startIndex;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	@Override
	public String toString() {
		return "PageVo [list=" + list + ", startIndex=" + startIndex
				+ ", size=" + size + ", amount=" + amount + ", currentPage="
				+ currentPage + ", pageNum=" + pageNum + ", object=" + object
				+ "]";
	}
	
	
}
