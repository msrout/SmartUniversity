package com.hmi.smartuni.view;

import java.util.ArrayList;

public class ClassDetailsBean {
	private String roomNo;
	private String buildingNr;
	private String capacity;
	private String subject;
	private String professor;
	private boolean smartLockEnabled;
	private String time;
	private ArrayList<String> days;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public ArrayList<String> getDays() {
		return days;
	}

	public void setDays(ArrayList<String> days) {
		this.days = days;
	}

	public boolean isSmartLockEnabled() {
		return smartLockEnabled;
	}

	public void setSmartLockEnabled(boolean smartLockEnabled) {
		this.smartLockEnabled = smartLockEnabled;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getBuildingNr() {
		return buildingNr;
	}

	public void setBuildingNr(String buildingNr) {
		this.buildingNr = buildingNr;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

}
