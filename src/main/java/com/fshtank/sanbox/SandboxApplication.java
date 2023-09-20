package com.fshtank.sanbox;

import com.fshtank.sanbox.config.SpringFoxConfig;
import com.fshtank.sanbox.config.TakehomeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SandboxApplication {

	@Autowired
	private TakehomeConfig takeHomeConfig;

	private SpringFoxConfig springFoxConfig;

	public static void main(String[] args) {
		SpringApplication.run(SandboxApplication.class, args);
	}

}
