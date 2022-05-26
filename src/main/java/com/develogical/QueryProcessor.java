package com.develogical;

import java.util.Arrays;

public class QueryProcessor {

    private Integer toNumber(String s) {
        return Integer.valueOf(s.replaceAll("\\D+",""));
    }

    private Integer add(Integer a, Integer b) {
        return a + b;
    }

    public String process(String query) {
        String noWhitespace = query.toLowerCase().replaceAll("\\s+","");
        String[] plusExploded = noWhitespace.split("plus");
        if (plusExploded.length > 1) {
            return Arrays.stream(plusExploded).map(this::toNumber).reduce(this::add).toString();
        }
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("testerei")) {
            return "Tests are the thing you wanna run to know at least something works.";
        }
        if (query.toLowerCase().contains("name")) {
            return "Daniel";
        }
        return "";
    }
}
