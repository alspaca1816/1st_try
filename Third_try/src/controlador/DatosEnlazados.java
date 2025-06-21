/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Admin;
import modelo.Comprador;
import modelo.Usuario;
import modelo.Vendedor;

/**
 *
 * @author lorenamendez
 */
public class DatosEnlazados {
    public static ListaUsuarios listaUsuarios = new ListaUsuarios();
    public static ListaProductos listaProductos = new ListaProductos();
    public static ListaCompradores listaCompradores = new ListaCompradores();
    public static ListaVendedores listaVendedores = new ListaVendedores();
    public static ListaAdministradores listaAdministradores = new ListaAdministradores();
    
    public static Comprador compradorAct = null;
    public static Usuario user;
    public static Vendedor vendedorAct; //= null;
    public static Admin adminAct = null;
}
