package miproyecto.restaurante;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaService {

    @EJB
    private CategoriaDAO categoriaDAO;

    @POST
    public Response crearCategoria(Categoria categoria) {
        categoriaDAO.insertarCategoria(categoria.getNombre());
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public List<Categoria> obtenerCategorias() {
        return categoriaDAO.obtenerCategorias();
    }

    @PUT
    @Path("/{id}")
    public Response actualizarCategoria(@PathParam("id") int id, Categoria categoria) {
        categoriaDAO.actualizarCategoria(id, categoria.getNombre());
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminarCategoria(@PathParam("id") int id) {
        categoriaDAO.eliminarCategoria(id);
        return Response.ok().build();
    }
}
