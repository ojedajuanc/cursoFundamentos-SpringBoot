package com.fundamentos.SpringBoot.fundamentos.services;

import com.fundamentos.SpringBoot.fundamentos.bean.MyOperation1;

public class BeanWithDependenciesImpl implements BeanWithDependencies {
	//Implementa otra dependencia
	private MyOperation1 operation;

	public BeanWithDependenciesImpl(MyOperation1 operation) {
		this.operation = operation;
	}

	@Override
	public int operationWithDependencies() {
		int value = 1;
		value = operation.sum(value);
		return value;
	}
}
