package com.minatoorgtestcase.prodtest1.webservice;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.eva.base.model.PaginationRequest;
import com.eva.base.model.PaginationResponse;
import com.eva.base.model.Primary;
import com.eva.base.workflow.history.IWorkflowHistoryBL;
import com.eva.base.workflow.history.WorkflowHistory;
import com.eva.jersey.base.webservice.BaseWebService;
import com.minatoorgtestcase.prodtest1.logic.WorkflowHistoryBLImpl;

@Path("workflowhistory")
@Produces(MediaType.APPLICATION_JSON)
public class WorkflowHistoryServiceImpl extends BaseWebService<IWorkflowHistoryBL, WorkflowHistory> {

	public WorkflowHistoryServiceImpl() {
		super(new WorkflowHistoryBLImpl());
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{workflowType}/{modelid}/datatable")
	public PaginationResponse getWorkflowHistory(@PathParam("workflowType") String workflowType,
			@PathParam("modelid") Primary modelId, PaginationRequest dataTable) {
		return logic.getWorkflowHistory(workflowType, modelId.get(), dataTable);
	}
}
