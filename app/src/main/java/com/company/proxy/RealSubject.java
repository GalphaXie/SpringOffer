package com.company.proxy;

public class RealSubject implements ISubject{

    @Override
    public void doAction() {
        System.out.println("real action");
    }

    @Override
    public void bye() {
        System.out.println("real bye");
    }
}
