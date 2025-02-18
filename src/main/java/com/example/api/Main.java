package com.example.api;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.api.Database.Database_instance;

@SpringBootApplication
public class Main {

	public static void main(String[] args) throws SQLException{

		Database_instance database = Database_instance.getInstance(); 
		

		SpringApplication.run(Main.class, args);
	
	}

}
