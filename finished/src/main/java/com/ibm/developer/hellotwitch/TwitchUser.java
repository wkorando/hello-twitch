package com.ibm.developer.hellotwitch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TwitchUser {

	@Id
	@SequenceGenerator(name = "twitchUserIdGen", sequenceName = "twitchUserIdGen", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "twitchUserIdGen")
	@Column(name = "TWITCH_USER_ID")
	private Long id;
	private String twitchTag;
	private String displayName;
	private String bio;

	public TwitchUser() {
		super();
	}

	public TwitchUser(String twitchTag, String displayName, String bio) {
		super();
		this.twitchTag = twitchTag;
		this.displayName = displayName;
		this.bio = bio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTwitchTag() {
		return twitchTag;
	}

	public void setTwitchTag(String twitchTag) {
		this.twitchTag = twitchTag;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

}
