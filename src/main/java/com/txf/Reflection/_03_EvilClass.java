package com.txf.Reflection;

import java.io.IOException;

public class _03_EvilClass {
    static{
        Runtime runtime = Runtime.getRuntime();
        String[] command = {"open","-a","Calculator.app"};

        try {
            runtime.exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
