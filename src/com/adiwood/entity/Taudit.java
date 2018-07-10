package com.adiwood.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Taudit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "taudit", catalog = "schooldb")
public class Taudit implements java.io.Serializable {

	// Fields

	private String cid;
	private Temp temp;
	private String cauditor;
	private Timestamp ccreatedatetime;
	private String ccreateid;
	private String clevel;
	private Timestamp cmodifydatetime;
	private String cmodifyid;
	private Timestamp ctime;
	private String cmonth;
	private String cstatus;

	// Constructors

	/** default constructor */
	public Taudit() {
	}

	/** minimal constructor */
	public Taudit(String cid) {
		this.cid = cid;
	}

	/** full constructor */
	public Taudit(String cid, Temp temp, String cauditor,
			Timestamp ccreatedatetime, String ccreateid, String clevel,
			Timestamp cmodifydatetime, String cmodifyid, Timestamp ctime,
			String cmonth, String cstatus) {
		this.cid = cid;
		this.temp = temp;
		this.cauditor = cauditor;
		this.ccreatedatetime = ccreatedatetime;
		this.ccreateid = ccreateid;
		this.clevel = clevel;
		this.cmodifydatetime = cmodifydatetime;
		this.cmodifyid = cmodifyid;
		this.ctime = ctime;
		this.cmonth = cmonth;
		this.cstatus = cstatus;
	}

	// Property accessors
	@Id
	@Column(name = "CID", unique = true, nullable = false, length = 36)
	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CEMP")
	public Temp getTemp() {
		return this.temp;
	}

	public void setTemp(Temp temp) {
		this.temp = temp;
	}

	@Column(name = "CAUDITOR", length = 36)
	public String getCauditor() {
		return this.cauditor;
	}

	public void setCauditor(String cauditor) {
		this.cauditor = cauditor;
	}

	@Column(name = "CCREATEDATETIME", length = 19)
	public Timestamp getCcreatedatetime() {
		return this.ccreatedatetime;
	}

	public void setCcreatedatetime(Timestamp ccreatedatetime) {
		this.ccreatedatetime = ccreatedatetime;
	}

	@Column(name = "CCREATEID", length = 20)
	public String getCcreateid() {
		return this.ccreateid;
	}

	public void setCcreateid(String ccreateid) {
		this.ccreateid = ccreateid;
	}

	@Column(name = "CLEVEL", length = 2)
	public String getClevel() {
		return this.clevel;
	}

	public void setClevel(String clevel) {
		this.clevel = clevel;
	}

	@Column(name = "CMODIFYDATETIME", length = 19)
	public Timestamp getCmodifydatetime() {
		return this.cmodifydatetime;
	}

	public void setCmodifydatetime(Timestamp cmodifydatetime) {
		this.cmodifydatetime = cmodifydatetime;
	}

	@Column(name = "CMODIFYID", length = 20)
	public String getCmodifyid() {
		return this.cmodifyid;
	}

	public void setCmodifyid(String cmodifyid) {
		this.cmodifyid = cmodifyid;
	}

	@Column(name = "CTIME", length = 19)
	public Timestamp getCtime() {
		return this.ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	@Column(name = "CMONTH", length = 10)
	public String getCmonth() {
		return this.cmonth;
	}

	public void setCmonth(String cmonth) {
		this.cmonth = cmonth;
	}

	@Column(name = "CSTATUS", length = 2)
	public String getCstatus() {
		return this.cstatus;
	}

	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

}