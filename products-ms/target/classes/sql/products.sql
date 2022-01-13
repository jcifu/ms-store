DROP DATABASE IF EXISTS `products`;
CREATE DATABASE IF NOT EXISTS `products`;

USE `products`;

DROP TABLE IF EXISTS products;

CREATE TABLE IF NOT EXISTS `products` (
    `productCode` int(11) NOT NULL,
    `productName` VARCHAR(100) NOT NULL,
    `brand` VARCHAR(50) NOT NULL,
    `quantity` int(11) NOT NULL,
    `price` int(50) NOT NULL,
    `description` VARCHAR(500) NOT NULL,
    `categoryId` int(11) NOT NULL,
    PRIMARY KEY (`productCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `products` (`productCode`, `productName`, `brand`, `quantity`, `price`, `description`, `categoryId`) VALUES
(300, 'TUF Gaming F15 FX506LH-HN110T Intel Core i5 8GB RAM 512GB SSD NVIDIA GeForce GTX 1650 15.6" 144Hz', 'ASUS', 15, 849990, 'Procesador: Intel Core i5 \nModelo tarjeta de video: NVIDIA GeForce GTX 1650 \nTamaño de la pantalla: 15.6 pulgadas \nDisco duro HDD: No tiene \n Unidad de estado sólido SSD: 512GB', 1),
(301, 'Notebook Gamer Nitro 5 AN515-55-56P2-1 Intel Core i5 12GB RAM 512 GB SSD NVIDIA GeForce GTX 1650 15.6"', 'ACER', 10, 799000, 'Tipo: Gamers \nTasa de refresco nativa: 144Hz \nProfundidad: 25.5cm \nTamaño de la pantalla: 15.6 pulgadas \nConexión Bluetooth: Sí', 1);
