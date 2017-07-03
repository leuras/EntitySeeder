package com.github.entityseeder.sample;

import java.util.Locale;

import org.mindrot.jbcrypt.BCrypt;

import com.github.entityseeder.AbstractEntitySeeder;
import com.github.javafaker.Name;

public class UserSeeder extends AbstractEntitySeeder<User> {
	
	private static String password = BCrypt.hashpw("secret", BCrypt.gensalt());
	
	public UserSeeder(Locale locale) {
		super(locale);
	}
	
	public User make() {
		
		Name name = this.getFaker().name();
		
		User u = new User();
		u.setName(name.fullName());
		u.setEmail(name.username() + "@mail.com");
		u.setPassword(password);
		u.setAddress(this.getFaker().address().fullAddress());
		
		return u;
	}

}
