package com.asiainfo.model;

import java.util.Date;

public class Account {
    private Integer id;
    private String account;
    private Double amount;
    private Date create_at;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", account=" + account + ", amount="
				+ amount + ", create_at=" + create_at + "]";
	}
  
}
