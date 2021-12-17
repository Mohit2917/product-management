package com.mohit.main2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.gson.Gson;

public class Test {
	private static final String ID ="id";
	private static final String NAME="name";
	static List<Map<String,Object>> list = new ArrayList<>();
	static Map<String,Object> map = new HashMap<>();
	public static void main(String[] args) {
		getOutput(
				"[{\"id\":1,\"name\":\"Yash\",\"parent\":2},{\"id\":2,\"name\":\"Sharad\",\"parent\":0},{\"id\":3,\"name\":\"Bhavin\",\"parent\":1},{\"id\":4,\"name\":\"Dattu\",\"parent\":3},{\"id\":5,\"name\":\"Anil\",\"parent\":3}]");
	}

	private static void getOutput(String string) {
		
		Gson gson = new Gson();
		List<Map<String, Object>> fromJson = gson.fromJson(string, List.class); 
		getOutput1(fromJson); 
	}

	private static void getOutput1(List<Map<String, Object>> allEmployee) {

		allEmployee.stream();
		
	}


}
