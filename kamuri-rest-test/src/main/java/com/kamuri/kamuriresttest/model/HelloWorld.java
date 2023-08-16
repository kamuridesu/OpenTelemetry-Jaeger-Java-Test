package com.kamuri.kamuriresttest.model;

import java.util.HashMap;
import java.util.Map;

public class HelloWorld {
    
    public static Map<String, String> getHelloWorld() {
        Map<String, String> helloWorld = new HashMap<>();
        helloWorld.put("message", "Hello World");
        return helloWorld;
    }

}
