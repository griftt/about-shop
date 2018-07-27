package com.hc.shop.common.pojo;

import java.io.Serializable;
import java.util.List;

public class UIDataGrid implements Serializable{
	Long total;
	List<?> rows;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
