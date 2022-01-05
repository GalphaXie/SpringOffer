package com.company.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * 使用代理必须是实现接口的类
 * 最终生成的代理类也是实现接口的代理类
 * 处理器
 */
public class JdkSubjectProxy implements InvocationHandler {
    private Object real;
    public JdkSubjectProxy(Object real){
        this.real = real;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(real, args); // 执行目标对象方法
        return result;
    }

    public static void main(String[] args) {
        ISubject subject = (ISubject) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class<?>[] {ISubject.class}, new JdkSubjectProxy(new RealSubject()));

    }
}
