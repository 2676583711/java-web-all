package cn.zhou.customer.dao;

import java.util.List;

public class PageBean<T> {

	private int pageCode;// 当前页码
	private int totalPages;// 总页数
	private int totalRecords;// 总记录数
	private int pageSize; // 当前当前页记录数
	private List<T> beanList; // 当前页数据

	/**
	 * @return the pageCode
	 */
	public int getPageCode() {
		return pageCode;
	}

	/**
	 * @param pageCode
	 *            the pageCode to set
	 */
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		totalPages = totalRecords / pageSize;
		return totalRecords % pageSize == 0 ? totalPages : totalPages + 1;
	}

	// public void setTotalPages(int totalPages) {
	// this.totalPages = totalPages;
	// }

	/**
	 * @return the totalRecords
	 */
	public int getTotalRecords() {
		return totalRecords;
	}

	/**
	 * @param totalRecords
	 *            the totalRecords to set
	 */
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the beanList
	 */
	public List<T> getBeanList() {
		return beanList;
	}

	/**
	 * @param beanList
	 *            the beanList to set
	 */
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

}
