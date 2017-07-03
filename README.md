# **Entity Seeder**
--------------------------------------


A simple java data seeder inspired on Laravel Database Seeder feature.


### Usage
---------

All entities that you want to generate, need to implement the ```EntitySeed``` interface.

```java
    public class User implements EntitySeed {
    ...
    }
```    

Create a seeder class for your entity. This class must extends ```AbstractEntitySeeder<K>``` and implements the ```make()``` method. This method will be called by the ```Factory``` class.

```java
    public class UserSeeder extends AbstractEntitySeeder<User> {
	
		private static String password = BCrypt.hashpw("secret", BCrypt.gensalt());
	
		public User make() {
			
			Name name = this.getFaker().name();
			
			User user = new User();
			user.setName(name.fullName());
			user.setEmail(name.username() + "@mail.com");
			user.setPassword(password);
						
			return u;
		}

}
```
Call the ```Factory.run()``` method, passing the seeder class and the number of instances do you want to create.

```java
	List<EntitySeed> seeds = Factory.run(new UserSeeder(), 10);
```

To make only one instance of you seed class, use ```Factory.make()``` or ```YourSeederClass.make()```.

```java
	User user = (User)Factory.make(new UserSeeder());
	Person person = new PersonSeeder().make();
```

### Using Locale
----------------

In your seeder class, write a constructor that receives a locale as a parameter and call the equivalent constructor from the parent.

```java
	public UserSeeder(Locale locale) {
		super(locale);
	}
```
