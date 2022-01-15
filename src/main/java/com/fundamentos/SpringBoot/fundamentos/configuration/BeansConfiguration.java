package com.fundamentos.SpringBoot.fundamentos.configuration;

import org.springframework.context.annotation.Bean;

import com.fundamentos.SpringBoot.fundamentos.bean.MyBean1;
import com.fundamentos.SpringBoot.fundamentos.bean.MyOperation1;
import com.fundamentos.SpringBoot.fundamentos.bean.implementation.MyBean2Impl;
import com.fundamentos.SpringBoot.fundamentos.bean.implementation.MyOperation1Impl;
import com.fundamentos.SpringBoot.fundamentos.services.BeanWithDependencies;
import com.fundamentos.SpringBoot.fundamentos.services.BeanWithDependenciesImpl;

public class BeansConfiguration {
	@Bean
	public MyBean1 myBean1() {
		return new MyBean2Impl();
	}
	
	@Bean
	public MyOperation1 example2() {
		return new MyOperation1Impl();
	}
	@Bean
	public BeanWithDependencies example3(MyOperation1 operation) {
		return new BeanWithDependenciesImpl(operation);
	}

}
