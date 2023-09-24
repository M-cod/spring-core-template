package com.epam.edu.spring.core.template.repository;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RandomInitialSequence {
    int min();
    int max();
}
