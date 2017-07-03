package com.github.entityseeder;

public interface EntitySeeder<K extends EntitySeed> {
	K make();
}
