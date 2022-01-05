package com.company.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 实现拦截器
 * 生成的代理类是继承原始对象的
 * 还要写一个获取动态代理类实例的方法getProxyInstance
 */
public class CglibSubjectProxy implements MethodInterceptor {
    private Object target;
    CglibSubjectProxy(Object target){
        this.target = target;
    }


    public Object getProxyInstance()
    {
        //1. 实例化工具类
        Enhancer en = new Enhancer();
        //2. 设置父类对象
        en.setSuperclass(this.target.getClass());
        //3. 设置回调函数
        en.setCallback(this);
        //4. 创建子类，也就是代理对象
        return en.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        // 执行目标对象的方法
        Object returnValue = method.invoke(target, objects);
        System.out.println("关闭事务");
        return null;
    }

    public static void main(String[] args) {
        RealSubject proxy =(RealSubject)new CglibSubjectProxy(new RealSubject()).getProxyInstance();
    }
}
