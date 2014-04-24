/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import entidades.Customer;
import entidades.DiscountCode;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.ejb.Stateless;

/**
 *
 * @author DHERNANDEZA
 */
@Stateless
@LocalBean
public class PurchaseOrderDAO {

    @PersistenceContext
    EntityManager em;
    
    public void crear(PurchaseOrder pedido) {
    em.persist(pedido);
}
    public void actualizar(PurchaseOrder pedido) {
    em.merge(pedido);
}
    public void borrar(PurchaseOrder pedido) {
    em.remove(pedido);
}
    public PurchaseOrder buscarPorID(Long id) {
    return (em.find(PurchaseOrder.class, id));
}
    public List<PurchaseOrder> buscarTodos() {
    Query q = em.createQuery("SELECT p FROM PurchaseOrder p");
    return q.getResultList();
}
    public List<PurchaseOrder> buscarPorCliente(Integer idCliente) {
    Query q = em.createQuery("SELECT p FROM PurchaseOrder p WHERE p.customer.customerId = :idCliente");
    q.setParameter("idCliente", idCliente);
    return q.getResultList();
}
    
}
