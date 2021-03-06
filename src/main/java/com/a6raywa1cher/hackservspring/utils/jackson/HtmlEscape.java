package com.a6raywa1cher.hackservspring.utils.jackson;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@JsonDeserialize(using = HtmlEscapeJsonDeserializer.class)
@Constraint(validatedBy = HtmlEscapeValidator.class)
public @interface HtmlEscape {
	int UNLIMITED = -1;
	int DEFAULT_LENGTH = 250;

	int value() default DEFAULT_LENGTH;

	String message() default "Too big string in escaped";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
