package com.ccw.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	@Column(name = "valueFrom")
	private String from;

	private String convertTo;

	private String amount;

	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Currency(Integer cid, String from, String convertTo, String amount) {
		super();
		this.cid = cid;
		this.from = from;
		this.convertTo = convertTo;
		this.amount = amount;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getConvertTo() {
		return convertTo;
	}

	public void setConvertTo(String convertTo) {
		this.convertTo = convertTo;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Currency [cid=" + cid + ", from=" + from + ", convertTo=" + convertTo + ", amount=" + amount + "]";
	}

}
