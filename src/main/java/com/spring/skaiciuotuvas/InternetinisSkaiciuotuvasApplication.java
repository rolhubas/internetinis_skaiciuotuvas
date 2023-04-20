package com.spring.skaiciuotuvas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// SpringBootApplication anotacija yra lygi @Configuration, @ Enableautoconfiguration ir @ ComponentScan kitaip 3 in 1
// si anotacija nurodoma klaseje turincioje main metode

// paleidziam per explor http://127.0.0.1:8080/
@SpringBootApplication
public class InternetinisSkaiciuotuvasApplication {

	public static void main(String[] args) {
		// Programos kontrole deleguojama statiniam klases metodui run
		// nurodant aplikacijos saknini komponenta (root)
		// Spring karkasas paleis aplikacija t.y. startuos Tomcat serveryje
		SpringApplication.run(InternetinisSkaiciuotuvasApplication.class, args);
	}

}
