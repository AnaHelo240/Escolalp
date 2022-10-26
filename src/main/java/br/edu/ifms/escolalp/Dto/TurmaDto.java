package br.edu.ifms.escolalp.Dto;

public class TurmaDto {

	private Integer id;
	private String nome;
	private String turma;
	
	public TurmaDto() {
		
	}
	
	public TurmaDto(TurmaDto obj) {
		super();
		this.id= obj.getId();
		this.nome= obj.getNome();
		this.turma= obj.getTurma();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}
	
	
}
