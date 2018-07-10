package com.adiwood.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tonline entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tonline", catalog = "schooldb")
public class Tonline implements java.io.Serializable {

	// Fields

	private String cid;
	private Timestamp cdatetime;
	private String cip;
	private String cname;

	// Constructors

	/** default constructor */
	public Tonline() {
	}

	/** full constructor */
	public Tonline(String cid, Timestamp cdatetime, String cip, String cname) {
		this.cid = cid;
		this.cdatetime = cdatetime;
		this.cip = cip;
		this.cname = cname;
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

	@Column(name = "CDATETIME", nullable = false, length = 19)
	public Timestamp getCdatetime() {
		return this.cdatetime;
	}

	public void setCdatetime(Timestamp cdatetime) {
		this.cdatetime = cdatetime;
	}

	@Column(name = "CIP", nullable = false, length = 50)
	public String getCip() {
		return this.cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	@Column(name = "CNAME", nullable = false, length = 100)
	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}