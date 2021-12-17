package com.mohit.test.pojo;

import java.util.List;

public class EmployeeResponse extends BaseEmployee {

	private List<EmployeeResponse> child;

	/**
	 * @return the child
	 */
	public List<EmployeeResponse> getChild() {
		return child;
	}

	/**
	 * @param child the child to set
	 */
	public void setChild(List<EmployeeResponse> child) {
		this.child = child;
	}

}
