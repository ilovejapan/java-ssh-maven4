package com.adiwood.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tmessage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tmessage", catalog = "schooldb")
public class Tmessage implements java.io.Serializable {

	// Fields

	private String cid;
	private Timestamp ccreatedatetime;
	private String ccreateid;
	private Timestamp cmodifydatetime;
	private String cno;
	private String comdifyid;
	private String crecempno;
	private Timestamp csavedate;
	private String csendempno;
	private String ctext;
	private String status;

	// Constructors

	/** default constructor */
	public Tmessage() {
	}

	/** minimal constructor */
	public Tmessage(String cid) {
		this.cid = cid;
	}

	/** full constructor */
	public Tmessage(String cid, Timestamp ccreatedatetime, String ccreateid,
			Timestamp cmodifydatetime, String cno, String comdifyid,
			String crecempno, Timestamp csavedate, String csendempno,
			String ctext, String status) {
		this.cid = cid;
		this.ccreatedatetime = ccreatedatetime;
		this.ccreateid = ccreateid;
		this.cmodifydatetime = cmodifydatetime;
		this.cno = cno;
		this.comdifyid = comdifyid;
		this.crecempno = crecempno;
		this.csavedate = csavedate;
		this.csendempno = csendempno;
		this.ctext = ctext;
		this.status = status;
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

	@Column(name = "CMODIFYDATETIME", length = 19)
	public Timestamp getCmodifydatetime() {
		return this.cmodifydatetime;
	}

	public void setCmodifydatetime(Timestamp cmodifydatetime) {
		this.cmodifydatetime = cmodifydatetime;
	}

	@Column(name = "CNO", length = 65535)
	public String getCno() {
		return this.cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	@Column(name = "COMDIFYID", length = 10)
	public String getComdifyid() {
		return this.comdifyid;
	}

	public void setComdifyid(String comdifyid) {
		this.comdifyid = comdifyid;
	}

	@Column(name = "CRECEMPNO", length = 10)
	public String getCrecempno() {
		return this.crecempno;
	}

	public void setCrecempno(String crecempno) {
		this.crecempno = crecempno;
	}

	@Column(name = "CSAVEDATE", length = 19)
	public Timestamp getCsavedate() {
		return this.csavedate;
	}

	public void setCsavedate(Timestamp csavedate) {
		this.csavedate = csavedate;
	}

	@Column(name = "CSENDEMPNO", length = 10)
	public String getCsendempno() {
		return this.csendempno;
	}

	public void setCsendempno(String csendempno) {
		this.csendempno = csendempno;
	}

	@Column(name = "CTEXT", length = 65535)
	public String getCtext() {
		return this.ctext;
	}

	public void setCtext(String ctext) {
		this.ctext = ctext;
	}

	@Column(name = "STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}