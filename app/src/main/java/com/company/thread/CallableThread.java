package com.company.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "123";
    }

    public static void main(String[] args) {
        Callable<String> task = new CallableThread();

    }
}
