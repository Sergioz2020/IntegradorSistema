-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-05-2021 a las 18:05:51
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemaasesoria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `id` int(10) NOT NULL,
  `nombre` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `institucion` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `usuario` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `contrasena` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefono` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`id`, `nombre`, `institucion`, `usuario`, `contrasena`, `email`, `telefono`) VALUES
(1, 'Serna Itsoniano del Guaymas', 'ITSON', 'serna1', '123', 'serna@gmail.co', '6222222'),
(2, 'Anita la Huerfanita', 'ITSON', 'anita', '123', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asesores`
--

CREATE TABLE `asesores` (
  `id` int(10) NOT NULL,
  `nombre` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `semestre` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefono` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `usuario` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `contrasena` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fecha` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `asesores`
--

INSERT INTO `asesores` (`id`, `nombre`, `semestre`, `telefono`, `email`, `usuario`, `contrasena`, `fecha`) VALUES
(3, 'Pancho', 'Primero  ', '2234666', ' Sergio.feliperuiz@gmail.com   ', 'sergio      ', '123   ', '0000-00-00'),
(15, 'Raulito', ' primero  ', ' 234234      ', ' sergio.feliperuiz      ', 'Camaro      ', '12  ', '0000-00-00'),
(33, 'Claudia Hdz', ' 1', '  dw', ' 33333', '  2', '      perro', '0000-00-00'),
(34, 'Sergio', 'Primero', ' 234234', ' sergio.feliperuiz', '  1', '   123', '2021-05-28'),
(36, 'Sergio Ruiz', ' 1', ' 234234', ' sergio.feliperuiz', 'sergitoguapo', ' 123', '0000-00-00'),
(37, 'Claudia Hdz', ' 6', ' 12333', ' sergio.feliperuiz', '  clau', '    123', '0019-11-11'),
(40, 'Escuela', ' ', ' ', ' ', '  ', ' ', '0027-07-14'),
(41, 'noRRIS', ' ', ' ', ' ', '  ', ' ', '2021-01-29'),
(42, 'Pedro Ramirez Covidio', ' Primero', ' 622222222', ' sergio.feliperuiz@gmail.com', 'pedrito', ' 123', '2021-05-15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asesorias`
--

CREATE TABLE `asesorias` (
  `id` int(11) NOT NULL,
  `tema` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `fecha` date NOT NULL DEFAULT '2020-04-04',
  `hora` time NOT NULL DEFAULT '01:00:00',
  `id_asesor` int(11) DEFAULT NULL,
  `Enlace` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `asesorias`
--

INSERT INTO `asesorias` (`id`, `tema`, `descripcion`, `fecha`, `hora`, `id_asesor`, `Enlace`) VALUES
(86, 'Gateell', 'GATOS ', '2021-05-03', '01:00:00', 3, '3 '),
(87, 'EDED', ' EDED', '2021-04-30', '01:00:00', 3, ''),
(89, 'wdwd', ' Mecanica 1', '2021-05-01', '01:00:00', 3, ''),
(90, 'Nikc', ' catdog ', '2021-04-21', '01:00:00', 3, ''),
(91, 'Queen', ' Rhaposfy', '2021-04-17', '01:00:00', 3, 'https://meet.google.com/wss-kgie-iao'),
(92, 'MecÃ¡nica', ' Movimiento Alterado', '2021-04-23', '01:00:00', 15, ' https://youtu.be/fJ9rUzIMcZQ'),
(93, 'MecÃ¡nica', ' Movimiento Alterado', '2021-04-23', '01:00:00', 15, ' https://youtu.be/fJ9rUzIMcZQ'),
(94, 'dwdwdw', ' 43243342', '2021-04-13', '01:00:00', 15, ' https://youtu.be/fJ9rUzIMcZQ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitantes`
--

CREATE TABLE `solicitantes` (
  `id` int(10) NOT NULL,
  `nombre` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `institucion` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefono` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `usuario` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `contrasena` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `solicitantes`
--

INSERT INTO `solicitantes` (`id`, `nombre`, `institucion`, `telefono`, `email`, `usuario`, `contrasena`) VALUES
(1, 'la mas hermosa', 'COBACH              ', '6222231313  ', 'claudia@gmail.com    ', 'felipe     ', '123          '),
(14, '', '    ', '    ', '123    ', 'dongato', 'gato '),
(15, 'sss', '   qs    ', 'ss   ', 'gato       ', '       ', '123      '),
(16, 'Claudia Hdz', 'COBACH  ', '234234   ', 'sergio.feliperuiz   ', 'clau', 'ferro'),
(19, 'Francisco', '  ', '  ', '  ', '  ', '    '),
(20, '', ' ', ' ', ' ', ' ', '  '),
(21, '', ' ', ' ', ' ', ' ', '  '),
(22, '', ' ', ' ', ' ', ' ', '  ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitudes`
--

CREATE TABLE `solicitudes` (
  `id` int(10) NOT NULL,
  `tema` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fecha` date NOT NULL DEFAULT '2021-01-13',
  `hora` time NOT NULL DEFAULT '01:00:00',
  `id_solicitante` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `solicitudes`
--

INSERT INTO `solicitudes` (`id`, `tema`, `descripcion`, `fecha`, `hora`, `id_solicitante`) VALUES
(1, 'Ayida matematicasjhjuikiu ', 'fracciones ', '2021-04-22', '01:00:00', 1),
(4, 'Temas de fÃÂ­sica please', 'quyimica', '2021-05-05', '01:00:00', 14),
(5, 'Calculo II', ' Derivadas', '2021-04-22', '01:00:00', 1),
(7, 'Temas de fÃ­sica 1', ' movimiento alteradoUniforme', '2021-04-29', '01:00:00', 14);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `asesores`
--
ALTER TABLE `asesores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `asesorias`
--
ALTER TABLE `asesorias`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_asesor` (`id_asesor`);

--
-- Indices de la tabla `solicitantes`
--
ALTER TABLE `solicitantes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `solicitudes`
--
ALTER TABLE `solicitudes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `solicitudes_ibfk_1` (`id_solicitante`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administradores`
--
ALTER TABLE `administradores`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `asesores`
--
ALTER TABLE `asesores`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT de la tabla `asesorias`
--
ALTER TABLE `asesorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=95;

--
-- AUTO_INCREMENT de la tabla `solicitantes`
--
ALTER TABLE `solicitantes`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `solicitudes`
--
ALTER TABLE `solicitudes`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asesorias`
--
ALTER TABLE `asesorias`
  ADD CONSTRAINT `asesorias_ibfk_1` FOREIGN KEY (`id_asesor`) REFERENCES `asesores` (`id`);

--
-- Filtros para la tabla `solicitudes`
--
ALTER TABLE `solicitudes`
  ADD CONSTRAINT `solicitudes_ibfk_1` FOREIGN KEY (`id_solicitante`) REFERENCES `solicitantes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
