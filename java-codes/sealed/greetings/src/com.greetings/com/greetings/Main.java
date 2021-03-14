package com.greetings;

import org.astro.World;

public class Main {
    public static void main(final String... args){
	var formatString = "Greetings %1$s. %n";
        System.out.println(formatString);
        System.out.format(formatString,World.name());
        System.out.println(formatString.format("Hello"));
    }
}
