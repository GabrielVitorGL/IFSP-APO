package models;

public class NivelUsuarios {
	private int idNivelUsuario;
	private String nivel;

	public NivelUsuarios() {
	}

	public NivelUsuarios(int idNivelUsuario, String nivel) {
		this.idNivelUsuario = idNivelUsuario;
		this.nivel = nivel;
	}

	public int getIdNivelUsuario() {
		return idNivelUsuario;
	}

	public void setIdNivelUsuario(int idNivelUsuario) {
		this.idNivelUsuario = idNivelUsuario;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
}
