package br.edu.ifms.escolalp.Dto;

public class EscolaDto {
	
	private Integer id;
	private String nome;
	private String cnpj;
	
	public EscolaDto() {
		
	}
	
	public EscolaDto(EscolaDto obj) {
		super();
		this.id= obj.getId();
		this.nome= obj.getNome();
		this.cnpj= obj.getCnpj();
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	
	
}
