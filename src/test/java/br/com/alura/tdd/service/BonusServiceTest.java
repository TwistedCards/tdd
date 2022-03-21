package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Employee;

class BonusServiceTest {

	/**
	 * Bonus deveria ser zero para funcionario com salario muito alto, mas testando com exception
	 * 
	 * @author paulo
	 */
	@Test
	void bonusShouldBeZeroForEmployeeWithSalaryVeryHighButWhitExceptionNow() {
		BonusService service = new BonusService();
		
		// First way to do it
		assertThrows(IllegalArgumentException.class, 
						() -> service.calculateBonus(new Employee("Rodrigo", LocalDate.now(), new BigDecimal("25000")))
					);
		
		// Second way to do it
//		try {
//			service.calculateBonus(new Employee("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
//			fail("Não deu a exception!");
//		} catch (Exception e) {
//			assertEquals("Funcionário com salario maior do que R$1000 não pode receber bonus", e.getMessage());
//		}
		
	}
	
	/**
	 * Bonus deveria ser zero para funcionario com salario muito alto
	 * 
	 * @author paulo
	 */
//	@Test
//	void bonusShouldBeZeroForEmployeeWithSalaryVeryHigh() {
//		BonusService service = new BonusService();
//		BigDecimal bonus = service.calculateBonus(new Employee("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
//		
//		assertEquals(new BigDecimal("0.00"), bonus);
//	}
	
	
	
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
