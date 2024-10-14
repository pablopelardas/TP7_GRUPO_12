package dao;

import java.util.ArrayList;

import dominio.TipoSeguro;

public interface TipoSeguroDao {

	public TipoSeguro getTipoSeguroPorId(int id);
	
	public ArrayList<TipoSeguro> getTipoSeguro();
	
}
