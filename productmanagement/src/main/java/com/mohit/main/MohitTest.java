// start with main method
// call getOutput by passing data
// in getOutput method convert the data and store as collection of map
// after converting call getOutput1 by passing list of map(fromJson) here we get data as a map so store in response map
// in getOutput1 first we take child by parentId ---and store childEmployeesByParentId
// then create new response list of map
// create foreach for child //it's start with parent({id=2.0, name=Sharad, parent=0.0}) // second time parent is which object have id=1 // then next id=3 is become a parent
// here we add data in response which are got by calling getOutput method
// in getOutput first we check id is exist or not // first time id=2 then id=1 then id=3
// take the every child from listOfChildren by using  foreach (in this foreach we call getOutput method it self by passing child) first pass (id=1.0, name=Yash, parent=2.0) as a child
// after that add value in employee (child as a key/listOfChildrens as a value)
// then using employee.remove(PARENT) remove parent from map of employee


package com.mohit.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;

public class MohitTest {

	private static final String PARENT = "parent";


	public static void main(String[] args) {
		System.out.println(getOutput( // call getOutput by passing value
				"[{\"id\":1,\"name\":\"Yash\",\"parent\":2},{\"id\":2,\"name\":\"Sharad\",\"parent\":0},{\"id\":3,\"name\":\"Bhavin\",\"parent\":1},{\"id\":4,\"name\":\"Dattu\",\"parent\":3},{\"id\":5,\"name\":\"Anil\",\"parent\":3}]"));
	}
//  convert and store in list of map...
	@SuppressWarnings("unchecked")
	public static String getOutput(String string) {
		Gson gson = new Gson();
		List<Map<String, Object>> fromJson = gson.fromJson(string, List.class); // store data in list (collection of map)
		Map<String, Object> response = getOutput1(fromJson).get(0);  // calling getOutput1 method here we are passing List (fromJson)
		return gson.toJson(response); 
	}

	private static List<Map<String, Object>> getOutput1(List<Map<String, Object>> allEmployee) {
		Map<Object, List<Map<String, Object>>> childEmployeesByParentId = allEmployee.stream()
				.collect(Collectors.groupingBy(employeeDetail -> employeeDetail.get(PARENT))); // collect child using parent
		List<Map<String, Object>> response = new ArrayList<>(); // create new List(collection of map)...
		for (Map<String, Object> superParent : childEmployeesByParentId.get(0.0)) { //it's start with parent({id=2.0, name=Sharad, parent=0.0}) 
			// second time parent is which object have id=1 // then next id=3 is become a parent
			response.add(getOutput(childEmployeesByParentId, superParent)); // here we add data in response which are got by calling getOutput method
		}
		return response;
	}

	private static final Map<String, Object> getOutput(Map<Object, List<Map<String, Object>>> childEmployeesByParentId,
			Map<String, Object> employee) {
		if (childEmployeesByParentId.containsKey(employee.get("id"))) { //check key is exist or not
			List<Map<String, Object>> listOfChildrens = childEmployeesByParentId.get(employee.get("id"));
			for (Map<String, Object> child : listOfChildrens) {//list of child object in sequence and pass in getOut as argument
				getOutput(childEmployeesByParentId, child); //use recursion(call it self) first pass (id=1.0, name=Yash, parent=2.0) as a child
			}
			employee.put("child", listOfChildrens); // add value in employee (child as a key/listOfChildrens as a value)
			employee.remove(PARENT);
			return employee;
		} else {
			employee.remove(PARENT);
			return employee;

		}
	}

}
