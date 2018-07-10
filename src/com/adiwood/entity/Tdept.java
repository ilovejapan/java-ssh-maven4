package com.adiwood.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tdept entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tdept", catalog = "schooldb")
public class Tdept implements java.io.Serializable {

	// Fields

	private String cid;
	private Tdept tdept;
	private Timestamp ccreatedatetime;
	private String ccreateid;
	private Timestamp cmodifydatetime;
	private String cmodifyid;
	private String cname;
	private String cno;
	private String cstart;
	private Set<Tdept> tdepts = new HashSet<Tdept>(0);
	private Set<Temp> temps = new HashSet<Temp>(0);

	// Constructors

	/** default constructor */
	public Tdept() {
	}

	/** minimal constructor */
	public Tdept(String cid) {
		this.cid = cid;
	}

	/** full constructor */
	public Tdept(String cid, Tdept tdept, Timestamp ccreatedatetime,
			String ccreateid, Timestamp cmodifydatetime, String cmodifyid,
			String cname, String cno, String cstart, Set<Tdept> tdepts,
			Set<Temp> temps) {
		this.cid = cid;
		this.tdept = tdept;
		this.ccreatedatetime = ccreatedatetime;
		this.ccreateid = ccreateid;
		this.cmodifydatetime = cmodifydatetime;
		this.cmodifyid = cmodifyid;
		this.cname = cname;
		this.cno = cno;
		this.cstart = cstart;
		this.tdepts = tdepts;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CPID")
	public Tdept getTdept() {
		return this.tdept;
	}

	public void setTdept(Tdept tdept) {
		this.tdept = tdept;
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

	@Column(name = "CNAME", length = 40)
	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Column(name = "CNO", length = 40)
	public String getCno() {
		return this.cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	@Column(name = "CSTART", length = 1)
	public String getCstart() {
		return this.cstart;
	}

	public void setCstart(String cstart) {
		this.cstart = cstart;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tdept")
	public Set<Tdept> getTdepts() {
		return this.tdepts;
	}

	public void setTdepts(Set<Tdept> tdepts) {
		this.tdepts = tdepts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tdept")
	public Set<Temp> getTemps() {
		return this.temps;
	}

	public void setTemps(Set<Temp> temps) {
		this.temps = temps;
	}

}