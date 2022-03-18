package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
	DESIRABLE {
		@Override
		public BigDecimal percentualReajust() {
			return new BigDecimal("0.03");
		}
	},
	GOOD {
		@Override
		public BigDecimal percentualReajust() {
			return new BigDecimal("0.15");
		}
	},
	GREAT {
		@Override
		public BigDecimal percentualReajust() {
			return new BigDecimal("0.2");
		}
	};
	
	public abstract BigDecimal percentualReajust();
}
