package com.linkedin.javacodechallenges;

public class App 
{
    public static void main( String[] args )
    {
        Person person1 = new Person("John", "Wick", 45);
        Person person2 = new Person("Keanu", "Reeves", 58);
        Person person3 = new Person("Donnie", "Yen", 59);

        System.out.println(person1.getIntroduction());
        System.out.println(person2.getIntroduction());
        System.out.println(person3.getIntroduction());
    }
}
