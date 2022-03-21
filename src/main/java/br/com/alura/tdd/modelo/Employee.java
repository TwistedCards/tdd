package br.com.alura.tdd.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Employee {

	private String name;
	private LocalDate admissionDate;
	private BigDecimal wage;

	public Employee(String name, LocalDate admissionDate, BigDecimal wage) {
		this.name = name;
		this.admissionDate = admissionDate;
		this.wage = wage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public BigDecimal getWage() {
		return wage;
	}

	public void setWage(BigDecimal wage) {
		this.wage = wage;
	}

	public void readjustWage(BigDecimal reajuste) {
		this.wage = this.wage.add(reajuste) ;
		roundUpSalary();
	}

	private void roundUpSalary() {
		this.wage = this.wage.setScale(2, RoundingMode.HALF_UP);
	}
}
