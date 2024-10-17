package dominio;

public class Seguro {
	public int IdSeguro;
	public String Descripcion;
	public int IdTipo;
	public float CostoContratacion;
	public float CostoMAsegurado;
	
	public Seguro() {}
	
	public Seguro(int IdSeguro, String descripcion, int idTipo, float costoContratacion, float costoMAsegurado) {
		this.IdSeguro = IdSeguro;
		Descripcion = descripcion;
		IdTipo = idTipo;
		CostoContratacion = costoContratacion;
		CostoMAsegurado = costoMAsegurado;
	}
	
	
	public int getIdSeguro() {
		return IdSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		IdSeguro = idSeguro;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getIdTipo() {
		return IdTipo;
	}
	public void setIdTipo(int idTipo) {
		IdTipo = idTipo;
	}
	public float getCostoContratacion() {
		return CostoContratacion;
	}
	public void setCostoContratacion(float costoContratacion) {
		CostoContratacion = costoContratacion;
	}
	public float getCostoMAsegurado() {
		return CostoMAsegurado;
	}
	public void setCostoMAsegurado(float costoMAsegurado) {
		CostoMAsegurado = costoMAsegurado;
	}
}
