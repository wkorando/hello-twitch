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

	private TwitchUsersRepo repo;
	private TwitchUserService service;
	


	public TwitchUsersController(TwitchUsersRepo repo, TwitchUserService service) {
		super();
		this.repo = repo;
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<Iterable<TwitchUser>> getTwitchUsers() {
		return ResponseEntity.ok(repo.findAll());
	}

	@PostMapping
	public ResponseEntity<TwitchUser> addTwitchUser(@RequestBody TwitchUser twitchUser){
		TwitchUser createdTwitchuser = service.addTwitchUser(twitchUser);
		return ResponseEntity.created(URI.create(Long.toString(createdTwitchuser.getId()))).body(createdTwitchuser);
	}
	
	
	@GetMapping("/{id}")
	public TwitchUser helloX(@PathVariable long id) {
		return service.findById(id);
	}

	@ExceptionHandler(ClientException.class)
	public ResponseEntity<String> handleClientError(ClientException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}

}
