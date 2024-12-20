# PruebaSegunda
Aplicacion web para la gestion de inventario de productos

# 1.0 Clases de Modelo
# 1.1 Clase Producto
Contiene la información básica del porducto y los métodos para acceder y modificar dicha información. Override de los métodos getHash() y equals()

# 1.2 Clase ServicioProducto
Contiene un Set con todos los productos, se ha elegido la interfaz Set estática para emular el funcionamiento de una base de datos y evitar repeticiones del código identificador.
Implementa los métodos relacionados con la lógica de gestión del inventario, eliminacion de elementos, listado, edición y adición.

Esta implementación resulta en que tras arrancar varias instancias del mismo proyecto, todas muestran la misma información (un delete en la "instancia 1" se ve reflejado en la "instancia 2")

# 2.0 Clases para atencion de peticiones web
# 2.1 Clase ControllerFront
Recibe las peticiones principales de la aplicación y delega dichas peticiones al componente específico para su atención

# 2.2 Clase ServletAlta
Atiende las peticiones para añadir productos al inventario

# 2.3 Clase ServletBorrar
Atiende las peticiones de borrado de elementos

# 2.4 Clase ServletBuscar
Atiende las peticiones de busqueda dentro del listado de elementos

# 2.5 Clase ServletEdit
Atienda las peticiones para editar elementos existentes en el conjunto

# 3.0 Funcionalidades
# 3.1 Listado de productos
Lista de todos los productos presentes en el almacén y de la informacion relevante. Para cada elemento se muestran 2 botones, el superior para funciones de edicion y el inferior para el borrado.

Estos botones muestran el id del producto; aunque no era la intención, sino un resultado del desconocimiento de CSS.

# 3.2 Busqueda de productos
Busqueda de productos, devuelve coincidencias con el nombre del producto y con su categoria

# 3.3 Edición de productos
Edición de ciertos valores de productos (el id no se considera editable)

# 3.4 Borrado de productos
Eliminación de productos de la colección (el borrado se ejecuta por el id del producto)
