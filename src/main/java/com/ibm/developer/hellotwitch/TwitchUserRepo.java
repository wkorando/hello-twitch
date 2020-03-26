package com.ibm.developer.hellotwitch;

import org.springframework.data.repository.CrudRepository;

public interface TwitchUserRepo extends CrudRepository<TwitchUser, Long> {

}
