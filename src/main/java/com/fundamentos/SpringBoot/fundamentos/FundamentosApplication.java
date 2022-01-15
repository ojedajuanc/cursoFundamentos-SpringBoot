package com.fundamentos.SpringBoot.fundamentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fundamentos.SpringBoot.fundamentos.bean.MyBean1;
import com.fundamentos.SpringBoot.fundamentos.component.ComponentDependency;
import com.fundamentos.SpringBoot.fundamentos.services.BeanWithDependencies;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	
	private ComponentDependency componentDependency;
	private MyBean1 myBean;
	private BeanWithDependencies beanWithDependencie;
	
	/**Se utiliza el annotation Qualifier para que SpringBoot sepa
	 * a qué componente llamar cuando dos o más tienen misma implementación
	*/
	public FundamentosApplication(@Qualifier("component2Impl") ComponentDependency componentDependency,
			MyBean1 myBean, BeanWithDependencies beanWithDependencie) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.beanWithDependencie = beanWithDependencie;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.hello();
		System.out.println(beanWithDependencie.operationWithDependencies());
	}

}
