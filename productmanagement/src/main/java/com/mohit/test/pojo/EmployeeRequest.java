package com.mohit.test.pojo;

public class EmployeeRequest extends BaseEmployee {

	private Long parentId;

	

	public EmployeeRequest(long id, String name, Long parentId) {
		super(id, name);
		this.parentId = parentId;
	}

	public EmployeeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "EmployeeRequest [parentId=" + parentId + ", toString()=" + super.toString() + "]";
	}
	
	

}
