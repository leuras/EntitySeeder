package com.github.entityseeder.sample;

import java.util.List;
import java.util.Locale;

import com.github.entityseeder.EntitySeed;
import com.github.entityseeder.Factory;

public class Test {

	public static void main(String[] args) {
		List<EntitySeed> seeds = Factory.run(new UserSeed(new Locale("pt-BR")), 10);
		
		for(EntitySeed seed : seeds) {
			User u = (User) seed;
			
			System.out.println(String.format("Name ..........:    %s", u.getName()));
			System.out.println(String.format("Email .........:    %s", u.getEmail()));
			System.out.println(String.format("Pass ..........:    %s", u.getPassword()));
			System.out.println(String.format("Address .......:    %s", u.getAddress()));
			System.out.println(System.getProperty("line.separator"));
		}
	}

}
