package com.ygh.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


import javax.persistence.ManyToOne;
@Entity
public class Product implements Serializable{
	private Integer id;
	private String name;
	//�۸�
	private BigDecimal price;
	private String pic;
	//��Ʒ�򵥽���
	private String remark;
	//��Ʒ����ϸ����
	private String xremark;
	private Date date;
	//�Ƿ�Ϊ�Ƽ���Ʒ
	private boolean commend;
	//�Ƿ�Ϊ��Ч��Ʒ
	private boolean open;
	private Category category;
	

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getXremark() {
		return xremark;
	}
	public void setXremark(String xremark) {
		this.xremark = xremark;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isCommend() {
		return commend;
	}
	public void setCommend(boolean commend) {
		this.commend = commend;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cid")
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ ", pic=" + pic + ", remark=" + remark + ", xremark="
				+ xremark + ", date=" + date + ", commend=" + commend
				+ ", open=" + open;
	}
	
	
	

}
