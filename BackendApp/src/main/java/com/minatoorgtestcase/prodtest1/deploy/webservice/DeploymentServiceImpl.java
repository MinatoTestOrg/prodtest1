package com.minatoorgtestcase.prodtest1.deploy.webservice;

import javax.ws.rs.Path;

import com.minatoorgtestcase.prodtest1.deploy.logic.DeploymentBLImpl;
import com.minatoorgtestcase.prodtest1.base.deploy.webservice.DeploymentServiceBaseImpl;

@Path("deploy")
public class DeploymentServiceImpl extends DeploymentServiceBaseImpl<DeploymentBLImpl> {

	public DeploymentServiceImpl() {
		super(new DeploymentBLImpl());
	}
	
}
