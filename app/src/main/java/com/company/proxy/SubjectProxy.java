package com.company.proxy;

/**
 * 静态代理
 */
public class SubjectProxy implements ISubject{
    private ISubject iSubject;


    @Override
    public void doAction() {

    }

    @Override
    public void bye() {

    }

    public SubjectProxy(){
        iSubject = new RealSubject();
    }
}
