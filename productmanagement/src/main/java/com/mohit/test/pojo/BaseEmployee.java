package com.mohit.test.pojo;

public class BaseEmployee {

	private long id;

	private String name;

	public BaseEmployee(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public BaseEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BaseEmployee [id=" + id + ", name=" + name + ", toString()=" + super.toString() + "]";
	}
	
	

}
