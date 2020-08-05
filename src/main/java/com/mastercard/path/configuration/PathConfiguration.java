package com.mastercard.path.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class PathConfiguration {
	
	@Value("classpath:city.txt")
	private Resource file;

	@Bean(name = "paths")
	public Map<String, String> getPaths() {
		Map<String, String> connections = new HashMap<>();
		try (Scanner sc = new Scanner(file.getInputStream())) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine().trim();
				String pair[] = line.split(",");
				connections.put(pair[1].trim(), pair[0].trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return connections;
	}

}