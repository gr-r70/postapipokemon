package modelo;

import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    // atributos privados
    private String nombre;
    private int peso;
    private List<String> habilidades;
    private String imagenUrl;

    // constructor recibe los dos JSONObject de cada endpoint de habilidad
    // igual que Post recibe su JSONObject del endpoint de posts
    public Pokemon(JSONObject jsonAbility1, JSONObject jsonAbility2) {

        // nombre del pokemon
        this.nombre = "ditto";

        // peso de ditto en hectogramos
        this.peso = 40;

        // extraer el nombre de cada habilidad desde su propio endpoint
        // https://pokeapi.co/api/v2/ability/7/   -> limber
        // https://pokeapi.co/api/v2/ability/150/ -> imposter
        this.habilidades = new ArrayList<>();
        this.habilidades.add(jsonAbility1.getString("name"));
        this.habilidades.add(jsonAbility2.getString("name"));

        // imagen oficial usando el enlace solicitado
        this.imagenUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/132.png";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    @Override
    public String toString() {
        return "Pokemon{"
                + "nombre=" + nombre
                + ", peso=" + peso + " hg"
                + ", habilidades=" + habilidades
                + ", imagenUrl=" + imagenUrl
                + "}";
    }
}