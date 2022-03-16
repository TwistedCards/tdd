package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Employee;

class BonusServiceTest {

	/**
	 * Bonus deveria ser zero para funcionario com salario muito alto
	 * 
	 * @author paulo
	 */
	@Test
	void bonusShouldBeZeroForEmployeeWithSalaryVeryHigh() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calculateBonus(new Employee("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
		
		assertEquals(new BigDecimal("0.00"), bonus);
	}
	
	/**
	 * Bonus deveria ser 10 por centro do salario
	 * 
	 * @author paulo
	 */
	@Test
	void bonusShouldBe10PerSalaryCenter() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calculateBonus(new Employee("Rodrigo", LocalDate.now(), new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	/**
	 * Bonus deveria ser 10 por cento para salario de exatamente 10000
	 * 
	 * @author paulo
	 */
	@Test
	void bonusShouldBeTenPercentForSalaryExactly10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calculateBonus(new Employee("Rodrigo", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
