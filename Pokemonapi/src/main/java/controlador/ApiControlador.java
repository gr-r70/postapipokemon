package controlador;

import modelo.*;
import servicio.*;
import vista.*;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class ApiControlador {
    private ApiVista vista;
    private ApiService servicio;

    public ApiControlador(ApiVista vista) {
        this.vista = vista;
        this.servicio = new ApiService();
        presentar();
    }

    public void presentar() {
        vista.getjEnter().addActionListener(e -> {
            String nombre = vista.getjTextPokemon().getText().trim();
            try {
                Pokemon pokemon = servicio.getPokemon(nombre);
                vista.getjName().setText(pokemon.getNombre());
                vista.getjWeight().setText(String.valueOf(pokemon.getPeso()));
                vista.getjHeight().setText(String.valueOf(pokemon.getAltura()));
                vista.getjAbilities().setText(pokemon.getPoderes());

                ImageIcon icono = new ImageIcon(new URL(pokemon.getImagen()));
                Image img = icono.getImage().getScaledInstance(320, 333, Image.SCALE_SMOOTH);
                vista.getjlImagen().setIcon(new ImageIcon(img));

                vista.getjEncontrar().setText("Pokemon encontrado");

            } catch (Exception ex) {
                vista.getjEncontrar().setText("Pokemon no encontrado");
            }
        });
    }
}