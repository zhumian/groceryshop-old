package com.zhumian.groceryshop.annotation;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface FuzzyQuery {
}
