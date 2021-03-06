package com.a6raywa1cher.hackservspring.utils.hibernate;

import org.hibernate.QueryException;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.Type;

import java.util.List;

public class BitwiseAndStandardSQLFunction extends StandardSQLFunction
		implements SQLFunction {

	public BitwiseAndStandardSQLFunction(String name) {
		super(name);
	}

	public BitwiseAndStandardSQLFunction(String name, Type type) {
		super(name, type);
	}

	public String render(List<?> args, SessionFactoryImplementor factory)
			throws QueryException {

		if (args.size() != 2) {
			throw new IllegalArgumentException("the function must be passed 2 arguments");
		}

		return args.get(0).toString() + " & " + args.get(1);
	}
}