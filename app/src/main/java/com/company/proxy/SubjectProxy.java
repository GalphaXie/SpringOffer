package com.company.proxy;

/**
 * ้ๆไปฃ็
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
