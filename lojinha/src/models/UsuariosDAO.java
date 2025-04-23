package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBConnection;

public class UsuariosDAO {

	private Statement dbLink = null;

	public UsuariosDAO() {
		try {
			this.dbLink = new DBConnection().getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int insert(Usuarios user) {
		try {
			int linesAfected = 0;
			if (user.getIdUsuario() > 0) {
				String cmd =  "INSERT INTO lojinha.usuarios ( "
						+ "idUsuario, "
						+ "email, "
						+ "senha, "
						+ "idNivelUsuario, "
						+ "nome, "
						+ "cpf, "
						+ "endereco, "
						+ "bairro, "
						+ "cidade, "
						+ "uf, "
						+ "cep, "
						+ "telefone, "
						+ "foto, "
						+ "ativo"
				+ 	") values ('";
					cmd +=  user.getIdUsuario() +"', '" + 
						   user.getEmail()+"', '" +
						   user.getSenha()+"', '" +
						   user.getIdNivelUsuario()+"', '" + 
						   user.getNome()+"', '" +
						   user.getCpf()+"', '" +
						   user.getEndereco()+"', '" +
						   user.getBairro()+"', '" +
						   user.getCidade()+"', '" +
						   user.getUf()+"', '" +
						   user.getCep()+"', '" +
						   user.getTelefone()+"', '" +
						   user.getFoto()+"', '" +
						   user.getAtivo()+
					")'" ;
							  

				linesAfected = dbLink.executeUpdate(cmd);
				return linesAfected;
			}else{
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}		
	}

	public int update(Usuarios user) {
		return 0;
	}

	public int delete(Usuarios user) {
		try {
			int linesAfected = 0;
			if (user.getIdUsuario() > 0) {
				String cmd =  " DELETE FROM lojinha.usuarios ";
				       cmd += " WHERE idUsuario = " + user.getIdUsuario();
				linesAfected = dbLink.executeUpdate(cmd);
				return linesAfected;
			}else{
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}		
	}

	public ResultSet list(String where) {
		String cmd = "SELECT  idUsuario, email, senha, idNivelUsuario, nome, cpf, endereco, bairro, cidade, uf, cep, telefone, foto, ativo FROM lojinha.usuarios";
		if (!where.isEmpty()) {
			cmd += " WHERE " + where;
		}
		ResultSet rs = null;
		try {
			rs = dbLink.executeQuery(cmd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
