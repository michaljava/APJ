package atj;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
@Produces(MediaType.APPLICATION_JSON)
@Path("/exchangerates/rates/c/")
public class Rest {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{currency}/last/{days}")
	public String methodJSON(@PathParam("currency") String currency, @PathParam("days") int days) {
		WalutaClient walutaClient=new WalutaClient();
		double avg=walutaClient.askNBP(currency, days);
		return "{\"avg\": "  + avg +  "}";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{currency}/last/{days}")
	public String methodXML(@PathParam("currency") String currency, @PathParam("days") int days) {
		WalutaClient walutaClient=new WalutaClient();
		double avg=walutaClient.askNBP(currency, days);
		return "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
		"<ExchangeRatesSeries xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"+
		"<avg>"+ avg +"</avg></ExchangeRatesSeries>";
		
	}
}
