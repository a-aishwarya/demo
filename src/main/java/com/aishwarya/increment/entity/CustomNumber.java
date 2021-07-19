package com.aishwarya.increment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Inc_counter")
public class CustomNumber {

	@Id
	Long id;

	@Column
	int counter_value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomNumber() {
	}

	public int getCounter() {
		return counter_value;
	}

	public void setCounter(int counter) {
		this.counter_value = counter_value;
	}

}
