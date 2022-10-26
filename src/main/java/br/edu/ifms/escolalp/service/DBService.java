package br.edu.ifms.escolalp.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.escolalp.model.Aluno;
import br.edu.ifms.escolalp.model.Curso;
import br.edu.ifms.escolalp.model.Escola;
import br.edu.ifms.escolalp.model.Turma;
import br.edu.ifms.escolalp.repository.AlunoRepository;
import br.edu.ifms.escolalp.repository.CursoRepository;
import br.edu.ifms.escolalp.repository.EscolaRepository;
import br.edu.ifms.escolalp.repository.TurmaRepository;


@Service
public class DBService {
	

	
	@Autowired
	private EscolaRepository escola;

	@Autowired
	private CursoRepository curso;

	@Autowired
	private TurmaRepository turma;
	
	@Autowired
	private AlunoRepository aluno;
	
	public void instantiateTestDatabase() throws ParseException {

		
	    
	    
	    Escola e1 = new Escola (null, "IFMS", "3535");
	    Escola e2 = new Escola (null, "UFMS", "5050");
	    Escola e3 = new Escola (null, "UFMS", "6066");
	    
	    escola.saveAll(Arrays.asList(e1,e2,e3));
	    
		Curso c1 = new Curso (null, "ADS", "23/1/2028");
	    Curso c2 = new Curso (null, "Administrador", "24/12/2028");
	    Curso c3 = new Curso (null, "Direito", "01/12/2028");
	    
	    curso.saveAll(Arrays.asList(c1,c2,c3));
	    
	    Turma t1 = new 	Turma (null, "TurmaA", "1227", c1);
	    Turma t2 = new  Turma (null, "TurmaB", "2345", c2);
	    Turma t3 = new  Turma (null, "TurmaC", "4567", c3);
	    Turma t4 = new 	Turma (null, "TurmaD", "1256", c1);
	    Turma t5 = new  Turma (null, "TurmaE", "2398", c2);
	    Turma t6 = new  Turma (null, "TurmaF", "4576", c3);
	    
	    turma.saveAll(Arrays.asList(t1,t2,t3,t4,t5,t6));
	    
		Aluno a1 = new  Aluno (null, "Ana", 22, "feminino", e1, t1);
		Aluno a2 = new  Aluno (null, "Pedro", 23, "masculino", e2, t2);
		Aluno a3 = new  Aluno (null, "Joana", 20, "feminino", e3, t3);
		
		Aluno a5 = new  Aluno (null, "Jojo", 54, "feminino", e1, t1);
		Aluno a6 = new  Aluno (null, "Guto", 27, "masculino", e2, t2);
		Aluno a7 = new  Aluno (null, "Rafaela", 29, "feminino", e3, t3);
		
		aluno.saveAll(Arrays.asList(a1,a2,a3,a5,a6,a7));
		
	    
	    
	    
	}
}