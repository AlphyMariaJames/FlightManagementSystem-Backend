package com.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_Id")
	private Integer scheduleID;
	private String source;
	private String destination;
	@Column(name = "departure_date")
	private String deptDateTime;
	@Column(name = "arrival_date")
	private String arrDateTime;
	
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Schedule(Integer scheduleID, String source, String destination, String deptDateTime, String arrDateTime) {
		super();
		this.scheduleID = scheduleID;
		this.source = source;
		this.destination = destination;
		this.deptDateTime = deptDateTime;
		this.arrDateTime = arrDateTime;
	}
	public Integer getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(Integer scheduleID) {
		this.scheduleID = scheduleID;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDeptDateTime() {
		return deptDateTime;
	}
	public void setDeptDateTime(String deptDateTime) {
		this.deptDateTime = deptDateTime;
	}
	public String getArrDateTime() {
		return arrDateTime;
	}
	public void setArrDateTime(String arrDateTime) {
		this.arrDateTime = arrDateTime;
	}
	@Override
	public String toString() {
		return "Schedule [scheduleID=" + scheduleID + ", source=" + source + ", destination=" + destination
				+ ", deptDateTime=" + deptDateTime + ", arrDateTime=" + arrDateTime + "]";
	}
	
}
