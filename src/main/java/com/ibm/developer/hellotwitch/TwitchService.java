package com.ibm.developer.hellotwitch;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TwitchService {

	private TwitchUserRepo repo;

	public TwitchService(TwitchUserRepo repo) {
		super();
		this.repo = repo;
	}
	

	public TwitchUser addNewUser(TwitchUser twitchUser) {
		if(!StringUtils.isBlank(twitchUser.getTwitchUserTag())) {
			return repo.save(twitchUser);
		}
		throw new ClientException("Twitch User Tag is a required value!");
	}
}
