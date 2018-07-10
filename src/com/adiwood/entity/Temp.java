package com.adiwood.entity;

import java.math.BigDecimal;
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
 * Temp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "temp", catalog = "schooldb")
public class Temp implements java.io.Serializable {

	// Fields

	private String cid;
	private Teducation teducation;
	private Tposition tposition;
	private Tdept tdept;
	private Torigin torigin;
	private Tjob tjob;
	private Tdegree tdegree;
	private String caddress;
	private Timestamp cbirthday;
	private Timestamp ccreatedatetime;
	private String ccreateid;
	private String cidentity;
	private String cmail;
	private String cmarry;
	private Timestamp cmodifydatetime;
	private String cmodifyid;
	private String cname;
	private String cno;
	private String csex;
	private String cstatus;
	private BigDecimal ctel;
	private String cpartment;
	private Set<Tself> tselfs = new HashSet<Tself>(0);
	private Set<Taudit> taudits = new HashSet<Taudit>(0);

	// Constructors

	/** default constructor */
	public Temp() {
	}

	/** minimal constructor */
	public Temp(String cid) {
		this.cid = cid;
	}

	/** full constructor */
	public Temp(String cid, Teducation teducation, Tposition tposition,
			Tdept tdept, Torigin torigin, Tjob tjob, Tdegree tdegree,
			String caddress, Timestamp cbirthday, Timestamp ccreatedatetime,
			String ccreateid, String cidentity, String cmail, String cmarry,
			Timestamp cmodifydatetime, String cmodifyid, String cname,
			String cno, String csex, String cstatus, BigDecimal ctel,
			String cpartment, Set<Tself> tselfs, Set<Taudit> taudits) {
		this.cid = cid;
		this.teducation = teducation;
		this.tposition = tposition;
		this.tdept = tdept;
		this.torigin = torigin;
		this.tjob = tjob;
		this.tdegree = tdegree;
		this.caddress = caddress;
		this.cbirthday = cbirthday;
		this.ccreatedatetime = ccreatedatetime;
		this.ccreateid = ccreateid;
		this.cidentity = cidentity;
		this.cmail = cmail;
		this.cmarry = cmarry;
		this.cmodifydatetime = cmodifydatetime;
		this.cmodifyid = cmodifyid;
		this.cname = cname;
		this.cno = cno;
		this.csex = csex;
		this.cstatus = cstatus;
		this.ctel = ctel;
		this.cpartment = cpartment;
		this.tselfs = tselfs;
		this.taudits = taudits;
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
	@JoinColumn(name = "CEDUCATION")
	public Teducation getTeducation() {
		return this.teducation;
	}

	public void setTeducation(Teducation teducation) {
		this.teducation = teducation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CPOSITION")
	public Tposition getTposition() {
		return this.tposition;
	}

	public void setTposition(Tposition tposition) {
		this.tposition = tposition;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDEPT")
	public Tdept getTdept() {
		return this.tdept;
	}

	public void setTdept(Tdept tdept) {
		this.tdept = tdept;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CORIGION")
	public Torigin getTorigin() {
		return this.torigin;
	}

	public void setTorigin(Torigin torigin) {
		this.torigin = torigin;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CJOB")
	public Tjob getTjob() {
		return this.tjob;
	}

	public void setTjob(Tjob tjob) {
		this.tjob = tjob;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDEGREE")
	public Tdegree getTdegree() {
		return this.tdegree;
	}

	public void setTdegree(Tdegree tdegree) {
		this.tdegree = tdegree;
	}

	@Column(name = "CADDRESS", length = 100)
	public String getCaddress() {
		return this.caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	@Column(name = "CBIRTHDAY", length = 19)
	public Timestamp getCbirthday() {
		return this.cbirthday;
	}

	public void setCbirthday(Timestamp cbirthday) {
		this.cbirthday = cbirthday;
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

	@Column(name = "CIDENTITY", length = 100)
	public String getCidentity() {
		return this.cidentity;
	}

	public void setCidentity(String cidentity) {
		this.cidentity = cidentity;
	}

	@Column(name = "CMAIL", length = 100)
	public String getCmail() {
		return this.cmail;
	}

	public void setCmail(String cmail) {
		this.cmail = cmail;
	}

	@Column(name = "CMARRY", length = 10)
	public String getCmarry() {
		return this.cmarry;
	}

	public void setCmarry(String cmarry) {
		this.cmarry = cmarry;
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

	@Column(name = "CSEX", length = 1)
	public String getCsex() {
		return this.csex;
	}

	public void setCsex(String csex) {
		this.csex = csex;
	}

	@Column(name = "CSTATUS", length = 1)
	public String getCstatus() {
		return this.cstatus;
	}

	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	@Column(name = "CTEL", scale = 0)
	public BigDecimal getCtel() {
		return this.ctel;
	}

	public void setCtel(BigDecimal ctel) {
		this.ctel = ctel;
	}

	@Column(name = "CPARTMENT", length = 36)
	public String getCpartment() {
		return this.cpartment;
	}

	public void setCpartment(String cpartment) {
		this.cpartment = cpartment;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "temp")
	public Set<Tself> getTselfs() {
		return this.tselfs;
	}

	public void setTselfs(Set<Tself> tselfs) {
		this.tselfs = tselfs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "temp")
	public Set<Taudit> getTaudits() {
		return this.taudits;
	}

	public void setTaudits(Set<Taudit> taudits) {
		this.taudits = taudits;
	}

}