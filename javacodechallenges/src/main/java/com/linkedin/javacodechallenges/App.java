package com.linkedin.javacodechallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {
    public static List<String> findStudentsWithIncompleteVolunteerEvents(
            List<String> students,
            Map<String, List<String>> attendeesMapping) {
        // TODO: implement function
        Map<String, Integer> studentWithAttendance = students.stream().collect(Collectors.toMap(Function.identity(), value -> 0));
        
        /* sample code
        attendeesMapping.values()
                        .forEach(list -> list.stream()
                                        .filter(studentName -> studentWithAttendance.containsKey(studentName))
                                        .forEach(filteredStudent -> studentWithAttendance.put(filteredStudent, studentWithAttendance.get(filteredStudent)+1)));

        return studentWithAttendance.entrySet().stream()
                        .filter(map -> map.getValue() < 2)
                        .map(studentWithIncompleteMap -> studentWithIncompleteMap.getKey())
                        .toList();
        */
        for(String activity : attendeesMapping.keySet()) {
            List<String> studentsArrayList = new ArrayList<>(students);
            List<String> attendeesArrayList = new ArrayList<>(attendeesMapping.get(activity));
            studentsArrayList.retainAll(attendeesArrayList);
            for(String attendeeName : studentsArrayList) {
                studentWithAttendance.put(attendeeName, studentWithAttendance.get(attendeeName)+1);
            } 
        }

        List<String> studentWithIncomplete = new ArrayList<>();
        for(String studentName : studentWithAttendance.keySet()) {
            if(studentWithAttendance.get(studentName) < 2) {
                studentWithIncomplete.add(studentName);
            }    
        }

        return studentWithIncomplete;
    }

    public static void main(String[] args) {
        List<String> students = List.of("Sally", "Polly", "Molly",
                "Tony", "Harry");

        Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market", List.of("Sally", "Polly"),
                "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
                "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
                "Midnight Breakfast", List.of("Polly", "Molly"));

        System.out.println(findStudentsWithIncompleteVolunteerEvents(
                students, attendeesMapping));
    }

}
