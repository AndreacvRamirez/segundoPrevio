package co.edu.ufps.SegundoPrevio.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class QueryGeneric<T> {
	private PreparedStatement ps;
	private ResultSet rs;
	private String query;

	private List<T> list;
	private T entity;

	public QueryGeneric() {
		ConnectionGeneric.getConnection();
	}

	public PreparedStatement getPs() {
		return ps;
	}

	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}
}
