package org.learning.database.service;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.learning.database.entity.TemperatureData;
import org.learning.database.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Path("/temperature")
public class TemperatureRS {
  @Autowired
  private TemperatureRepository repo ;
    @POST
    @Path("/submit")
    @Consumes(MediaType.APPLICATION_JSON) //obligatoire taadi param
    @Produces(MediaType.APPLICATION_JSON)
    public TemperatureData submitTemperatureData(TemperatureData d) {
        d=repo.save(d);
        return d ;
    }
    //2 anwe3 mta param (path param , query param )
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TemperatureData> getStoredTemperatureData() {
       return repo.findAll() ;
    }

  @PUT
  @Path("/update/{sensorID}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateTemperatureData(@PathParam("sensorID") String sensorId, TemperatureData updatedData) {
    return repo.findById(sensorId).map(existingData -> {
      existingData.setTemperature(updatedData.getTemperature());
      // Update other fields if needed
      repo.save(existingData);
      return Response.ok(existingData).build();
    }).orElse(Response.status(Response.Status.NOT_FOUND).build());
  }
  @DELETE
  @Path("/delete/{sensorId}")
  @Produces(MediaType.APPLICATION_JSON)
  public void deleteTemperatureData(@PathParam("sensorId") String sensorId) {
    repo.deleteById(sensorId);
  }


}
