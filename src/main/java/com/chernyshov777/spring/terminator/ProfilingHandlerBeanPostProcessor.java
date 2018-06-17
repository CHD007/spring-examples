package com.chernyshov777.spring.terminator;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {

    private ProfilingController controller = new ProfilingController();
    private Map<String, Class<?>> beansClasses = new HashMap<>();

    public ProfilingHandlerBeanPostProcessor() throws Exception {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        platformMBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> aClass = bean.getClass();
        if (aClass.isAnnotationPresent(Profiling.class)) {
            beansClasses.put(beanName, aClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beansClasses.get(beanName) != null) {
            Class<?> beanClass = beansClasses.get(beanName);
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
                    (Object proxy, Method method, Object[] args) -> {
                        if (controller.isEnable()) {
                            System.out.println("Profiling...");
                            long before = System.nanoTime();
                            Object retVal = method.invoke(bean, args);
                            long after = System.nanoTime();
                            System.out.println(after - before);
                            System.out.println("Done");
                            return retVal;
                        } else {
                            return method.invoke(bean, args);
                        }
                    });
        }
        return bean;
    }
}
