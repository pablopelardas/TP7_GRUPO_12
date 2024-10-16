package dao;

import java.util.ArrayList;

import dominio.Seguro;

public interface ISeguroDao {
	public boolean insert(Seguro seguro);
	public boolean delete(Seguro seguro);
	public ArrayList<Seguro> readAll();
}
