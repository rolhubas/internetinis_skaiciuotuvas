package com.spring.skaiciuotuvas;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// servlet yra java programa veikianti web serverije
// paleidziamas kai vartotojas paspaudzia nuoroda, pateikia
// forma ar atlieka kito tipo veiksmus internetineje svetaineja
// kiekviena klijento uzklausa (request) praeina per servlet kuris ji perduoda
// kontrolerio request mapping atribute.
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InternetinisSkaiciuotuvasApplication.class);
	}

}
