package com.minatoorgtestcase.prodtest1.base.deploy.webservice;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import com.minatoorgtestcase.prodtest1.base.deploy.logic.DeploymentBLBaseImpl;

public class DeploymentServiceBaseImpl<T extends DeploymentBLBaseImpl> {

	private T bl;
	public DeploymentServiceBaseImpl(T bl) {
		this.bl = bl;
	}
	
	@POST
	@Path("/setup")
	public Response setup() {
		bl.setup("1.0");
		return Response.ok().build();
	}

}