package com.minatoorgtestcase.prodtest1.base.webservice;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;

import com.eva.base.dal.providers.PersistenceType;
import com.eva.base.model.PaginationRequest;
import com.eva.base.model.PaginationResponse;
import com.eva.base.model.Primary;
import com.eva.jersey.base.webservice.BaseWebService;

import com.minatoorgtestcase.prodtest1.base.model.ApplicationUserBase;
import com.minatoorgtestcase.prodtest1.base.logic.IApplicationUserBLBase;
import com.eva.storage.files.AttachmentBL;
import com.eva.base.util.CollectionUtils;


@Produces(MediaType.APPLICATION_JSON)
public class ApplicationUserServiceBaseImpl<BL extends IApplicationUserBLBase<M>, M extends ApplicationUserBase>
		extends BaseWebService<BL, M> {
	
	public ApplicationUserServiceBaseImpl(BL logic) {
		super(logic);
	}
	
	@GET
	@Path("authenticate")
	public M getCurrentUser() {
		return logic.getCurrentUserWithMenu();
	}

	@POST
	public M createAppUser(M modelObj) {
		M existingObj = super.getById(new Primary(modelObj.getEmail()));
		if (existingObj == null) {
			return super.save(modelObj);
		} else {
			return super.update(modelObj);
		}
	}

	@PUT
	public M updateAppUser(M modelObj) {
		return super.update(modelObj);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{sid}")
	public M getApplicationUserBySid(@PathParam("sid") Primary sid) {
		return super.getById(sid);
	}

	@POST
	@Path("/datatable")
	public PaginationResponse getAllAppUsers(PaginationRequest dataTable) {
		return logic.getAllByPage(PersistenceType.SEARCH, dataTable);
	}

	@DELETE
	@Path("/{ids}")
	public Response deleteApplicationUsers(@PathParam("ids") String ids) {
		boolean isDeleted = super.delete(ids);
		if (isDeleted)
			return Response.ok().build();
		else
			return Response.serverError().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/autosuggest")
	public List<Object> autoSuggestService(@QueryParam("query") String searchText,@QueryParam("sortColumn") String sortColumn,@QueryParam("sortOrder") String sortOrder,@QueryParam("pgNo") int pgNo,@QueryParam("pgLen") int length) {
		return super.autosuggest(searchText,sortColumn,sortOrder,pgNo,length);
	}
	
	
	

	@DELETE
	@Path("/{id}/delete/{ids}")
	public Response deleteRecords(@PathParam("id") Primary siteId, @PathParam("ids") String ids) {
		AttachmentBL attachmentBL = new AttachmentBL();
		boolean isDeleted = attachmentBL.delete(ids);
		if (isDeleted) {
			Object cu = getById(siteId);
			if (ids != null) {
				attachmentBL.deleteAttachment(cu, ApplicationUserBase.class, ids);
				update((M)cu);
			}
			return Response.ok().build();
		} else
			return Response.serverError().build();
	}



}