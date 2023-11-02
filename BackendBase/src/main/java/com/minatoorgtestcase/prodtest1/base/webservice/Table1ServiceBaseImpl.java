package com.minatoorgtestcase.prodtest1.base.webservice;

import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import com.eva.base.dal.providers.PersistenceType;
import com.eva.jersey.base.webservice.BaseWebService;
import com.minatoorgtestcase.prodtest1.base.logic.ITable1BLBase;
import com.minatoorgtestcase.prodtest1.base.model.Table1Base;
import java.util.Date;

import com.eva.base.util.CollectionUtils;
import com.eva.storage.files.AttachmentBL;
import javax.ws.rs.POST;

import javax.ws.rs.DELETE;

import javax.ws.rs.PUT;

import javax.ws.rs.PathParam;

import com.eva.base.model.Primary;

import javax.ws.rs.GET;

import javax.ws.rs.QueryParam;

import java.util.List;

import com.eva.base.model.PaginationRequest;

import com.eva.base.model.PaginationResponse;

import java.util.Map;
@Produces(MediaType.APPLICATION_JSON)
public abstract class Table1ServiceBaseImpl<BL extends ITable1BLBase<M>, M extends Table1Base>
		extends BaseWebService<BL, M> {
	public Table1ServiceBaseImpl(BL logic) {
		super(logic);
	}
	@POST
	public M create(M modelObj) {
		return super.save(modelObj);
	}


	@DELETE
	@Path("/{ids}")
	public Response deleteRecords(@PathParam("ids") String ids) {
		boolean isDeleted = super.delete(ids);
		if (isDeleted)
			return Response.ok().build();
		else
			return Response.serverError().build();
	}


	@PUT
	public M update(M modelObj) {
		return super.update(modelObj);
	}



	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{sid}")
	public M getById(@PathParam("sid") Primary sid) {
		return super.getById(sid);
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/autosuggest")
	public List<Object> autoSuggestService(@QueryParam("query") String searchText,@QueryParam("sortColumn") String sortColumn,@QueryParam("sortOrder") String sortOrder,@QueryParam("pgNo") int pgNo,@QueryParam("pgLen") int length) {
		return super.autosuggest(searchText,sortColumn,sortOrder,pgNo,length);
	}


	@POST
	@Path("/datatable")
	public PaginationResponse getDatatableData(PaginationRequest dataTable)
	{
	 	return logic.getAllByPage(PersistenceType.SEARCH, dataTable);
	}
	




}
