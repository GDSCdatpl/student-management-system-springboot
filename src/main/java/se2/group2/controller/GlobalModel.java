package se2.group2.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalModel {
	public static final Map<String, Object> INSTANCE = new ConcurrentHashMap<String, Object>();
}
