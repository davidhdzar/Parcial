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
public class CustomerDAO {

    @PersistenceContext
    EntityManager em;
    
    public void crear(Customer cliente) {
    em.persist(cliente);
}
    public void actualizar(Customer cliente) {
    em.merge(cliente);
}
  public void borrar(Customer cliente) {
  em.remove(cliente);
}  
  public Customer buscarPorID(Long id) {
return (em.find(Customer.class, id));
}
  public List<Customer> buscarTodos() {
  Query q = em.createQuery("SELECT c FROM Customer c");
    return q.getResultList();
}
  public List<Customer> buscarPorNombre(String nombre) {
    Query q = em.createQuery("SELECT c FROM Customer c WHERE c.name LIKE :patron");
    q.setParameter("patron", "%" + nombre + "%");
    return q.getResultList();
}
  public List<DiscountCode> listaCodigosDescuento(){
    Query q = em.createQuery("SELECT cd FROM DiscountCode cd");
    return q.getResultList();
}
}
