package com.company.lambda;


/**
 * lambda方法
 * 1.生成一个lambda$1 的内部类，生成一个私有化方法
 * 2. 在内部类中调用私有化的方法
 */
public class MyLambda {
//    public void generateLambda(){
//        new Thread(()-> System.out.println("hello"));
//
//    }

    @FunctionalInterface
    public interface LambdaDemo{
        public void runLambda();
    }

    public static void doSomeThing(LambdaDemo demo){
        demo.runLambda();
    }

    public static void main(String[] args){
        doSomeThing(()-> System.out.println("hello"));
    }
}
