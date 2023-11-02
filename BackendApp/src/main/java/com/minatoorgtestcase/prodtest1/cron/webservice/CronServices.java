package com.minatoorgtestcase.prodtest1.cron.webservice;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.minatoorgtestcase.prodtest1.base.webservice.CronServicesBase;

@Produces(MediaType.APPLICATION_JSON)
@Path("cronservices")
public class CronServices extends CronServicesBase{	
}

