package dominio;

import dao.ITipoSeguroDao;
import daoImpl.TipoSeguroDaoImpl;

public class Seguro {
	public int IdSeguro;
	
	public String Descripcion;
	private TipoSeguro tipoSeguro;
	public float CostoContratacion;
	public float CostoMAsegurado;
	
	public Seguro() {}
	
	public Seguro(int IdSeguro, String descripcion, int idTipo, float costoContratacion, float costoMAsegurado) {
		this.IdSeguro = IdSeguro;
		this.tipoSeguro = getTipoSeguro(idTipo);
		Descripcion = descripcion;
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

	public TipoSeguro getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(TipoSeguro tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
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
	
	private TipoSeguro getTipoSeguro(int id) {
		ITipoSeguroDao tsDao = new TipoSeguroDaoImpl();
		TipoSeguro ts = tsDao.getTipoSeguroPorId(id);
		return ts;
	}
}
