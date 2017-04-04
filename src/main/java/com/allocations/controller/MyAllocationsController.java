package com.allocations.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.allocations.dao.MyAllocationsDAO;

@RestController
@RequestMapping(value = "allocations")
public class MyAllocationsController {

	@Autowired
	private MyAllocationsDAO myAllocationsDAO;
	
	@RequestMapping(method = RequestMethod.GET, value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Object getSpend(@RequestHeader("customerId") int customerId, @RequestParam("dateRange") String dateRange,
		@RequestParam("isSpendAtOtherStores") String isSpendAtOtherStores, @RequestParam("storeNumber") String storeNumber,
		HttpServletResponse httpServletResponse) throws Exception
	{
		
		
		return null;
	}
}
