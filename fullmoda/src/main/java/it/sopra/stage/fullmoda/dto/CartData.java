package it.sopra.stage.fullmoda.dto;

import java.util.List;

public class CartData {

	private Long id;
	private List<CartEntryData> entries;
	private UserData user;
	private WebsiteData website;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<CartEntryData> getEntries() {
		return entries;
	}
	public void setEntries(List<CartEntryData> entries) {
		this.entries = entries;
	}
	public UserData getUser() {
		return user;
	}
	public void setUser(UserData user) {
		this.user = user;
	}
	
	public WebsiteData getWebsite() {
		return website;
	}
	public void setWebsite(WebsiteData website) {
		this.website = website;
	}
	public CartData(Long id, List<CartEntryData> entries, UserData user, WebsiteData website) {
		this.id = id;
		this.entries = entries;
		this.user = user;
		this.website = website;
	}
	
	@Override
	public String toString() {
		return "CartData [id=" + id + ", entries=" + entries + ", user=" + user + "]";
	}
	
	
}
