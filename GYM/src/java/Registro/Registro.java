package Registro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Registro.ClienteBean;
import Registro.Cliente;

/**
 *
 * @author Roberto
 */
//@WebServlet(urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String nombre=request.getParameter("nombreCliente");
  String tipo=request.getParameter("tipoCliente");
  String curp=request.getParameter("curp");
  //String edad=request.getParameter("edad");
  String correo=request.getParameter("correo");
   ClienteBean cliente=new ClienteBean(nombre, tipo, curp, correo);
   boolean sw;
        sw = Cliente.altaCliente(cliente);
   
  }
}
   