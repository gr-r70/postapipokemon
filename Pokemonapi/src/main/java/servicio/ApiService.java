package servicio;

import  modelo.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class ApiService {
    //crear http: constante
    private static final  HttpClient httpclient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    //la url no cambia
    private static final String API_URL = "https://pokeapi.co/api/v2/pokemon/";
    
    public Pokemon getPokemon(String nombre) throws IOException, InterruptedException{
    // contruir la peticion
    HttpRequest request = HttpRequest.newBuilder()
                          .GET()
                          .uri(URI.create(API_URL +nombre.toLowerCase()))
                          .header("Accept","Application/json")
                          .build();
    
    //enviar la peticion
    HttpResponse <String> response = httpclient.send(request,HttpResponse.BodyHandlers.ofString());
    // verificar el estado
    
    if(response.statusCode() != 200){
        throw new IOException("Error: " + response.statusCode());
    }
    String jsonString = response.body();
    
    JSONObject jsonObject = new JSONObject(jsonString);
    //usamos  ese  nuev contructor  para crear el post
    Pokemon pokemon=new Pokemon (jsonObject);
    
    return pokemon;
    }
}