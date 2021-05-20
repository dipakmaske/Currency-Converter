package com.ccw.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "convert_history")
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;

	@Column(name = "valueFrom")
	private String from;

	private String convertTo;

	private String amount;

	private double output;

	private LocalDate date;

	public History() {
		super();
		// TODO Auto-generated constructor stub
	}

	public History(Integer cid, String from, String convertTo, String amount, double output, LocalDate date) {
		super();
		this.cid = cid;
		this.from = from;
		this.convertTo = convertTo;
		this.amount = amount;
		this.output = output;
		this.date = date;
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

	public double getOutput() {
		return output;
	}

	public void setOutput(double output) {
		this.output = output;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "History [cid=" + cid + ", from=" + from + ", convertTo=" + convertTo + ", amount=" + amount
				+ ", output=" + output + ", date=" + date + "]";
	}

}
