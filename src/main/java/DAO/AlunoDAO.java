package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Aluno;

public class AlunoDAO {
	
	private Connection conexao;
	
	public AlunoDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public void registrar(Aluno aluno) throws SQLException {
		String sql = "insert into aluno (nome, cpf, email, idade) values (?, ?, ?, ?)";
		
		try(PreparedStatement comando = conexao.prepareStatement(sql)) {
			comando.setString(1, aluno.getNome());
			comando.setString(2, aluno.getCpf());
			comando.setString(3, aluno.getEmail());
			comando.setInt(4, aluno.getIdade());
			
			comando.execute();
		}
	}
	
	public List<Aluno> listar() throws SQLException{
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		String sql = "select id, nome, cpf, email, idade from aluno";
		
		try (PreparedStatement comando = conexao.prepareStatement(sql)){
			comando.execute();
			
			try(ResultSet dados = comando.getResultSet()) {
				while(dados.next()) {
					Aluno aluno = new Aluno();
					aluno.setId(dados.getInt("id"));
					aluno.setNome(dados.getString("nome"));
					aluno.setCpf(dados.getString("cpf"));
					aluno.setEmail(dados.getString("email"));
					aluno.setIdade(dados.getInt("idade"));
					
					alunos.add(aluno);
				}
			}
		}
		return alunos;
	}

	public Aluno buscarPorId(Integer id) throws SQLException {
		
		Aluno aluno = new Aluno();
		String sql = "select id, nome, cpf, email, idade from aluno where id= " + id;
		
		try (PreparedStatement comando = conexao.prepareStatement(sql)){
			comando.execute();
			
			try(ResultSet dados = comando.getResultSet()) {
				if(dados.next()) {
					aluno.setId(dados.getInt("id"));
					aluno.setNome(dados.getString("nome"));
					aluno.setCpf(dados.getString("cpf"));
					aluno.setEmail(dados.getString("email"));
					aluno.setIdade(dados.getInt("idade"));
				}
			}
		}
		
		return aluno;
	}

	public void editar(Aluno aluno) throws SQLException {
		String sql = "update aluno set nome = ? , cpf = ?, email = ?, idade = ? where id = ?";
		
		try (PreparedStatement comando = conexao.prepareStatement(sql)){
			comando.setString(1, aluno.getNome());
			comando.setString(2, aluno.getCpf());
			comando.setString(3, aluno.getEmail());
			comando.setInt(4, aluno.getIdade());
			comando.setInt(5, aluno.getId());
			
			comando.execute();
		}
	}

	public void excluir(Integer id) throws SQLException {
		String sql = "delete from aluno where id = " + id;
		
		try (PreparedStatement comando = conexao.prepareStatement(sql)){
			comando.execute();
		}
	}
}
