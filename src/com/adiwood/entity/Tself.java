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
 * Tself entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tself", catalog = "schooldb")
public class Tself implements java.io.Serializable {

	// Fields

	private String cid;
	private Tlevel tlevel;
	private Temp temp;
	private Tkpi tkpi;
	private Timestamp ccreatedatetime;
	private String ccreateid;
	private String cfinaly;
	private Timestamp cmodifydatetime;
	private String cmodifyid;
	private String cmonth;
	private String cplan;
	private String cscale;

	// Constructors

	/** default constructor */
	public Tself() {
	}

	/** minimal constructor */
	public Tself(String cid) {
		this.cid = cid;
	}

	/** full constructor */
	public Tself(String cid, Tlevel tlevel, Temp temp, Tkpi tkpi,
			Timestamp ccreatedatetime, String ccreateid, String cfinaly,
			Timestamp cmodifydatetime, String cmodifyid, String cmonth,
			String cplan, String cscale) {
		this.cid = cid;
		this.tlevel = tlevel;
		this.temp = temp;
		this.tkpi = tkpi;
		this.ccreatedatetime = ccreatedatetime;
		this.ccreateid = ccreateid;
		this.cfinaly = cfinaly;
		this.cmodifydatetime = cmodifydatetime;
		this.cmodifyid = cmodifyid;
		this.cmonth = cmonth;
		this.cplan = cplan;
		this.cscale = cscale;
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
	@JoinColumn(name = "CLEVEL")
	public Tlevel getTlevel() {
		return this.tlevel;
	}

	public void setTlevel(Tlevel tlevel) {
		this.tlevel = tlevel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CEMP")
	public Temp getTemp() {
		return this.temp;
	}

	public void setTemp(Temp temp) {
		this.temp = temp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CKPI")
	public Tkpi getTkpi() {
		return this.tkpi;
	}

	public void setTkpi(Tkpi tkpi) {
		this.tkpi = tkpi;
	}

	@Column(name = "CCREATEDATETIME", length = 19)
	public Timestamp getCcreatedatetime() {
		return this.ccreatedatetime;
	}

	public void setCcreatedatetime(Timestamp ccreatedatetime) {
		this.ccreatedatetime = ccreatedatetime;
	}

	@Column(name = "CCREATEID", length = 36)
	public String getCcreateid() {
		return this.ccreateid;
	}

	public void setCcreateid(String ccreateid) {
		this.ccreateid = ccreateid;
	}

	@Column(name = "CFINALY", length = 65535)
	public String getCfinaly() {
		return this.cfinaly;
	}

	public void setCfinaly(String cfinaly) {
		this.cfinaly = cfinaly;
	}

	@Column(name = "CMODIFYDATETIME", length = 19)
	public Timestamp getCmodifydatetime() {
		return this.cmodifydatetime;
	}

	public void setCmodifydatetime(Timestamp cmodifydatetime) {
		this.cmodifydatetime = cmodifydatetime;
	}

	@Column(name = "CMODIFYID", length = 37)
	public String getCmodifyid() {
		return this.cmodifyid;
	}

	public void setCmodifyid(String cmodifyid) {
		this.cmodifyid = cmodifyid;
	}

	@Column(name = "CMONTH", length = 6)
	public String getCmonth() {
		return this.cmonth;
	}

	public void setCmonth(String cmonth) {
		this.cmonth = cmonth;
	}

	@Column(name = "CPLAN", length = 65535)
	public String getCplan() {
		return this.cplan;
	}

	public void setCplan(String cplan) {
		this.cplan = cplan;
	}

	@Column(name = "CSCALE", length = 3)
	public String getCscale() {
		return this.cscale;
	}

	public void setCscale(String cscale) {
		this.cscale = cscale;
	}

}