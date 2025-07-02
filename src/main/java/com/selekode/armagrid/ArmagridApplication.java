package com.selekode.armagrid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.selekode.armagrid.database.DatabaseCreator;
import com.selekode.armagrid.webview.ArmaGridWebview;



@SpringBootApplication
public class ArmagridApplication {

	public static void main(String[] args) {
		KillPortIfOccupied.killPortIfOccupied(8080);
		DatabaseCreator.main(args);
		SpringApplication.run(ArmagridApplication.class, args);
		ArmaGridWebview.main(args);
	}

}
