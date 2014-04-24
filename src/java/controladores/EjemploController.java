/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author DHERNANDEZA
 */
@ManagedBean
@SessionScoped
public class EjemploController {
    @EJB
    CustomerDAO customerDAO;
    
    @EJB
    PurchaseOrderDAO purchaseOrderDAO;
    
    String cadenaBusqueda;
    List<Customer> listaClientes;
    Customer clienteActual;
    List<PurchaseOrder> listaPedidosClienteActual;
    PurchaseOrder pedidoActual;
    
    @PostConstruct
    public void inicializar(){
    listaClientes = customerDAO.buscarTodos();
    clienteActual = listaClientes.get(0);
    listaPedidosClienteActual = purchaseOrderDAO.buscarPorCliente(clienteActual.getCustomerId());
    pedidoActual = null;
}
    
    // Metodos de accion
public String doVerPedidos(Customer cliente) {
clienteActual = cliente;
listaPedidosClienteActual = purchaseOrderDAO.buscarPorCliente(cliente.getCustomerId());
return "detalleCliente";
}

public String doBuscarCliente(){
listaClientes = customerDAO.buscarPorNombre(cadenaBusqueda);
clienteActual = listaClientes.get(0);
return "index";
}

public String doNuevoCliente(){
clienteActual = new Customer();
listaPedidosClienteActual = null;
return "nuevoCliente";
}

public String doGuardarCliente(){
customerDAO.crear(clienteActual);
return "index";
}
    
    public EjemploController() {
    }
    
}
