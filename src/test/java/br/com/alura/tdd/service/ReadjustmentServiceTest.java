package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Employee;

public class ReadjustmentServiceTest {
	
	private ReadjustmentService service;
	private Employee employee;

	// Roda toda vez antes de iniciar um metodo
	@BeforeEach
	public void inicializar() {
		System.out.println("inicializa");
		this.service = new ReadjustmentService();
		this.employee = new Employee("Paul", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	// Roda toda vez ap�s terminar um metodo
	@AfterEach
	public void finalizar() {
		System.out.println("Fim");
	}
	
	// Roda uma unica vez primeiro que todo mundo
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("ANTES DE TODOS");
	}
	
	// Roda uma unica vez assim que finaliza todos os testes
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("DEPOIS DE TODOS");
	}
	
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
		service.grantReadjustment(employee, Desempenho.DESIRABLE);
		assertEquals(new BigDecimal("1030.00"), employee.getWage());
	}
	
	@Test 
	public void readjustShouldBeFifteenPercentWhenPerformanceForGood() {
		service.grantReadjustment(employee, Desempenho.GOOD);
		assertEquals(new BigDecimal("1150.00"), employee.getWage());
	}
	
	@Test 
	public void readjustShouldBeTwentyPercentWhenPerformanceForGreat() {
		service.grantReadjustment(employee, Desempenho.GREAT);
		assertEquals(new BigDecimal("1200.00"), employee.getWage());
	}
}
