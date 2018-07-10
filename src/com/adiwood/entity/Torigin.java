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
 * Torigin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "torigin", catalog = "schooldb")
public class Torigin implements java.io.Serializable {

	// Fields

	private String cid;
	private Timestamp ccreatedatetime;
	private String ccreateid;
	private Timestamp cmodifydatetime;
	private String cmodifyid;
	private String cname;
	private String cno;
	private Set<Temp> temps = new HashSet<Temp>(0);

	// Constructors

	/** default constructor */
	public Torigin() {
	}

	/** minimal constructor */
	public Torigin(String cid) {
		this.cid = cid;
	}

	/** full constructor */
	public Torigin(String cid, Timestamp ccreatedatetime, String ccreateid,
			Timestamp cmodifydatetime, String cmodifyid, String cname,
			String cno, Set<Temp> temps) {
		this.cid = cid;
		this.ccreatedatetime = ccreatedatetime;
		this.ccreateid = ccreateid;
		this.cmodifydatetime = cmodifydatetime;
		this.cmodifyid = cmodifyid;
		this.cname = cname;
		this.cno = cno;
		this.temps = temps;
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

	@Column(name = "CMODIFYID", length = 10)
	public String getCmodifyid() {
		return this.cmodifyid;
	}

	public void setCmodifyid(String cmodifyid) {
		this.cmodifyid = cmodifyid;
	}

	@Column(name = "CNAME", length = 20)
	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Column(name = "CNO", length = 10)
	public String getCno() {
		return this.cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "torigin")
	public Set<Temp> getTemps() {
		return this.temps;
	}

	public void setTemps(Set<Temp> temps) {
		this.temps = temps;
	}

}