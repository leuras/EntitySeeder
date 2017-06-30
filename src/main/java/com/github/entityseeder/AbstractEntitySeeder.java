package com.github.entityseeder;

import java.util.Locale;

import com.github.javafaker.Faker;

public abstract class AbstractEntitySeeder<K> implements EntitySeeder<K> {
	
	private Faker faker;
	
	public AbstractEntitySeeder() {
		this.faker = new Faker();
	}
	
	public AbstractEntitySeeder(final Locale locale) {
		this.faker = new Faker(locale);
	}
	
	public Faker getFaker() {
		return this.faker;
	}
}
