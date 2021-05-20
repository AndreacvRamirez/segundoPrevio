package co.edu.ufps.SegundoPrevio.dao;

import java.io.Serializable;
import java.sql.SQLException;

import co.edu.ufps.SegundoPrevio.beans.Country;
import co.edu.ufps.SegundoPrevio.utils.ConnectionGeneric;
import co.edu.ufps.SegundoPrevio.utils.QueryGeneric;

public class CountryDao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private QueryGeneric<Country> query;
	
	public CountryDao() {
	}
	
	

	public QueryGeneric<Country> getQuery() {
		return query;
	}

	public void setQuery(QueryGeneric<Country> query) {
		this.query = query;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
	
}
