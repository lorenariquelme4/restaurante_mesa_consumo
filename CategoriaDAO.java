package miproyecto.restaurante;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CategoriaDAO {

    @PersistenceContext(unitName = "miUnidadPersistencia")
    private EntityManager em;

    public void insertarCategoria(String nombre) {
        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);
        em.persist(categoria);
    }

    public List<Categoria> obtenerCategorias() {
        return em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }

    public void actualizarCategoria(int id, String nuevoNombre) {
        Categoria categoria = em.find(Categoria.class, id);
        if (categoria != null) {
            categoria.setNombre(nuevoNombre);
            em.merge(categoria);
        }
    }

    public void eliminarCategoria(int id) {
        Categoria categoria = em.find(Categoria.class, id);
        if (categoria != null) {
            em.remove(categoria);
        }
    }
}
