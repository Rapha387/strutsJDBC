package Actions;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Banco.Conexao;
import DAO.AlunoDAO;
import Models.Aluno;

public class AlunoAction extends ActionSupport{
	private List<Aluno> alunos;
	private Aluno aluno;
	private Integer id;

	
	public String home() {
		try(Connection conexao = new Conexao().getConnection()) {
			AlunoDAO alunoDAO = new AlunoDAO(conexao);
			this.alunos = alunoDAO.listar();
		}catch(SQLException ex) {
			return ex.getMessage();
		}
		
		return "home";
	}
	
	public String editar() {
		try(Connection conexao = new Conexao().getConnection()) {
			AlunoDAO alunoDAO = new AlunoDAO(conexao);
			this.aluno = alunoDAO.buscarPorId(id);
		}catch(SQLException ex) {
			return ex.getMessage();
		}
		
		return "editar";
	}
	
	public String salvarEdicao() {
		try(Connection conexao = new Conexao().getConnection()) {
			AlunoDAO alunoDAO = new AlunoDAO(conexao);
			alunoDAO.editar(this.aluno);
			return "redirect";
		}catch(SQLException ex) {
			return ex.getMessage();
		}
	}
	
	public String registrar(){
		return "registrar";
	}
	
	public String salvarRegistro(){
		try(Connection conexao = new Conexao().getConnection()) {
			AlunoDAO alunoDAO = new AlunoDAO(conexao);
			alunoDAO.registrar(aluno);
			return "redirect";
		}catch(SQLException ex) {
			return ex.getMessage();
		}
	}
	
	public String excluir() {
		try(Connection conexao = new Conexao().getConnection()) {
			AlunoDAO alunoDAO = new AlunoDAO(conexao);
			alunoDAO.excluir(id);
			return "redirect";
		}catch(SQLException ex) {
			return ex.getMessage();
		}
	}
	

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
