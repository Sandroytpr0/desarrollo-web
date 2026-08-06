/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pa3_ventasdb_callañaupasandro;


public class Pa3_VentasDB_CallañaupaSandro {

--ejecutar LO SIGUIENTE BLOQUE POR BLOQUE para evitar errores.

-- 1. ejecutar línea por línea
use master

-- Modificar el nombre de la base de datos: 
-- colocar su nombre y apellido donde dice apellidoNombreAlumno
CREATE DATABASE PA2_VentasAdvanceDB_CallanaupaSandro;
-- si no coloca su nombre --> ( -1 pto)

USE Pa3_ventasdb_CallañaupaSandro;
go

-- 2. ejecutar LO SIGUIENTE BLOQUE POR BLOQUE para evitar errores.

CREATE TABLE Clientes (
    IdCliente INT PRIMARY KEY,
    Nombre VARCHAR(50),
    Ciudad VARCHAR(50),
    FechaRegistro DATE
)

CREATE TABLE Productos (
    IdProducto INT PRIMARY KEY,
    NombreProducto VARCHAR(50),
    Precio DECIMAL(10,2),
    Stock INT
)

CREATE TABLE Pedidos (
    IdPedido INT PRIMARY KEY,
    IdCliente INT,
    FechaPedido DATE,
    FOREIGN KEY (IdCliente) REFERENCES Clientes(IdCliente)
)

CREATE TABLE DetallePedido (
    IdDetalle INT PRIMARY KEY,
    IdPedido INT,
    IdProducto INT,
    Cantidad INT,
    FOREIGN KEY (IdPedido) REFERENCES Pedidos(IdPedido),
    FOREIGN KEY (IdProducto) REFERENCES Productos(IdProducto)
)

INSERT INTO Clientes VALUES
(1, 'Josefina Torres', 'Lima', '2023-01-10'),
(2, 'Luisa Pérez', 'Arequipa', '2023-02-15'),
(3, 'Mariana López', 'Lima', '2023-03-20'),
(4, 'Carlos Ruiz', 'Cusco', '2023-04-05')

INSERT INTO Productos VALUES
(1, 'Laptop', 3400, 10),
(2, 'Mouse', 50, 100),
(3, 'Teclado', 120, 50),
(4, 'Monitor', 1000, 20)

INSERT INTO Pedidos VALUES
(1, 1, '2023-05-01'),
(2, 2, '2023-05-02'),
(3, 1, '2023-05-03'),
(4, 3, '2023-05-04')

INSERT INTO DetallePedido VALUES
(1, 1, 1, 1),
(2, 1, 2, 2),
(3, 2, 3, 1),
(4, 3, 4, 1),
(5, 4, 2, 5)
--pregunta 1

CREATE TABLE Categorias (
    IdCategoria INT NOT NULL PRIMARY KEY,
    NombreCategoria VARCHAR(50) NOT NULL UNIQUE
)

ALTER TABLE Productos
ADD IdCategoria INT

ALTER TABLE Productos
ADD CONSTRAINT FK_Productos_Categorias
FOREIGN KEY (IdCategoria)
REFERENCES Categorias(IdCategoria)

ALTER TABLE Pedidos
ADD MetodoPago VARCHAR(20)

ALTER TABLE Pedidos
ADD Total DECIMAL(10,2)

 --Pregunta 2
ALTER TABLE Productos
ADD CONSTRAINT CHK_Productos_Precio
CHECK (Precio > 0)

ALTER TABLE Productos
ADD CONSTRAINT CHK_Productos_Stock
CHECK (Stock >= 0)

ALTER TABLE DetallePedido
ADD CONSTRAINT CHK_DetallePedido_Cantidad
CHECK (Cantidad > 0)

ALTER TABLE Pedidos
ADD CONSTRAINT CHK_Pedidos_MetodoPago
CHECK (MetodoPago IN ('Efectivo', 'Tarjeta', 'Transferencia'))

ALTER TABLE Pedidos
ADD CONSTRAINT CHK_Pedidos_Fecha
CHECK (FechaPedido <= GETDATE())

INSERT INTO Categorias VALUES
(1, 'Laptops'),
(2, 'Accesorios'),
(3, 'Teclados'),
(4, 'Monitores')

-- =========================================
-- ACTUALIZAR CATEGORIAS
-- =========================================

UPDATE Productos
SET IdCategoria = 1
WHERE NombreProducto = 'Laptop'

UPDATE Productos
SET IdCategoria = 2
WHERE NombreProducto = 'Mouse'

UPDATE Productos
SET IdCategoria = 3
WHERE NombreProducto = 'Teclado'

UPDATE Productos
SET IdCategoria = 4
WHERE NombreProducto = 'Monitor'

-- =========================================
-- ACTUALIZAR METODOS DE PAGO
-- =========================================

UPDATE Pedidos
SET MetodoPago = 'Efectivo'
WHERE IdPedido = 1

UPDATE Pedidos
SET MetodoPago = 'Tarjeta'
WHERE IdPedido = 2

UPDATE Pedidos
SET MetodoPago = 'Transferencia'
WHERE IdPedido = 3

UPDATE Pedidos
SET MetodoPago = 'Efectivo'
WHERE IdPedido = 4

INSERT INTO Categorias VALUES
(1, 'Computo'),
(2, 'Accesorios')

UPDATE Productos SET IdCategoria = 1 WHERE IdProducto IN (1,4);
UPDATE Productos SET IdCategoria = 2 WHERE IdProducto IN (2,3);

Update Pedidos
SET MetodoPago = 'Tarjeta'
Where IdPedido IN (1,3);

UPDATE Pedidos
SET MetodoPago = 'Efectivo'
Where IdPedido IN (2,4);

INSERT INTO Clientes VALUES
(5, 'Pedro Gomez', 'Lima', '2023-06-01'),
(6, 'Lucia Diaz' , 'Arequipa' , '2023-06-10');

INSERT INTO Productos VALUES

(5, 'Tablet', 1500 , 15 , 1);

INSERT INTO Pedidos VALUES

(5,5, '2023-05-05' , 'Transferencia',NULL),
(6,1, '2023-05-06' , 'Tarjeta' , NULL);

INSERT INTO DetallePedido VALUES

(6,5,1,2),
(7,5,3,3),
(8,6,2,10);
--Pregunta 3 
-- A. Lista de pedidos con clientes

SELECT
    p.IdPedido,
    c.Nombre,
    p.FechaPedido,
    p.MetodoPago,
    p.Total
FROM Pedidos p
INNER JOIN Clientes c
ON p.IdCliente = c.IdCliente

-- =========================================

-- B. Productos con precio mayor al promedio

SELECT
    IdProducto,
    NombreProducto,
    Precio,
    Stock
FROM Productos
WHERE Precio > (
    SELECT AVG(Precio)
    FROM Productos
)

-- =========================================

-- C. Actualizar total de pedidos

UPDATE Pedidos
SET Total = (
    SELECT SUM(dp.Cantidad * p.Precio)
    FROM DetallePedido dp
    INNER JOIN Productos p
    ON dp.IdProducto = p.IdProducto
    WHERE dp.IdPedido = Pedidos.IdPedido
)

-- Verificar

SELECT * FROM Pedidos

-- =========================================

-- D. Clientes que gastaron más que el promedio

SELECT
    c.IdCliente,
    c.Nombre,
    SUM(p.Total) AS TotalGastado
FROM Clientes c
INNER JOIN Pedidos p
ON c.IdCliente = p.IdCliente
GROUP BY c.IdCliente, c.Nombre
HAVING SUM(p.Total) > (
    SELECT AVG(Total)
    FROM Pedidos
)

-- =========================================

-- E. Ventas totales por categoría

SELECT
    ca.NombreCategoria,
    SUM(dp.Cantidad * p.Precio) AS VentasTotales
FROM Categorias ca
INNER JOIN Productos p
ON ca.IdCategoria = p.IdCategoria
INNER JOIN DetallePedido dp
ON p.IdProducto = dp.IdProducto
GROUP BY ca.NombreCategoria

-- =========================================

-- F. Reporte con CASE

SELECT
    pe.IdPedido,
    c.Nombre,
    p.NombreProducto,
    dp.Cantidad,
    CASE
        WHEN dp.Cantidad >= 3 THEN 'Compra Alta'
        ELSE 'Compra Baja'
    END AS TipoCompra
FROM Pedidos pe
INNER JOIN Clientes c
ON pe.IdCliente = c.IdCliente
INNER JOIN DetallePedido dp
ON pe.IdPedido = dp.IdPedido
INNER JOIN Productos p
ON dp.IdProducto = p.IdProducto

    
}
