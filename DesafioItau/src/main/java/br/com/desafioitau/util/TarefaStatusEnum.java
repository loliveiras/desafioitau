package br.com.desafioitau.util;

public enum TarefaStatusEnum {
	
	STATUS_PENDING("Pending"),
	STATUS_COMPLETED("Completed");
	
	private final String value;
	
	private TarefaStatusEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
