package com.fashion.legou.entity;

public class Page {

	private int curPage;//当前页

	private final int pageSize = 5;//一页显示数据量

	private int pageCount;// 总页数

	private int count;// 总数据量

	public int countPage(int count) {
		if (count <= 5)
			pageCount = 1;
		else if(count>5&&count%pageSize==0){
			pageCount=count/pageSize;
		}
		else{
			pageCount=count/pageSize+1;
		}
		return pageCount;

	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		return "page";
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
