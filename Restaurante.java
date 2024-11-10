/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miproyecto.restaurante;

import java.util.List;



public class Restaurante {
    public static void main(String[] args) {
        // Probar la conexión
        ConexionPostgres.conectar();

        // Lista de categorías a insertar
        String[] nombresCategorias = {"Bebidas", "Platos", "Postres"};

        // Insertar las categorías solo si no existen
        for (String nombre : nombresCategorias) {
            if (!categoriaExiste(nombre)) {
                CategoriaDAO.insertarCategoria(nombre);
                System.out.println("Categoría '" + nombre + "' insertada.");
            } else {
                System.out.println("La categoría '" + nombre + "' ya existe.");
            }
        }

        // Leer todas las categorías e imprimirlas
        System.out.println("\nCategorías en la base de datos:");
        List<Categoria> categorias = CategoriaDAO.obtenerCategorias();
        for (Categoria cat : categorias) {
            System.out.println(cat);
        }

        // Obtener el último ID de la categoría y realizar actualización y eliminación de prueba
        if (!categorias.isEmpty()) {
            int ultimoId = categorias.get(categorias.size() - 1).getId();

            // Actualizar la última categoría insertada a "Snacks"
            CategoriaDAO.actualizarCategoria(ultimoId, "Snacks");
            System.out.println("\nÚltima categoría actualizada a 'Snacks'.");

            // Eliminar la última categoría
            CategoriaDAO.eliminarCategoria(ultimoId);
            System.out.println("Última categoría eliminada.");
        }

        // Leer todas las categorías después de las operaciones de actualización y eliminación
        System.out.println("\nCategorías en la base de datos después de la actualización y eliminación:");
        categorias = CategoriaDAO.obtenerCategorias();
        for (Categoria cat : categorias) {
            System.out.println(cat);
        }
    }

    // Método auxiliar para verificar si una categoría ya existe
    public static boolean categoriaExiste(String nombre) {
        List<Categoria> categorias = CategoriaDAO.obtenerCategorias();
        for (Categoria cat : categorias) {
            if (cat.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
}
