package models;

public class SpecLoc {
	private String bssid;
	private double latitude;
	private double longitude;
	
	public SpecLoc(String bssid,double latitude,double longitude){
		this.setBssid(bssid);
		this.setLatitude(latitude);
		this.setLongitude(longitude);;
	}

	public String getBssid() {
		return bssid;
	}

	public void setBssid(String bssid) {
		this.bssid = bssid;
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

}
