package com.minatoorgtestcase.prodtest1.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

import com.eva.base.factory.InstanceFactory;

import com.minatoorgtestcase.prodtest1.base.webservice.ApplicationUserServiceBaseImpl;
import com.minatoorgtestcase.prodtest1.logic.IApplicationUserBL;
import com.minatoorgtestcase.prodtest1.logic.ApplicationUserBLImpl;
import com.minatoorgtestcase.prodtest1.model.ApplicationUser;



@Produces(MediaType.APPLICATION_JSON)
@Path("applicationusers")
public class ApplicationUserServiceImpl extends ApplicationUserServiceBaseImpl<IApplicationUserBL<ApplicationUser>, ApplicationUser> {

	public ApplicationUserServiceImpl() {
		super(InstanceFactory.getProxy(new ApplicationUserBLImpl()));
	}
	
		
	
	
}
