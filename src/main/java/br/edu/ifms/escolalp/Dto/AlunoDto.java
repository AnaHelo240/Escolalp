package br.edu.ifms.escolalp.Dto;

import br.edu.ifms.escolalp.model.Aluno;

public class AlunoDto {

	private Integer id;
	private String nome;
	private int idade;
	private String sexo;
	
	public AlunoDto() {
		
	}
	
	public AlunoDto(Aluno obj) {
		super();
		this.id= obj.getId();
		this.nome= obj.getNome();
		this.idade= obj.getIdade();
		this.sexo= obj.getSexo();		
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	
}
