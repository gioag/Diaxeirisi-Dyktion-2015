package models;

import java.sql.Timestamp;

public class Wifi {
	private int id;
	private String email;
	private String ssid;
	private String bssid;
	private int level;
	private int frequency;
	private double latitude;
	private double longitude;
	private Timestamp timestamp;
	
	public Wifi(int id,String email,String ssid,String bssid,int level,int frequency,double latitude,double longitude,Timestamp timestamp){
		this.setId(id);
		this.setEmail(email);
		this.setSsid(ssid);
		this.setBssid(bssid);
		this.setLevel(level);
		this.setFrequency(frequency);
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setTimestamp(timestamp);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getBssid() {
		return bssid;
	}

	public void setBssid(String bssid) {
		this.bssid = bssid;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	

}
