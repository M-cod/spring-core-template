package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.repository.RandomInitialSequence;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

@Configuration
public class RandomInitialSequenceAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = bean.getClass().getDeclaredMethods();
        for (Method method : methods){
            RandomInitialSequence randomInitialSequence = method.getAnnotation(RandomInitialSequence.class);
            if (randomInitialSequence != null){
                int min = randomInitialSequence.min();
                int max = randomInitialSequence.max();
                Random random = new Random();
                try {
                    method.invoke(bean, random.nextInt(max - min) + min);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
