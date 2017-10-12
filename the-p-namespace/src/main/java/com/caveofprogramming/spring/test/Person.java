package com.caveofprogramming.spring.test;

public class Person {
	
	private int id;
	private String name;
	private int taxId;
	private Address address;
	
	public Person() {
		
	}
	
	public static Person getInstance(int id, String name) {
		return new Person(id, name);
	}
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void onCreate() {
	
	}
	
	public void onDestroy() {
		
	}

	public void speak() {
		
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", taxId=" + taxId
				+ ", address=" + address + "]";
	}

	
}
