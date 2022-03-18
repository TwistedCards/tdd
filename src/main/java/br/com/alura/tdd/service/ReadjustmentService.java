package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Employee;

public class ReadjustmentService {
	
	/*
	public void grantReadjustment(Employee employee, Desempenho desempenho) {
		if (desempenho == Desempenho.DESIRABLE) {
			BigDecimal reajuste = employee.getWage().multiply(new BigDecimal("0.03"));
			employee.readjustWage(reajuste);
		} else if(desempenho == Desempenho.GOOD) {
			BigDecimal reajuste = employee.getWage().multiply(new BigDecimal("0.15"));
			employee.readjustWage(reajuste);
		} else {
			BigDecimal reajuste = employee.getWage().multiply(new BigDecimal("0.20"));
			employee.readjustWage(reajuste);
		}
	}
	*/
	
	public void grantReadjustment(Employee employee, Desempenho desempenho) {
		BigDecimal percentual = desempenho.percentualReajust();
		BigDecimal reajuste = employee.getWage().multiply(percentual);
		employee.readjustWage(reajuste);
	}
	
}
