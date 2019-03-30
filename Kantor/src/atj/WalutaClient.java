package atj;

import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.jasper.tagplugins.jstl.ForEach;

import com.google.gson.Gson;

public class WalutaClient {

	public double askNBP(String currency, int days) {

		Client client = ClientBuilder.newClient();

		// skonstruowanie adresu URI
		URI uri = URI.create("http://api.nbp.pl/api/exchangerates/rates/c/" + currency + "/last/" + days + "/");

		// okreslenie zasobu
		WebTarget webTarget = client.target(uri);

		// wysylanie zadania i odbieranie odpowiedzi

		String jsonAnswer = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(jsonAnswer);
		
		Gson gson=new Gson();
		ExchangeRates exchangeRate =gson.fromJson(jsonAnswer, ExchangeRates.class);
		double total=0;
		int counter=0;
		for (Rate rate:exchangeRate.getRates()) {
			total+=rate.getBid();
			counter++;
			}
		double average=total/counter;
		return average;
	}

}
