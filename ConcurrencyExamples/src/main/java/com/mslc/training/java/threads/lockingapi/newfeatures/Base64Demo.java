package com.mslc.training.java.threads.lockingapi.newfeatures;

import java.util.Base64;

public class Base64Demo {

    public static void main(String[] args) {

        String encodedString = Base64.getEncoder().encodeToString("Muhammed Shakir".getBytes());

        String decoded = new String(Base64.getDecoder().decode(encodedString));
        System.out.println(decoded);


    }
}
