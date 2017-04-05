package com.allocations.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.allocations.dao.MyAllocationsDAO;
import com.allocations.dto.MyAllocationsDTO;

@RestController
@RequestMapping(value = "allocations")
public class MyAllocationsController {

	@Autowired
	private MyAllocationsDAO myAllocationsDAO;
	
	@RequestMapping(method = RequestMethod.GET, value = "getAllocationsDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public MyAllocationsDTO getMyAllocationsDetails(@RequestHeader("empId") int empId, 
		HttpServletResponse httpServletResponse) throws Exception
	{
		MyAllocationsDTO myAllocationsDTO = myAllocationsDAO.getMyAllocationsDetails(empId);
		
		return myAllocationsDTO;
	}
}
