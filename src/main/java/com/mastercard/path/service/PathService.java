package com.mastercard.path.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PathService {

	@Autowired
	@Qualifier("paths")
	public Map<String, String> paths;

	public String checkConnection(String origin, String destination) {
		String res = "no";
		Map<String, String> connectionMap = paths;
		String source = origin;
		while (connectionMap.containsKey(source)) {
			source = connectionMap.get(source);
			if (source.equals(destination)) {
				res = "yes";
				break;
			}
		}
		return res;
	}
}
