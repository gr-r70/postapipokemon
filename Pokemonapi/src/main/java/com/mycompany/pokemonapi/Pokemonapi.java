/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemonapi;


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
