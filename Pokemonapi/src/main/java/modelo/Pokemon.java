package modelo;

import org.json.JSONArray;
import org.json.JSONObject;

public class Pokemon {
    private String nombre;
    private String poderes;
    private String imagen;
    private int peso;
    private int altura;

    public Pokemon(JSONObject json) {
        this.nombre = json.getString("name");
        this.peso   = json.getInt("weight");
        this.altura = json.getInt("height");
        this.imagen = json.getJSONObject("sprites")
                         .getJSONObject("other")
                         .getJSONObject("official-artwork")
                         .getString("front_default");

        JSONArray abilities = json.getJSONArray("abilities");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < abilities.length(); i++) {
            String habilidad = abilities.getJSONObject(i)
                                        .getJSONObject("ability")
                                        .getString("name");
            sb.append(habilidad).append("\n");
        }
        this.poderes = sb.toString();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPoderes() { return poderes; }
    public void setPoderes(String poderes) { this.poderes = poderes; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    public int getPeso() { return peso; }
    public void setPeso(int peso) { this.peso = peso; }

    public int getAltura() { return altura; }
    public void setAltura(int altura) { this.altura = altura; }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre: " + nombre + ", " +
                "altura: " + altura + ", " +
                "peso: "   + peso   + ", " +
                "poderes: "+ poderes+ ", " +
                "imagen: " + imagen +
               "}";
    }
}