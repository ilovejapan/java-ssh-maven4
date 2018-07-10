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
 * Tjob entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tjob", catalog = "schooldb")
public class Tjob implements java.io.Serializable {

	// Fields

	private String cid;
	private Timestamp ccreatedatetime;
	private String ccreateid;
	private Timestamp cmodifydatetime;
	private String cmodifyid;
	private String cname;
	private String cno;
	private String copenperformance;
	private String copenposition;
	private Set<Tkpi> tkpis = new HashSet<Tkpi>(0);
	private Set<Temp> temps = new HashSet<Temp>(0);

	// Constructors

	/** default constructor */
	public Tjob() {
	}

	/** minimal constructor */
	public Tjob(String cid) {
		this.cid = cid;
	}

	/** full constructor */
	public Tjob(String cid, Timestamp ccreatedatetime, String ccreateid,
			Timestamp cmodifydatetime, String cmodifyid, String cname,
			String cno, String copenperformance, String copenposition,
			Set<Tkpi> tkpis, Set<Temp> temps) {
		this.cid = cid;
		this.ccreatedatetime = ccreatedatetime;
		this.ccreateid = ccreateid;
		this.cmodifydatetime = cmodifydatetime;
		this.cmodifyid = cmodifyid;
		this.cname = cname;
		this.cno = cno;
		this.copenperformance = copenperformance;
		this.copenposition = copenposition;
		this.tkpis = tkpis;
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

	@Column(name = "CNAME", length = 100)
	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Column(name = "CNO", length = 100)
	public String getCno() {
		return this.cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	@Column(name = "COPENPERFORMANCE", length = 1)
	public String getCopenperformance() {
		return this.copenperformance;
	}

	public void setCopenperformance(String copenperformance) {
		this.copenperformance = copenperformance;
	}

	@Column(name = "COPENPOSITION", length = 1)
	public String getCopenposition() {
		return this.copenposition;
	}

	public void setCopenposition(String copenposition) {
		this.copenposition = copenposition;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tjob")
	public Set<Tkpi> getTkpis() {
		return this.tkpis;
	}

	public void setTkpis(Set<Tkpi> tkpis) {
		this.tkpis = tkpis;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tjob")
	public Set<Temp> getTemps() {
		return this.temps;
	}

	public void setTemps(Set<Temp> temps) {
		this.temps = temps;
	}

}