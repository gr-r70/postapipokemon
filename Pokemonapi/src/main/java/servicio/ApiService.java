package servicio;

import modelo.Pokemon;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static one.xingyi.core.http.JavaHttpClient.httpClient;
import org.json.JSONObject;

public class ApiService {

    // el cliente http no cambia, es una constante
    private static final HttpClient httpclient = HttpClient.newBuilder()
                                                           .version(HttpClient.Version.HTTP_2)
                                                           .build();

    // URLs fijas de las habilidades de ditto tal como fueron solicitadas
    private static final String URL_ABILITY_LIMBER   = "https://pokeapi.co/api/v2/ability/7/";
    private static final String URL_ABILITY_IMPOSTER = "https://pokeapi.co/api/v2/ability/150/";

    public Pokemon getPokemon() throws IOException, InterruptedException {

        // ------ peticion habilidad 1: limber ------
        HttpRequest requestAbility1 = HttpRequest.newBuilder()
                                      .GET()
                                      .uri(URI.create(URL_ABILITY_LIMBER))
                                      .header("Accept", "Application/json")
                                      .build();

        HttpResponse<String> responseAbility1 = httpClient.send(requestAbility1, HttpResponse.BodyHandlers.ofString());

        if (responseAbility1.statusCode() != 200) {
            System.out.println("error habilidad limber: " + responseAbility1.statusCode());
            return null;
        }

        // ------ peticion habilidad 2: imposter ------
        HttpRequest requestAbility2 = HttpRequest.newBuilder()
                                      .GET()
                                      .uri(URI.create(URL_ABILITY_IMPOSTER))
                                      .header("Accept", "Application/json")
                                      .build();

        HttpResponse<String> responseAbility2 = httpClient.send(requestAbility2, HttpResponse.BodyHandlers.ofString());

        if (responseAbility2.statusCode() != 200) {
            System.out.println("error habilidad imposter: " + responseAbility2.statusCode());
            return null;
        }

        // ------ mapeo ------
        JSONObject jsonAbility1 = new JSONObject(responseAbility1.body());
        JSONObject jsonAbility2 = new JSONObject(responseAbility2.body());

        // usar el constructor para crear el Pokemon con los dos JSONObject
        Pokemon pokemon = new Pokemon(jsonAbility1, jsonAbility2);

        return pokemon;
    }
}