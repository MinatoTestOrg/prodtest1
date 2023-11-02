package com.minatoorgtestcase.prodtest1.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.eva.base.workflow.config.WorkflowConfigurationInfo;
import com.eva.base.workflow.config.WorkflowConfigurationInfoBL;
import com.eva.base.workflow.config.util.WorkflowConfiguration;
import com.eva.jersey.base.webservice.BaseWebService;

@Path("workflowconfig")
@Produces(MediaType.APPLICATION_JSON)
public class WorkflowConfigurationServiceImpl
		extends BaseWebService<WorkflowConfigurationInfoBL, WorkflowConfigurationInfo> {

	public WorkflowConfigurationServiceImpl() {
		super(new WorkflowConfigurationInfoBL());
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getconfig/{workflowType}")
	public WorkflowConfiguration getWorkflowConfiguration(@PathParam("workflowType") String workflowType) {
		return logic.getWorkflowConfiguration(workflowType);
	}
}

