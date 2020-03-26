package com.ibm.developer.hellotwitch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TwitchUser {

	@Id
	@SequenceGenerator(name = "twitchUserIdGen", sequenceName = "twitchUserIdGen", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "twitchUserIdGen")
	private Long twitchUserId;
	private String twitchUserTag;
	private String displayName;
	private String bio;

	public TwitchUser() {
		super();
	}

	public TwitchUser(String twitchUserTag, String displayName, String bio) {
		super();
		this.twitchUserTag = twitchUserTag;
		this.displayName = displayName;
		this.bio = bio;
	}

	public Long getTwitchUserId() {
		return twitchUserId;
	}

	public void setTwitchUserId(Long twitchUserId) {
		this.twitchUserId = twitchUserId;
	}

	public String getTwitchUserTag() {
		return twitchUserTag;
	}

	public void setTwitchUserTag(String twitchUserTag) {
		this.twitchUserTag = twitchUserTag;
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
