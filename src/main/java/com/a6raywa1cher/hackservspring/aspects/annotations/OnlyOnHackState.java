package com.a6raywa1cher.hackservspring.aspects.annotations;


import com.a6raywa1cher.hackservspring.model.HackState;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OnlyOnHackState {
	HackState[] value();
}
