package models;

import java.sql.ResultSet;

import database.DBQuery;

public class Usuarios {
	private int 	idUsuario;
	private String 	email;
	private String 	senha;
	private int 	idNivelUsuario;
	private String 	nome;
	private String 	cpf;
	private String 	endereco;
	private String 	bairro;
	private String 	cidade;
	private String 	uf;
	private String 	cep;
	private String 	telefone;
	private String 	foto;
	private String 	ativo;
	
	
	private String  tableName 	= "usuarios";
	private String  fieldsName 	= "idUsuario, email, senha, idNivelUsuario, nome, cpf, endereco, bairro, cidade, uf, cep, telefone, foto, ativo";
	private String  fieldKey  	= "idUsuario";
	private DBQuery dbQuery = new DBQuery(tableName, fieldsName, fieldKey);
	
	public Usuarios() {
	
	}
	
	public Usuarios(String email, String senha, String nome, String cpf) {
		this.setEmail(email);
		this.setSenha(senha);
		this.setNome(nome);
		this.setCpf(cpf);
	}
	
	public Usuarios(int idUsuario, String email, String senha, int idNivelUsuario, String nome, String cpf, String endereco, String bairro, String cidade, String uf, String cep, String telefone, String foto, String ativo) {
		this.setIdUsuario(idUsuario);
		this.setEmail(email);
		this.setSenha(senha);
		this.setIdNivelUsuario(idNivelUsuario);
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEndereco(endereco);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setUf(uf);
		this.setCep(cep);
		this.setTelefone(telefone);
		this.setFoto(foto);
		this.setAtivo(ativo);
	}
	
	public String toString() {
		return(
			this.getIdUsuario() + ", " + 
			this.getEmail() + ", " +
			this.getSenha() + ", " +
			this.getIdNivelUsuario() + ", " +
			this.getNome() + ", " +
			this.getCpf() + ", " +
			this.getEndereco() + ", " +
			this.getBairro() + ", " +
			this.getCidade() + ", " +
			this.getUf() + ", " +
			this.getCep() + ", " +
			this.getTelefone() + ", " +
			this.getFoto() + ", " +
			this.getAtivo()
		);
	}
	
	public int save() {
		if (this.getIdUsuario() > 0) {
			return (dbQuery.update(this.toArray()));
		}else {
			return (dbQuery.insert(this.toArray()));
		}
	}
	
	
	public int delete() {
		if (this.getIdUsuario() > 0) {
			return (dbQuery.delete(this.toArray()));
		}
		return (0);
	}
	
	public ResultSet listByEmail(String email) {
		return (dbQuery.select("email = '" + email + "'"));
	}
	
	public ResultSet listAll() {
		return (dbQuery.select(""));
	}
	
	
	public String[] toArray() {
		String[] arrayStr = {
			this.getIdUsuario() + "", 
			this.getEmail(), 
			this.getSenha(), 
			this.getIdNivelUsuario() + "", 
			this.getNome(), 
			this.getCpf(), 
			this.getEndereco(), 
			this.getBairro(), 
			this.getCidade(), 
			this.getUf(), 
			this.getCep(), 
			this.getTelefone(), 
			this.getFoto(), 
			this.getAtivo()
		};
		return arrayStr;	
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if (email.contains("@")) {
			this.email = email;
		}else {
			email = "";
		}
		
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getIdNivelUsuario() {
		return idNivelUsuario;
	}
	public void setIdNivelUsuario(int idNivelUsuario) {
		this.idNivelUsuario = idNivelUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	
	

}
