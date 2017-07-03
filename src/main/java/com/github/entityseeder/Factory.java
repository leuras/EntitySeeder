package com.github.entityseeder;

import java.util.ArrayList;
import java.util.List;

public class Factory {
	
	public static EntitySeed make(final EntitySeeder<? extends EntitySeed> seeder) {
		return seeder.make();
	}
	
	public static List<EntitySeed> run(final EntitySeeder<? extends EntitySeed> seeder, final int n) {
		List<EntitySeed> seeds = new ArrayList<EntitySeed>();

		for (int i = 0; i < n; i++)
			seeds.add(seeder.make());

		return seeds;
	}
}
