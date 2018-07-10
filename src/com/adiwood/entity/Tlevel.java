package com.adiwood.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tlevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tlevel", catalog = "schooldb")
public class Tlevel implements java.io.Serializable {

	// Fields

	private String cid;
	private Double ccoefficient;
	private Timestamp ccreatedatetime;
	private String ccreateid;
	private Timestamp cmodifydatetime;
	private String cmodifyid;
	private String cno;
	private String cpslevel;
	private Set<Tself> tselfs = new HashSet<Tself>(0);

	// Constructors

	/** default constructor */
	public Tlevel() {
	}

	/** minimal constructor */
	public Tlevel(String cid, String cno, String cpslevel) {
		this.cid = cid;
		this.cno = cno;
		this.cpslevel = cpslevel;
	}

	/** full constructor */
	public Tlevel(String cid, Double ccoefficient, Timestamp ccreatedatetime,
			String ccreateid, Timestamp cmodifydatetime, String cmodifyid,
			String cno, String cpslevel, Set<Tself> tselfs) {
		this.cid = cid;
		this.ccoefficient = ccoefficient;
		this.ccreatedatetime = ccreatedatetime;
		this.ccreateid = ccreateid;
		this.cmodifydatetime = cmodifydatetime;
		this.cmodifyid = cmodifyid;
		this.cno = cno;
		this.cpslevel = cpslevel;
		this.tselfs = tselfs;
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

	@Column(name = "CCOEFFICIENT", precision = 22, scale = 0)
	public Double getCcoefficient() {
		return this.ccoefficient;
	}

	public void setCcoefficient(Double ccoefficient) {
		this.ccoefficient = ccoefficient;
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

	@Column(name = "CMODIFYID", length = 10)
	public String getCmodifyid() {
		return this.cmodifyid;
	}

	public void setCmodifyid(String cmodifyid) {
		this.cmodifyid = cmodifyid;
	}

	@Column(name = "CNO", nullable = false, length = 10)
	public String getCno() {
		return this.cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	@Column(name = "CPSLEVEL", nullable = false, length = 10)
	public String getCpslevel() {
		return this.cpslevel;
	}

	public void setCpslevel(String cpslevel) {
		this.cpslevel = cpslevel;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tlevel")
	public Set<Tself> getTselfs() {
		return this.tselfs;
	}

	public void setTselfs(Set<Tself> tselfs) {
		this.tselfs = tselfs;
	}

}