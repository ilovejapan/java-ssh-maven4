package com.adiwood.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tstart entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tstart", catalog = "schooldb")
public class Tstart implements java.io.Serializable {

	// Fields

	private String cid;
	private Timestamp ccreatedatetime;
	private String ccreateid;
	private String cemail;
	private String cmessage;
	private Timestamp cmodifydatetime;
	private String cmodifyid;
	private String cmonth;
	private String cstatus;

	// Constructors

	/** default constructor */
	public Tstart() {
	}

	/** minimal constructor */
	public Tstart(String cid, String cmonth, String cstatus) {
		this.cid = cid;
		this.cmonth = cmonth;
		this.cstatus = cstatus;
	}

	/** full constructor */
	public Tstart(String cid, Timestamp ccreatedatetime, String ccreateid,
			String cemail, String cmessage, Timestamp cmodifydatetime,
			String cmodifyid, String cmonth, String cstatus) {
		this.cid = cid;
		this.ccreatedatetime = ccreatedatetime;
		this.ccreateid = ccreateid;
		this.cemail = cemail;
		this.cmessage = cmessage;
		this.cmodifydatetime = cmodifydatetime;
		this.cmodifyid = cmodifyid;
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

	@Column(name = "CCREATEDATETIME", length = 19)
	public Timestamp getCcreatedatetime() {
		return this.ccreatedatetime;
	}

	public void setCcreatedatetime(Timestamp ccreatedatetime) {
		this.ccreatedatetime = ccreatedatetime;
	}

	@Column(name = "CCREATEID", length = 10)
	public String getCcreateid() {
		return this.ccreateid;
	}

	public void setCcreateid(String ccreateid) {
		this.ccreateid = ccreateid;
	}

	@Column(name = "CEMAIL", length = 6)
	public String getCemail() {
		return this.cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	@Column(name = "CMESSAGE", length = 6)
	public String getCmessage() {
		return this.cmessage;
	}

	public void setCmessage(String cmessage) {
		this.cmessage = cmessage;
	}

	@Column(name = "CMODIFYDATETIME", length = 19)
	public Timestamp getCmodifydatetime() {
		return this.cmodifydatetime;
	}

	public void setCmodifydatetime(Timestamp cmodifydatetime) {
		this.cmodifydatetime = cmodifydatetime;
	}

	@Column(name = "CMODIFYID", length = 10)
	public String getCmodifyid() {
		return this.cmodifyid;
	}

	public void setCmodifyid(String cmodifyid) {
		this.cmodifyid = cmodifyid;
	}

	@Column(name = "CMONTH", nullable = false, length = 10)
	public String getCmonth() {
		return this.cmonth;
	}

	public void setCmonth(String cmonth) {
		this.cmonth = cmonth;
	}

	@Column(name = "CSTATUS", nullable = false, length = 6)
	public String getCstatus() {
		return this.cstatus;
	}

	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

}