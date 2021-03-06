package com.ishmail;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // specifies that this annotation is to be retained at runtime
@Target({ElementType.FIELD, ElementType.PARAMETER}) // specifies that this applies to the fields(attributes) and the method parameter
@Qualifier // used to determine which method the object is being called in
public @interface AddEvent {
}
