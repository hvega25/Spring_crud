CREATE TABLE `libros`(
`id` int NOT NULL primary key auto_increment,
`titulo` varchar (100)  NOT NULL,
`autor` varchar (100)  NOT NULL,
`editorial` varchar(50) NOT NULL,
`fecha` varchar(30) NOT NULL,
`tematica` varchar(50) NOT NULL
);


CREATE TABLE IF NOT EXISTS `usuarios`(
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `usuario` varchar (30) NOT NULL UNIQUE,
    `password` varchar (30) NOT NULL
);