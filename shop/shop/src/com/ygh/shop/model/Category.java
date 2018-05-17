package com.ygh.shop.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Category {
	private int id;
	private String type;
	private boolean hot;
	private Account account;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="aid")
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isHot() {
		return hot;
	}
	public void setHot(boolean hot) {
		this.hot = hot;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", type=" + type + ", hot=" + hot
				;
	}
	

}
