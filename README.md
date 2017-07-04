Entity Seeder
=============
A simple java data seeder inspired on Laravel Database Seeder feature.

Usage
-----

All entities that you want to generate, need to implement the ```EntitySeed``` interface.

```java
public class User implements EntitySeed {
    ...
}
```    

Create a seeder class for your entity. This class must extend ```AbstractEntitySeeder<K>``` and implement the ```make()``` method inherited from interface. This method will be called by the ```Factory``` class.

```java
public class UserSeeder extends AbstractEntitySeeder<User> {
	
    private static String password = BCrypt.hashpw("secret", BCrypt.gensalt());
    
    public User make() {
        Name name = this.getFaker().name();
        User user = new User();
        user.setName(name.fullName());
        user.setEmail(name.username() + "@mail.com");
        user.setPassword(password);

        return user;
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

In order to use locale, write a constructor that receives a locale as a parameter in your seeder class and call the equivalent constructor from the parent.

```java
public UserSeeder(Locale locale) {
    super(locale);
}
...
new UserSeeder(new Locale("pt_BR"));
```
Libraries
---------

* [Java Faker](https://github.com/DiUS/java-faker)
	* **Java Faker** is a port of Ruby's stympy/faker gem (as well as Perl's Data::Faker library) that generates fake data. It's useful when you're developing a new project and need some pretty data for showcase.
* [JBCrypt](https://github.com/djmdjm/jBCrypt)
	* **JBCrypt** is an implementation the OpenBSD Blowfish password hashing algorithm, as described in "A Future-Adaptable Password Scheme" by Niels Provos and David Mazieres: http://www.openbsd.org/papers/bcrypt-paper.ps
