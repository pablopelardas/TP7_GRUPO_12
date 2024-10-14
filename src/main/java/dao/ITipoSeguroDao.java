package dao;

import java.util.ArrayList;

import dominio.TipoSeguro;

public interface ITipoSeguroDao {

	public TipoSeguro getTipoSeguroPorId(int id);
	
	public ArrayList<TipoSeguro> getTipoSeguro();
	
}
