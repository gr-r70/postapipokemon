
package com.mycompany.pokemonapi;
/**/
import controlador.ApiControlador;
import vista.ApiVista;

public class Pokemonapi {

    public static void main(String[] args) {

        ApiVista vista =
                new ApiVista();

        ApiControlador controlador =
                new ApiControlador(vista);

        vista.setVisible(true);
        
        
    }
}
