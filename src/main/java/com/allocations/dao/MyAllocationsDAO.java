package com.allocations.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.allocations.dto.MyAllocationsDTO;
import com.allocations.util.MyAllocationConstants;

@Repository
public class MyAllocationsDAO {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(@Qualifier("mysqlDataSource") DataSource datasource)
	{
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
	}
	
	
	public List<MyAllocationsDTO> getMyAllocationsDetails(int empId)
	{
		MyAllocationsDTO myAllocationsDTO = new MyAllocationsDTO();

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("empId", empId);
		List<MyAllocationsDTO> allocationsList = new ArrayList<MyAllocationsDTO>();
		try
		{
			return namedParameterJdbcTemplate.query(MyAllocationConstants.ALLOCATION_QUERY, parameterSource,
				new ResultSetExtractor<List<MyAllocationsDTO>>()
				{
					@Override
					public List<MyAllocationsDTO> extractData(ResultSet rs) throws SQLException, DataAccessException
					{
						while (rs.next())
						{
							myAllocationsDTO.setEmpId(rs.getString("EMP_ID"));
							myAllocationsDTO.setEmpName(rs.getString("EMP_NAME"));
							myAllocationsDTO.setPortfolio(rs.getString("PORTFOLIO"));
							myAllocationsDTO.setProject(rs.getString("PROJECT"));
							myAllocationsDTO.setTypeLdsr(rs.getString("TYPE_LD_SR"));
							myAllocationsDTO.setRatePerHr(rs.getString("RATE_PER_HR"));
							myAllocationsDTO.setBillingHrs(rs.getString("BILLING_HRS"));
							myAllocationsDTO.setBilling(rs.getString("BILLING"));
							myAllocationsDTO.setLeaveHrs(rs.getString("LEAVE_HRS"));
							myAllocationsDTO.setLeakageHrs(rs.getString("LEAKAGE_HRS"));
							myAllocationsDTO.setComments(rs.getString("COMMENTS"));
							allocationsList.add(myAllocationsDTO);
						}
						return allocationsList;
					}
				});
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return allocationsList;
	}
	
}
