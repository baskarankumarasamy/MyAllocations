package com.allocations.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.allocations.dto.MyAllocationsDTO;

@Repository
public class MyAllocationsDAO {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(@Qualifier("mysqlDataSource") DataSource datasource)
	{
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
	}
	
	
	public MyAllocationsDTO getMyAllocationsDetails(int empId)
	{
		MyAllocationsDTO myAllocationsDTO = new MyAllocationsDTO();

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("customerIdList", empId);

		try
		{
			return namedParameterJdbcTemplate.query("", parameterSource,
				new ResultSetExtractor<MyAllocationsDTO>()
				{
					@Override
					public MyAllocationsDTO extractData(ResultSet rs) throws SQLException, DataAccessException
					{
						while (rs.next())
						{
							myAllocationsDTO.setEmpId(rs.getString(""));
							myAllocationsDTO.setEmpId(rs.getString(""));
							myAllocationsDTO.setEmpId(rs.getString(""));
							myAllocationsDTO.setEmpId(rs.getString(""));
							myAllocationsDTO.setEmpId(rs.getString(""));
							myAllocationsDTO.setEmpId(rs.getString(""));
							myAllocationsDTO.setEmpId(rs.getString(""));
							myAllocationsDTO.setEmpId(rs.getString(""));
							myAllocationsDTO.setEmpId(rs.getString(""));
							myAllocationsDTO.setEmpId(rs.getString(""));
							myAllocationsDTO.setEmpId(rs.getString(""));
						}
						return myAllocationsDTO;
					}
				});
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return myAllocationsDTO;
	}
	
}
