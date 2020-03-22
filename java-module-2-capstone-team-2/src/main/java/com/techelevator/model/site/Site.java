package com.techelevator.model.site;

public class Site {
	
	private Long siteId;
	private Integer campgroundId;
	private Integer siteNumber;
	private Integer maxOccupancy;
	private Boolean accessible;
	private Integer maxRvLength;
	private Boolean utilities;
	
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public Integer getCampgroundId() {
		return campgroundId;
	}
	public void setCampgroundId(Integer campgroundId) {
		this.campgroundId = campgroundId;
	}
	public Integer getSiteNumber() {
		return siteNumber;
	}
	public void setSiteNumber(Integer siteNumber) {
		this.siteNumber = siteNumber;
	}
	public Integer getMaxOccupancy() {
		return maxOccupancy;
	}
	public void setMaxOccupancy(Integer maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}
	public Boolean getAccessible() {
		return accessible;
	}
	public void setAccessible(Boolean accessible) {
		this.accessible = accessible;
	}
	public Integer getMaxRvLength() {
		return maxRvLength;
	}
	public void setMaxRvLength(Integer maxRvLength) {
		this.maxRvLength = maxRvLength;
	}
	public Boolean getUtilities() {
		return utilities;
	}
	public void setUtilities(Boolean utilities) {
		this.utilities = utilities;
	}
}
