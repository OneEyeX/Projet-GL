package com.xtensus.passosyf;

import org.apache.chemistry.opencmis.client.api.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PassosyfApplication implements CommandLineRunner{

    private static Logger log = LoggerFactory.getLogger(Document.class);
	public static void main(String[] args) {
		SpringApplication.run(PassosyfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	

	}

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		PassosyfApplication.log = log;
	}

}
