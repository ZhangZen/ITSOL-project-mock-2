/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.rest;

import com.itsol.eas.dto.Intern05EmployeeDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author BuiBaTruong
 */
public interface Intern05EmployeeRsService {

	@GET
	@Path("/intern05Employee/getAll")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05Employee();

	@GET
	@Path("/intern05Employee/getAllCitiesName")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05CitiesName();
	
//	@GET
//	@Path("/intern05Employee/getAllCitiesNameString")
//	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	public Response getIntern05CitiesNameString();

	@GET
	@Path("/intern05Employee/getAllEthnicName")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05EthnicName();

	@GET
	@Path("/intern05Employee/searchById/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05EmployeeById(@PathParam("id") Long id);

	@GET
	@Path("/intern05Employee/searchByName/{name}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05EmployeeByName(@PathParam("name") String name);

	@GET
	@Path("/intern05Employee/searchByHometown/{hometown}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05EmployeeByHometown(@PathParam("hometown") String hometown);

	@GET
	@Path("/intern05Employee/searchByDepartment/{department}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05EmployeeByDepartment(@PathParam("department") String department);

	@GET
	@Path("/intern05Employee/searchByPosition/{position}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05EmployeeByPosition(@PathParam("position") String position);

	@GET
	@Path("/intern05Employee/searchByLiteracy/{literacy}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05EmployeeByLiteracy(@PathParam("literacy") String literacy);

	@GET
	@Path("/intern05Employee/searchBySalaryRate/{salaryRate}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05EmployeeBySalaryRate(@PathParam("salaryRate") Float salaryRate);

	@GET
	@Path("/intern05Employee/searchByBirthday/{birthday}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05EmployeeByBirthday(@PathParam("birthday") String birthday);

	@GET
	@Path("/intern05Employee/searchByStartedDate/{startedDate}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05EmployeeByStartedDate(@PathParam("startedDate") String startedDate);

	@POST
	@Path("/intern05Employee/search")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response searchIntern05Employee(Intern05EmployeeDTO employee);

	@PUT
	@Path("/intern05Employee/update")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateIntern05Employee(Intern05EmployeeDTO employee);

	@POST
	@Path("/intern05Employee/addNew")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response addIntern05Employee(Intern05EmployeeDTO employee);

	@DELETE
	@Path("/intern05Employee/delete/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteIntern05Employee(@PathParam("id") Long id);
}
