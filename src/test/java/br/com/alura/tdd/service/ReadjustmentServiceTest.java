package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Employee;

public class ReadjustmentServiceTest {
	
	/**
	 * O sistema deve permitir que os funcion�rios recebam um ajuste salarial anual baseado
	 * em seu desempenho, obedecendo �s seguintes regras:
	 * 
	 * - Se o desempenho foi "A desejar", reajuste ser� de apenas 3% do sal�rio;
	 * - Se o desempenho foi "Bom", reajuste ser� de apenas 15% do sal�rio;
	 * - Se o desempenho foi "�timo", reajuste ser� de apenas 20% do sal�rio;
	 */
	
	@Test
	public void readjustShouldBeThreePercentWhenPerformanceForDesirable() {
		ReadjustmentService service = new ReadjustmentService();
		Employee employee = new Employee("Paul", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.grantReadjustment(employee, Desempenho.DESIRABLE);
		assertEquals(new BigDecimal("1030.00"), employee.getWage());
	}
	
	@Test 
	public void readjustShouldBeFifteenPercentWhenPerformanceForGood() {
		ReadjustmentService service = new ReadjustmentService();
		Employee employee = new Employee("Paul", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.grantReadjustment(employee, Desempenho.GOOD);
		assertEquals(new BigDecimal("1150.00"), employee.getWage());
	}
	
	@Test 
	public void readjustShouldBeTwentyPercentWhenPerformanceForGreat() {
		ReadjustmentService service = new ReadjustmentService();
		Employee employee = new Employee("Paul", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.grantReadjustment(employee, Desempenho.GREAT);
		assertEquals(new BigDecimal("1200.00"), employee.getWage());
	}
}
