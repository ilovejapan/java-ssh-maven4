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
 * Tkpi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tkpi", catalog = "schooldb")
public class Tkpi implements java.io.Serializable {

	// Fields

	private String cid;
	private Tposition tposition;
	private Tjob tjob;
	private String ccontent;
	private Timestamp ccreatedatetime;
	private String ccreateid;
	private Timestamp cmodifydatetime;
	private String cmodifyid;
	private String cname;
	private String cstatus;
	private Set<Tself> tselfs = new HashSet<Tself>(0);

	// Constructors

	/** default constructor */
	public Tkpi() {
	}

	/** minimal constructor */
	public Tkpi(String cid) {
		this.cid = cid;
	}

	/** full constructor */
	public Tkpi(String cid, Tposition tposition, Tjob tjob, String ccontent,
			Timestamp ccreatedatetime, String ccreateid,
			Timestamp cmodifydatetime, String cmodifyid, String cname,
			String cstatus, Set<Tself> tselfs) {
		this.cid = cid;
		this.tposition = tposition;
		this.tjob = tjob;
		this.ccontent = ccontent;
		this.ccreatedatetime = ccreatedatetime;
		this.ccreateid = ccreateid;
		this.cmodifydatetime = cmodifydatetime;
		this.cmodifyid = cmodifyid;
		this.cname = cname;
		this.cstatus = cstatus;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CPOSITION")
	public Tposition getTposition() {
		return this.tposition;
	}

	public void setTposition(Tposition tposition) {
		this.tposition = tposition;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CJOB")
	public Tjob getTjob() {
		return this.tjob;
	}

	public void setTjob(Tjob tjob) {
		this.tjob = tjob;
	}

	@Column(name = "CCONTENT", length = 200)
	public String getCcontent() {
		return this.ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
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

	@Column(name = "CSTATUS", length = 1)
	public String getCstatus() {
		return this.cstatus;
	}

	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tkpi")
	public Set<Tself> getTselfs() {
		return this.tselfs;
	}

	public void setTselfs(Set<Tself> tselfs) {
		this.tselfs = tselfs;
	}

}