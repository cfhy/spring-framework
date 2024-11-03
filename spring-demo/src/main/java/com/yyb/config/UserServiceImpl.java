package com.yyb.config;

import org.springframework.stereotype.Service;

/**
 * @author: yyb
 * @date: 2023/12/24 22:48
 * @description:
 */

@Service
public class UserServiceImpl implements UserService {

	@Override
	@LogAnnotation
	public void addUser(String username, String password) {
		System.out.println("addUser");
	}
}

