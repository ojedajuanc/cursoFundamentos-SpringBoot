package com.fundamentos.SpringBoot.fundamentos.bean.implementation;

import com.fundamentos.SpringBoot.fundamentos.bean.MyOperation1;

public class MyOperation1Impl implements MyOperation1{

	@Override
	public int sum(int number) {
		return number++;
	}

}
