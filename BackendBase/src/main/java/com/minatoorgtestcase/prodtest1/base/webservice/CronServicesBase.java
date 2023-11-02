package com.minatoorgtestcase.prodtest1.base.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.eva.base.logger.Logger;
import com.eva.base.logger.LoggerFactory;

@Produces(MediaType.APPLICATION_JSON)
public class CronServicesBase{
	private static final Logger LOGGER = LoggerFactory.getLogger(CronServicesBase.class);
	
}