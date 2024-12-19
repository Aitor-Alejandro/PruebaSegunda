package com.curso.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.curso.model.Producto;

/**
 * La Clase ServicioProducto gestiona la lógica relacionada con la gestión
 * Productos
 * 
 * @author Aitor Alejandro Martinez Cedillo Viewnext
 * @version 1.0 19/12/2024
 *
 */
public class ServicioProducto {

	private static ServicioProducto INSTANCE = null;
	private static Set<Producto> setProductos = null;

	private ServicioProducto() {
		setProductos = new HashSet<>();

		setProductos.add(new Producto(1, "Patatas", "Tuberculo", 4.0, 50));
		setProductos.add(new Producto(2, "Kiwis", "Fruta", 12.0, 5));
		setProductos.add(new Producto(3, "Naranja", "Fruta", 17.0, 15));
		setProductos.add(new Producto(4, "Pimiento", "Verdura", 5.0, 30));
		setProductos.add(new Producto(5, "Apio", "Verdura", 3.5, 20));
	}

	public static ServicioProducto getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ServicioProducto();
		return INSTANCE;
	}

	public boolean add(Producto p) {
		return setProductos.add(p);
	}

	public Set<Producto> getProductos() {
		return setProductos;
	}

	public Set<Producto> buscarProductos(String busqueda) {
		Set<Producto> setBusqueda = new HashSet<>();
		for (Producto producto : setProductos) {
			if (producto.getNombre().equals(busqueda) || producto.getCategoria().equals(busqueda)) {
				setBusqueda.add(producto);
			}
		}
		return setBusqueda;
	}

	public boolean remove(Producto p) {
		return setProductos.remove(p);
	}
	
	public Producto find(Producto pBusq) {
		Producto p = null;
		if (setProductos.contains(pBusq)) {
			for (Producto producto : setProductos) {
				if (pBusq.equals(producto)) {
					p=producto;
				}
			}
		}
		return p;
	}

	public boolean change(Producto pViejo, Producto pNuevo) {
		boolean change = false;
		if (setProductos.contains(pViejo)) {
			for (Producto producto : setProductos) {
				if (pViejo.equals(producto)) {
					change =true;
					producto.setNombre(pNuevo.getNombre());
					producto.setCategoria(pNuevo.getCategoria());
					producto.setPrecio(pNuevo.getPrecio());
					producto.setStock(pNuevo.getStock());
				}
			}
		}
		return change;
	}
	
	public boolean eliminar (Producto pElim) {
		boolean eliminado = false;
		Iterator<Producto> it = setProductos.iterator();
		if (setProductos.contains(pElim)) {
			while (it.hasNext() ) {
				Producto p = it.next();
				if (pElim.equals(p)) {
					it.remove();
					eliminado = true;
				}
			}
		}
		return eliminado;
	}
}
