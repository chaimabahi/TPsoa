package org.msw32.tp2;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Path("/temperature")
public class TemperatureRS {
    private static List<TemperatureData> temp = new ArrayList<>();

    @POST
    @Path("/submit")
    @Consumes(MediaType.APPLICATION_JSON) //obligatoire taadi param
    @Produces(MediaType.APPLICATION_JSON)
    public TemperatureData submitTemperatureData(TemperatureData data) {
        temp.add(data);
        return data;
    }
//2 anwe3 mta param (path param , query param )
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TemperatureData> getStoredTemperatureData() {
        return temp;
    }

    @PUT
    @Path("/update/{sensorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TemperatureData updateTemperatureData(@PathParam("sensorId") String sensorId, TemperatureData newData) {
        for (TemperatureData data : temp) {
            if (data.getSensorId().equals(sensorId)){
                data.setValue(newData.getValue());
            }
        }
        return newData;
    }
    @DELETE
    @Path("/delete/{sensorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteTemperatureData(@PathParam("sensorId") String sensorId) {
        temp.removeIf(s -> s.getSensorId().equals(sensorId));
    }
}
