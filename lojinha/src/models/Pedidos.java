package models;

public class Pedidos {
	private int idPedido;
	private int idUsuario;
	private String dataPedido;
	private double total;
	private String status;

	public Pedidos() {}

	public Pedidos(int idPedido, int idUsuario, String dataPedido, double total, String status) {
		this.idPedido = idPedido;
		this.idUsuario = idUsuario;
		this.dataPedido = dataPedido;
		this.total = total;
		this.status = status;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
