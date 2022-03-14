
DROP PROCEDURE IF EXISTS obtener_nombre_jefe;

DELIMITER //
CREATE PROCEDURE obtener_nombre_jefe(IN idVendedorI int, OUT nombreJefeO varchar(20))
BEGIN
    SELECT vend2.nombre INTO nombreJefeO FROM vendedor as vend1 INNER JOIN vendedor as vend2 ON vend1.idVendedorJefe = vend2.idVendedor WHERE idVendedorI = vend1.idVendedor;
END//
DELIMITER ;

call obtener_nombre_jefe("101", @nombreJefeO);
select @nombreJefeO;

----------------------------------

DROP PROCEDURE IF EXISTS obtener_cantidad_clientes;

DELIMITER //
CREATE PROCEDURE obtener_cantidad_clientes(IN nombreVendedorI varchar(20), OUT cantidadClientes INT)
BEGIN
    SELECT COUNT(DISTINCT idCliente) INTO cantidadClientes FROM pedido INNER JOIN vendedor on pedido.idVendedor = vendedor.idVendedor WHERE nombre = nombreVendedorI group by pedido.idVendedor;
END//
DELIMITER ;

call obtener_cantidad_clientes ("Larry Fitch", @cantidad);
select @cantidad

-----------------------------------

DROP PROCEDURE IF EXISTS obtener_precio_producto;

DELIMITER //
CREATE PROCEDURE obtener_precio_producto(IN idFabricaIn varchar(20), idProductoIn varchar(20), OUT precioOut DOUBLE)
BEGIN
    SELECT precio INTO precioOut FROM producto WHERE idFabrica = idFabricaIn AND idProducto = idProductoIn;
END//
DELIMITER ;

call obtener_precio_producto ("ACI", "4100Z", @precio);
select @precio

------------------------------

DROP PROCEDURE IF EXISTS obtener_cantidad_pedidos_cliente;

DELIMITER //
CREATE PROCEDURE obtener_cantidad_pedidos_cliente(IN idClienteI varchar(20), OUT cantidad DOUBLE)
BEGIN
    SELECT COUNT(idPedido) INTO cantidad FROM pedido WHERE idClienteI = idCliente group by idCliente;
END//
DELIMITER ;

call obtener_cantidad_pedidos_cliente ("2107", @cantidad);
select @cantidad

-------------------------------

DROP PROCEDURE IF EXISTS vendedor_jefe_distinta_oficina;

DELIMITER //
CREATE PROCEDURE vendedor_jefe_distinta_oficina()
BEGIN
    SELECT a.idVendedor, a.nombre, a.idOficina, d.ciudad, b.idVendedor, b.nombre, b.idOficina, c.ciudad FROM vendedor as a inner join oficina as d on a.idOficina = d.idOficina INNER JOIN vendedor as b on a.idVendedorJefe = b.idVendedor inner join oficina as c on b.idOficina = c.idOficina WHERE a.idOficina != b.idOficina;
END//
DELIMITER ;

call vendedor_jefe_distinta_oficina()