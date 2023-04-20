package com.spring.skaiciuotuvas;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
// Web controleris leidcia viduje naudoti @RequestMapping
// RestController anotacija nurodo, jog pvz String tipo rezultatas turetu buti isspausdinimas klientui toks koks yra.
// jokiu vaizdu jokiu formu tiesiog paprasta eilute tarp kabuciu be pagrazinimu

@RestController
// @EnableAutoConfiguration zymi konfig komponenta, viduje leidzia kurti bean per metodus su @bean anotacija
// si klases lygio anotacija nurodo spring anotacijai "atspeti" konfiguracija
// rementis priklausomybemis (jar bibliotek) kurias programuotojas itraukia i projekta ( pom.xml)
//Siuo atveju ji veikia kartu su main metodu

/*
@EnableAutoConfiguration
public class InternetinisSkaiciuotuvasController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        //Yra interface skirtas suteikti info apie aplikacija konfig

        return "Internetinis Skaiciuotuvas <p>" +
                "<b> galimos operacijos : <br><br>" +
                "<li>&nbsp; &nbsp; sudeti <br>" +
                "<li>&nbsp; &nbsp; atimti <br>" +
                "<li>&nbsp; &nbsp; dauginti <br>" +
                "<li>&nbsp; &nbsp; dalinti <br><p>";
    }


}*/

/*
@EnableAutoConfiguration
public class InternetinisSkaiciuotuvasController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String skaiciuoti(@RequestParam HashMap<String,String> skaiciai) {
        // siuo atveju naudojama konfigurac paima is beans.xml
        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        // bean - atitinka singleton sablona, bus sukurta tik viena objekto aplikacija, beanai kaskokios klases objektas
        HelloWorld bean = (HelloWorld) appContext.getBean("helloWorld");
        return bean.getHello();

    }
}*/

@EnableAutoConfiguration
public class InternetinisSkaiciuotuvasController {
    @RequestMapping(method = RequestMethod.GET, value = "/skaiciuoti")
    // RequestParam perduoda per url perduotus duomenis kurie patalpinami i sarasa hashmap (raktas - reiksme) du skaiciai operacijos zenklas
    // kurie patalpinami i sarasa
    // pirmas Stringas yra raktas sk1 sk2 o antras String yra reiksme (8, 5, +(
    // raktai tiek fronTend tiek beckend enda turi sutapti SVARBU
    // url pvz http://localhost:8080/skaiciuoti?sk1=2&sk2=3&zenklas=* atvaizduos 23*
    public String skaiciuoti(@RequestParam HashMap<String, String> skaiciai) {
        // per url perduodamas raktas (kintamasis) turi pav sk1
        // pagal rakta sk1 istraukia reiksme pvz vartotojas  ivede 8
        // vadinasi reikia konvertuoti is strungo i inta kad paskaiciuoti rezultata
        int sk1 = Integer.parseInt(skaiciai.get("sk1"));
        int sk2 = Integer.parseInt(skaiciai.get("sk2"));
        double atsakymas = 0;

        String zenklas = skaiciai.get("zenklas");

        if (zenklas.equals("+")) {
            atsakymas = sk1 + sk2;
        } else if (zenklas.equals("-")) {
            atsakymas = sk1 - sk2;
        } else if (zenklas.equals("*")) {
            atsakymas = sk1 * sk2;
        } else if (zenklas.equals("/") && sk2 == 0) {
            atsakymas = sk1 / sk2;
        }


        // TODO: suskaiciuoti ir atspausdinti rezultata nurodant kas is ko buvo gauta
        return sk1 + " " + zenklas + "" + sk2 + "" + " = " + atsakymas;

        //  ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");

        //  HelloWorld bean = (HelloWorld) appContext.getBean("helloWorld");
        // return bean.getHello();

    }
}
