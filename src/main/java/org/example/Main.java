package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin(); // iniciar transacción

            /*// crear categorias
            Categoria bazar = new Categoria("Bazar");
            Categoria accesorios = new Categoria("Accesorios");
            Categoria electro = new Categoria("Electro");
            Categoria ceramica = new Categoria("Ceramica");

            // crear articulos
            Articulo taza1 = new Articulo(5, "Taza - grande - amarilla", 2500);
            Articulo taza2 = new Articulo(2, "Taza - chica - roja", 2000);
            Articulo billetera = new Articulo(2, "Billetera", 1500);
            Articulo auriculares = new Articulo(3, "Auriculares", 2500);

            // agregar categoria a articulo
            taza1.getCategorias().add(bazar);
            taza2.getCategorias().add(bazar);
            taza1.getCategorias().add(ceramica);
            taza2.getCategorias().add(ceramica);
            billetera.getCategorias().add(accesorios);
            auriculares.getCategorias().add(electro);

            // agregar articulo a categoria
            bazar.getArticulos().add(taza1);
            ceramica.getArticulos().add(taza1);
            bazar.getArticulos().add(taza2);
            ceramica.getArticulos().add(taza2);
            accesorios.getArticulos().add(billetera);
            electro.getArticulos().add(auriculares);

            // crear facturas
            Factura fac1 = new Factura("05/08/2024", 1);
            Factura fac2 = new Factura("07/08/2024", 2);

            // crear cliente
            Cliente cliente = new Cliente("Luciana", "Ortiz", 42713547);
            Domicilio domicilio = new Domicilio("B° El Prado", 5);

            // agregar domicilio a cliente
            cliente.setDomicilio(domicilio);

            // agregar cliente a factura
            fac1.setCliente(cliente);
            fac2.setCliente(cliente);

            // crear items de compra a fac1
            DetalleFactura i1f1 = new DetalleFactura();
            i1f1.setArticulo(taza1);
            i1f1.setCantidad(2);
            i1f1.setSubtotal(5000);
            fac1.getFacturas().add(i1f1);

            DetalleFactura i2f1 = new DetalleFactura();
            i2f1.setArticulo(auriculares);
            i2f1.setCantidad(1);
            i2f1.setSubtotal(2500);
            fac1.getFacturas().add(i2f1);

            // crear items de compra a fac2
            DetalleFactura i1f2 = new DetalleFactura();
            i1f2.setArticulo(taza2);
            i1f2.setCantidad(1);
            i1f2.setSubtotal(2500);
            fac2.getFacturas().add(i1f2);

            DetalleFactura i2f2 = new DetalleFactura();
            i2f2.setArticulo(billetera);
            i2f2.setCantidad(1);
            i2f2.setSubtotal(1500);
            fac2.getFacturas().add(i2f2);*/

            //buscar las facturas por id
            Factura fac1 = entityManager.find(Factura.class, 1L);
            Factura fac2 = entityManager.find(Factura.class, 2L);

            //editar valores
            /*fac1.setNumero(85);
            fac2.setNumero(100);*/

            //eliminar fac2
            entityManager.remove(fac2);

            // persiste fac1 y fac2
           /* entityManager.persist(fac1);
            entityManager.persist(fac2);*/

            //edita fac1 y fac2
            /*entityManager.merge(fac1);
            entityManager.merge(fac2);*/

            entityManager.flush();
            entityManager.getTransaction().commit();

            // Consultar y mostrar la entidad persistida
             Factura f1 = entityManager.find(Factura.class, fac1.getId());
             Factura f2 = entityManager.find(Factura.class, fac2.getId());
            System.out.println("----------------------------------");
             System.out.println("Factura 1: " + f1);
            System.out.println("----------------------------------");
             System.out.println("Factura 2: " + f2);

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la clase Factura");
        }

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
