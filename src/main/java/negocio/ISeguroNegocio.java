package negocio;

import java.util.ArrayList;

import dominio.Seguro;

public interface ISeguroNegocio {
	public boolean insert(Seguro seguro);
	public boolean delete(Seguro seguro);
	public ArrayList<Seguro> readAll();
}
