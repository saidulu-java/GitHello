package org.scmp.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class ScmpService {

	private static Map<String, Long> map = new ConcurrentHashMap<String, Long>();

	public void loadMap() {
		map.put("100", 2000l);
		map.put("101", 2001l);
		map.put("102", 2002l);
		map.put("103", 2003l);
		map.put("104", 2004l);
		map.put("105", 2005l);
		map.put("106", 2006l);
		map.put("107", 2007l);
	}

	public static Map<String, Long> getMap() {
		return map;
	}

	public Long getScmpVersion(String scmpNumber) {
		return map.get(scmpNumber);
	}

	public Long updateVersionNumber(String scmpNumber, Long versionNumber) {
		return map.put(scmpNumber, versionNumber);
	}

	public void addVersionNumber(String scmpNumber, Long versionNumber) {
		map.put(scmpNumber, versionNumber);
	}

	// Main
	public static void main(String args[]) {
		loadMessageMap();
		//getMap();
	}

	private static void loadMessageMap() {
		for (Long i = (long) 0; i < 100; i++) {
			MyThread object = new MyThread(i + 1);
			object.start();
		}
		System.out.println(map);
	}
}
