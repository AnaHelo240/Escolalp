package br.edu.ifms.escolalp.Dto;

public class CursoDto {
	
		private Integer id;
		private String nome;
		private String anoDuracao;

	
	public CursoDto() {
		
	}

	public CursoDto(CursoDto obj) {
		super();
		this.id= obj.getId();
		this.nome= obj.getNome();
		this.anoDuracao= obj.getAnoDuracao();
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

	public String getAnoDuracao() {
		return anoDuracao;
	}

	public void setAnoDuracao(String anoDuracao) {
		this.anoDuracao = anoDuracao;
	}
	
}
