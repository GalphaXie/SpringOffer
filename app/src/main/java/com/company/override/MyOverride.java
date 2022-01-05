package com.company.override;

public class MyOverride {
    static void hello(String str){
        System.out.println("parent"+str);
    }

    final void go(String str){
        System.out.println("parent"+str);
    }

    protected void bye(String str){
        System.out.println("parent"+str);
    }
}

class ChildClass extends MyOverride{
    static void hello(String str){
        System.out.println("child"+str);
    }

    protected void bye(String str){
        System.out.println("child"+str);
    }

}
