package com.ibm.developer.hellotwitch;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class TwitchUsersController {

	private TwitchUserRepo repo;
	private TwitchService service;

	public TwitchUsersController(TwitchUserRepo repo, TwitchService service) {
		super();
		this.repo = repo;
		this.service = service;
	}

	@GetMapping
	public Iterable<TwitchUser> findAllUsers() {
		return repo.findAll();
	}

	@GetMapping("/{twitchUserId}")
	public TwitchUser findById(@PathVariable String twitchUserId) {
		return repo.findById(Long.valueOf(twitchUserId)).get();
	}

	@PostMapping
	public ResponseEntity<TwitchUser> addNew(@RequestBody TwitchUser twitchUser) {
		TwitchUser newTwitchUser = service.addNewUser(twitchUser);
		return ResponseEntity.created(URI.create(String.format("/api/v1/users/%d", newTwitchUser.getTwitchUserId())))
				.body(newTwitchUser);
	}

	@ExceptionHandler(ClientException.class)
	public ResponseEntity<String> handleClientExceptions(ClientException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}
