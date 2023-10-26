README - Administración del menú y pedidos en bar / restaurant

Se desea desarrollar una aplicación para ser usada en un bar. La aplicación es utilizada
por tres tipos de usuarios: empleados, encargados y clientes. De los usuarios se conoce
su cuenta de correo y clave de acceso a la aplicación, apellido y nombre. Tener en
cuenta que no puede haber dos usuarios con el mismo correo.
Los encargados pueden crear empleados.
Cada cliente puede hacer pedidos agregando y quitando los productos que desea
solicitar y consultar los pedidos que va haciendo. Al crear un pedido este queda en
estado “creado”.
Cuando el cliente realiza la solicitud del pedido, ya no puede modificarlo y está
disponible para que lo vean los empleados del bar. pasando al estado “procesando”.
Los empleados pueden ver los pedidos solicitados, pero no pueden realizar pedidos.
Cuando el empleado termina de preparar el pedido lo envía al cliente y el mismo se
marca como “entregado”.
Para cada pedido se registra un número correlativo, la fecha y hora en la que se crea y
los productos solicitados, con sus correspondientes cantidades. Para un mismo pedido
no pueden agregarse dos productos iguales.
Cada producto se identifica con un nombre, una descripción y un precio unitario. Un
producto puede estar “disponible” o “no disponible”. En la lista de productos no puede
haber dos que tengan la misma descripción. Un producto pertenece a una categoría
que puede ser: entrada, plato principal, postre. Estas permiten organizar los productos
en el menú. El cliente puede consultar el menú que presenta la lista de productos
disponibles en un momento determinado organizado por categorías. Los empleados
son los que se ocupan de indicar el estado actual de los productos.

Este proyecto es una colaboración entre:

- Gonzalo N. Diaz Y.          Gmail: gonzalio100@gmail.com              Github: https://github.com/GonzaloNDY

- Mario Nicolas Colman        Gmail: colman.nicolas.17@gmail.com        Github: https://github.com/ColmanNicolas

