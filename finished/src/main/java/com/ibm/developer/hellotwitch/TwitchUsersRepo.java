package com.ibm.developer.hellotwitch;

import org.springframework.data.repository.CrudRepository;

public interface TwitchUsersRepo extends CrudRepository<TwitchUser, Long> {

}
