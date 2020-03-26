package com.ibm.developer.hellotwitch;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TwitchUserService {

	private TwitchUsersRepo repo;
	
	public TwitchUserService(TwitchUsersRepo repo) {
		super();
		this.repo = repo;
	}

	public TwitchUser findById(long id) {
		Optional<TwitchUser> twitchUser = repo.findById(id);
		
		if(twitchUser.isPresent()) {
			return twitchUser.get();
		}
		throw new ClientException(String.format("Could not find user for id: %d", id));
	}

	public TwitchUser addTwitchUser(TwitchUser twitchUser) {
		if(!StringUtils.isBlank(twitchUser.getTwitchTag())) {
			return repo.save(twitchUser);
		}
		throw new ClientException("Missing Required Field: Twitch Tag");
	}
}
