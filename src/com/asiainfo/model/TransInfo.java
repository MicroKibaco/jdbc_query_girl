package com.asiainfo.model;

import java.util.Date;

public class TransInfo {
	
	private Integer id;
	private Integer sourceId;
	private String sourceAccount;
	private Integer destinationId;
	private String destinationAccount;
	private Double amount;
	private Date createAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(String sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public Integer getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}

	public String getDestinationAccount() {
		return destinationAccount;
	}

	public void setDestinationAccount(String destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	@Override
	public String toString() {
		return "TransInfo [id=" + id + ", sourceId=" + sourceId
				+ ", sourceAccount=" + sourceAccount + ", destinationId="
				+ destinationId + ", destinationAccount=" + destinationAccount
				+ ", amount=" + amount + ", createAt=" + createAt + "]";
	}
    
}
