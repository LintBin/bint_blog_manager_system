package com.bint.vo;

import java.util.List;

public class PageVo {
	private List<?> list;
	private long startIndex =1;
	private int size = 20;
	
	private long amount ;
	private int currentPage =1;
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
		return (currentPage-1)*size;
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
	@Override
	public String toString() {
		return "PageVo [list=" + list + ", startIndex=" + startIndex
				+ ", numPerPage=" + size + ", amount=" + amount
				+ ", currentPage=" + currentPage + "]";
	}
	
}
