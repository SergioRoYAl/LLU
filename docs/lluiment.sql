-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: database:3306
-- Generation Time: Feb 20, 2024 at 09:41 PM
-- Server version: 8.2.0
-- PHP Version: 8.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lluimentDB`
--

-- --------------------------------------------------------

--
-- Table structure for table `detallepedido`
--

CREATE TABLE `detallepedido` (
  `id` bigint NOT NULL,
  `id_documento` bigint NOT NULL,
  `id_producto` bigint NOT NULL,
  `cantidad` int NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `detallepedido`
--

INSERT INTO `detallepedido` (`id`, `id_documento`, `id_producto`, `cantidad`, `precio`) VALUES
(35, 68, 1, 11, 385),
(36, 68, 42, 4, 60),
(37, 68, 36, 5, 90),
(38, 68, 40, 5, 110),
(39, 67, 1, 13, 455),
(40, 67, 6, 7, 245),
(41, 67, 7, 3, 105),
(42, 67, 9, 4, 40),
(43, 68, 2, 4, 140),
(44, 67, 3, 7, 154);

-- --------------------------------------------------------

--
-- Table structure for table `documento`
--

CREATE TABLE `documento` (
  `id` bigint NOT NULL,
  `id_usuario` bigint NOT NULL,
  `fecha_pedido` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `documento`
--

INSERT INTO `documento` (`id`, `id_usuario`, `fecha_pedido`) VALUES
(64, 22, NULL),
(67, 1, NULL),
(68, 18, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `noticia`
--

CREATE TABLE `noticia` (
  `id` bigint NOT NULL,
  `titulo` varchar(256) NOT NULL,
  `descripcion` varchar(4192) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `id_usuario` bigint NOT NULL,
  `foto` varchar(4192) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `visible` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `noticia`
--

INSERT INTO `noticia` (`id`, `titulo`, `descripcion`, `id_usuario`, `foto`, `visible`) VALUES
(7, 'Pepino Mágicosa', 'El pepino es la secuencia secuoya', 18, 'http://localhost:8383/media/c73dcc62594e2d2bcdbc3f99597ff4f7.jpg', 1),
(9, 'El mercado sobre ropa', 'A lo largo de los años se ha encontrado una simbiosis casi exacta de mezcla perfecta con la consonancia interestelar de la galleta interestelaria', 1, 'http://localhost:8383/media/2010-12-08%2015-30-27.jpg', 1),
(21, 'Calambrazo', 'Tengo cachibaches indispensables', 1, 'http://localhost:8383/media/Neutral%20Beige%20Minimalist%20Company%20Organizational%20Chart%20(1).png', 1);

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE `producto` (
  `id` bigint NOT NULL,
  `nombre` varchar(128) NOT NULL,
  `descripcion` varchar(1024) DEFAULT NULL,
  `tamanyo` varchar(64) DEFAULT NULL,
  `materiales` varchar(128) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `color` varchar(64) NOT NULL,
  `precio` double NOT NULL,
  `visible` tinyint NOT NULL,
  `foto` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `tipo` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `descripcion`, `tamanyo`, `materiales`, `fecha_creacion`, `color`, `precio`, `visible`, `foto`, `tipo`) VALUES
(1, 'Love Wish', 'Stainless steel necklace with rose quartz stones and star decoration.\r\n\r\nCollar de acero inoxidable con piedras de cuarzo rosa y decoración de estrella.', NULL, 'Stainless Steel', '2024-01-01', 'Rose Quartz', 35, 1, 'Love_Wish_1.webp', 'necklace'),
(2, 'Stone Wish', 'Stainless steel necklace with faceted amazonite beads and star decoration.\r\n\r\nCollar de acero inoxidable con cuentas de amazonita facetada y decoración de estrella.', NULL, 'Amazonite Beads\r\nStainless Steel', NULL, 'Tourquoise', 35, 1, 'Stone_Wish_1.webp', 'necklace'),
(3, 'Blume', 'Stainless steel necklace with pink crystals.\r\n\r\nCollar de acero inoxidable con cristales rosas.', NULL, 'Pink Crystals\r\nStainless Steel', NULL, 'Pink\r\nSteel', 22, 1, 'Blume_1.webp', 'necklace'),
(4, 'Amber Crystal', 'Stainless steel necklace with amber colored crystals.\r\n\r\nCollar de acero inoxidable con cristales color ámbar.', NULL, 'Amber Crystal\r\nStainless Steel', NULL, 'Amber\r\nSteel', 22, 1, 'Amber_Crystal_1.webp', 'necklace'),
(5, 'Ski', 'Stainless steel necklace with transparent crystals.\r\n\r\nCollar de acero inoxidable con cristales transparentes.', NULL, 'Transparent Crystal\r\nStainless Steel', NULL, 'Transparent\r\nSteel', 22, 1, 'Ski_1.webp', 'necklace'),
(6, 'Manifest Love Shine', 'Stainless steel necklace with crystals hematite-tone metallic heart detail.\r\n\r\nCollar de acero inoxidable con cristales y detalle de corazón metalizado tono hematita.', NULL, 'Hematite-tone metallic heart\r\nStainless Steel', NULL, 'Hematie-tone\r\nSteel', 35, 1, 'Manifest_Love_Shine_1.webp', 'necklace'),
(7, 'Manifest Love Metal', 'Stainless steel necklace with hematite-tone metallic heart detail.\r\n\r\nCollar de acero inoxidable con detalle de corazón metalizado tono hematita.\r\n\r\n', NULL, 'Hematite-tone\r\nStainless Steel', NULL, 'Steel\r\nHematite', 35, 1, 'Manifest_Love_Metal_1.webp', 'necklace'),
(8, 'Mirror Bracelet', 'Stainless steel plate bracelet. It belongs to the permanent collection. 20cm. Matching necklace available.\r\n\r\nPulsera de placas de acero inoxidable. Pertenece a la colección permanente. 20cm. Collar a juego disponible.', '20cm', 'Stainless steel plate', NULL, 'Steel', 9, 1, 'Mirror_Bracelet_1.webp', 'bracelet'),
(9, 'Amadora', 'Pulsera de acero inoxidable y mineral.', '19cm', 'Amethyst\r\nWhite Quartz\r\nTransparent Quartz', NULL, 'Amethyst\r\nWhite\r\nTransparent', 10, 1, 'Amadora_1.webp', 'Bracelet'),
(10, 'Mirror Necklace', 'Stainless steel plate necklace. It belongs to the permanent collection. 43cm.\r\nMatching bracelet available.\r\n\r\nCollar de placas de acero inoxidable. Pertenece a la colección permanente. 43 cm.\r\nPulsera a juego disponible.', '43cm', 'Stainless Steel', NULL, 'Steel', 18, 1, 'Mirror_Necklace.webp', 'neckalce'),
(11, 'Rockstar', 'Stainless steel necklace with star beads. It belongs to the permanent collection.\r\n48 cm.\r\n\r\nCollar de acero inoxidable con cuentas de estrellas. Pertenece a la colección permanente.\r\n48 cm.', '48cm', 'Stainless Steel', NULL, 'Steel', 28, 1, 'Rockstar.webp', 'necklace'),
(12, 'Papallona Earings', 'Par de pendientes de acero inoxidable con lazo de satín y pieza de piercing. Disponible en 4 colores.', NULL, 'Stainless Steel', NULL, 'Black\r\nWhite\r\nPink\r\nBlue', 7, 1, 'Papallona_Earings_1.webp', 'earings'),
(13, 'Mareta', 'Unique piece.\r\nStainless steel necklace with blue and silver crystal beads. It does not darken the metal but it is recommended that it not be exposed to liquids.\r\n46cm\r\n\r\nPieza única. Collar de acero inoxidable con cuentas de cristales azules y plateados. No se oscurece el metal pero se recomienda que no se exponga a líquidos.\r\n46 cm', '46cm', 'Stainless Steel\r\nBlue Crystals\r\nSilver Crystals', NULL, 'Blue\r\nSilver', 22, 1, 'Mare_1.webp', 'necklace'),
(14, 'Verinós', 'Collar de acero inoxidable con cuentas de cristal verde.\r\nPertenece a la colección permanente.\r\n47 cm', '47cm', 'Green Crystal', NULL, 'Green', 22, 1, 'Verin%C3%B3s_1.webp', 'necklace'),
(15, 'Wish', 'Collar de acero inoxidable con turquesa cerámica y charms de estrella de acero inoxidable.\r\n46 cm\r\nPertenece a la colección permanente.', '46cm', 'Turquoise Ceramic', NULL, 'Turquoise', 25, 1, 'Wish_1.webp', 'necklace'),
(16, 'Gnome 001', 'Unique piece. Stainless steel chain necklace with crystal beads.\r\n40cm.\r\n\r\nPieza Única. Collar de cadena de acero inoxidable con cuentas de cristal.\r\n40cm.', '40cm', 'Stainless Steel\r\nCrystal Beads', NULL, 'Black\r\nBlue\r\nYellow\r\nRed', 16, 1, 'Gnome_001_1.webp', 'necklace'),
(17, 'Clouday 001', 'Unique piece. Stainless steel necklace with white, transparent and blue glass beads.\r\n45cm\r\n\r\nPieza Única. Collar de acero inoxidable con cuentas de cristal blancas, transparentes y azules.\r\n45cm.', '45cm', 'Stainless Steel\r\nWhite Glass\r\nTransparent Glass\r\nBlue Glass', NULL, 'Silver\r\nWhite\r\nTransparent\r\nBlue', 27, 1, 'Clouday_001.webp', 'necklace'),
(18, 'Roseta 001', 'Unique piece.\r\nStainless steel necklace with painted ceramic beads.\r\nThe spike beads are made of metal, they are not stainless steel, so it is recommended to avoid contact with liquids.\r\n46cm.\r\n\r\nPieza Única.\r\nCollar de acero inoxidable con cuentas de cerámica pintada.\r\nLas cuentas de pincho son de metal, no son de acero inoxidable por lo que se recomienda evitar el contacto con líquidos.\r\n46 cm.', '46cm', 'Stainless Steel\r\nPainted Ceramic Breads\r\nSpike Metal Beads', NULL, 'Silver\r\nGreen\r\nWhite\r\nYellow', 30, 1, 'Roseta_001_1.webp', 'necklace'),
(19, 'Jardí 001', 'Unique piece. Stainless steel necklace with three unions. Made with green and clear crystals and amethyst stones.\r\n\r\nPieza Única. Collar de acero inoxidable con tres uniones. Hecho con cristales verdes y transparentes y piedras de amatista.', NULL, 'Stainless Steel\r\nGreen Crystal\r\nClear Crystal\r\nAmethyst Stone', NULL, 'Silver\r\nGreen\r\nTransparent\r\nAmethyst', 30, 1, 'Jard%C3%AD_001_1.webp', 'necklace'),
(20, 'Bone Chain 001', 'Unique piece.\r\nStainless steel necklace with reinforced piercings,ceramic turquoise and glass beads.\r\n54 cm.\r\n\r\nPieza única.\r\nCollar de acero inoxidable con piercings reforzados y cuentas de cristal y turquesa cerámica.\r\n54 cm.', '54cm', 'Stainless Steel\r\nCeramic Turquoise\r\nGlass Beads\r\nReinforced Piercings', NULL, 'Silver\r\nTurquoise\r\nTransparent', 25, 1, 'Bone_Chain_1.webp', 'necklace'),
(21, 'Glass Armour', 'Pieza única. Collar de acero inoxidable con piercings reforzados (tratamiento para que las piezas del piercing no se separen fácilmente) y cristales transparentes.\r\n47 cm', '47cm', 'Stainless Steel\r\nReinforced Piercing\r\nTransparent Crystal', NULL, 'Silver\r\nTransparent\r\n', 28, 1, 'Glass_Armour_1.webp', 'necklace'),
(22, 'Arrows', 'Stainless steel necklace with reinforced piercings. The steel is not damaged but it is recommended to avoid exposure to liquids. It belongs to the permanent collection.\r\n45cm\r\n\r\nCollar de acero inoxidable con piercings reforzados. No se estropea el acero pero se recomienda evitar la exposición a líquidos. Pertenece a la colección permanente.\r\n45cm', '45cm', 'Stainless Steel\r\nReinforced Piercings', NULL, 'Silver', 29, 1, 'Arrows_1.webp', 'necklace'),
(23, 'Teloner 001', 'Unique piece. Stainless steel necklace with tinted white coral and mother-of-pearl beads. The material is stainless but to prevent the red beads from fading try as little contact with water as possible.\r\n47cm\r\n\r\nPieza Única. Collar de acero inoxidable con cuentas de coral blanco tintado y nácar. El material es inoxidable pero para evitar que las cuentas rojas se destiñan intentar el menor contacto con agua posible.\r\n47cm', '47cm', 'Stainless Steel\r\nTinted White Coral\r\nMother-of-pearl Beads', NULL, 'Silver\r\nWhite\r\nRed', 25, 1, 'Teloner_001_1.webp', 'necklace'),
(24, 'Plorera 001', 'Unique piece. Necklace with stainless steel chain and glass beads.\r\n50cm\r\n\r\nPieza Única. Collar con cadena de acero inoxidable y cuentas de cristal.\r\n50 cm', '50cm', 'Stainless Steel\r\nGreen Glass Beads\r\nBlue Glass Beads', NULL, 'Stainless Steel\r\nBlue\r\nGreen', 20, 1, 'Plorera_001_1.webp', 'necklace'),
(25, 'Manifest Love', 'Pieza única. Collar de acero inoxidable. Contiene turmalina, turquesa y charm de corazón de cobre con incrustraciones de cristal.', NULL, 'Stainless Steel\r\nTurmaline\r\nTurquoise\r\nHeart Charm', NULL, 'Silver\r\nBlue\r\nBlack', 25, 1, 'Manifest_Love_1.webp', 'necklace'),
(26, 'Vitral', 'Necklace with stainless steel chain and crystals of various colors. The arrangement of the beads can be modified, making each piece a similar but unique combination.\r\nIt belongs to the permanent collection.\r\n47cm\r\n\r\nCollar con cadena de acero inoxidable y cristales de varios colores. La disposición de las cuentas puede verse modificada, lo que hace que cada pieza tenga una combinación similar pero única.\r\nPertenece a la colección permanente.\r\n47cm', '47cm', 'Stainless Steel\r\n', NULL, 'Silver\r\nGreen\r\nBlue\r\nBlack', 33, 1, 'Vitral_1.webp', 'necklace'),
(27, 'Safe', 'Collar de acero inoxidable con piercings reforzados con tratamiento para evitar apertura.\r\n47cm\r\nPertenece a la colección permanente.', '47cm', 'Stainless Steel\r\nReinforced Piercing', NULL, 'Silver', 27, 1, 'Safe_1.webp', 'necklace'),
(28, 'Twilight', 'Gargantilla de acero inoxidable con cuentas de coral blanco tintado y cristal transparente. Pertenece a la colección permanente.\r\n35 cm', '35cm', 'Stainless Steel\r\nWhite Coral\r\nTransparent Crystal', NULL, 'Silver\r\nRed\r\nTransparent', 27, 1, 'Twilight_1.webp', 'necklace'),
(29, 'Prado', 'Collar de acero inoxidable con cuentas de cristal verde.\r\nPertenece a la colección permanente.\r\n40 cm', '40cm', 'Stainless Steel\r\nGreen Crystal', NULL, 'Silver\r\nGreen', 16, 1, 'Prado_1.webp', 'necklace'),
(30, 'Star Rock', 'Unique piece.\r\nStainless steel necklace. Contains mother-of-pearl stars, transparent crystals and piercings reinforced with treatment to prevent opening.\r\n49cm\r\n\r\nPieza única. Collar de acero inoxidable. Contiene estrellas de nácar, cristales transparentes y piercings reforzados con tratamiento para evitar abertura.\r\n49 cm', '49cm', 'Stainless Steel\r\nMother-of-peearl stars\r\nTransparent Crystals\r\nReinforced Piercings', NULL, 'Silver\r\nWhite\r\nTransparent', 28, 1, 'Star_Rock_1.webp', 'necklace'),
(31, 'Queen Treatment', 'Pieza Única. Collar de acero inoxidable compuesto de nácar, ágata negra y cristal Burdeos.\r\n44cm', '44cm', 'Stainless Steel\r\nNacar\r\nBlack Agata\r\nBordeaux Crystal\r\n', NULL, 'Silver\r\nWhite\r\nBlack\r\nBordeaux', 30, 1, 'Queen_Traitmen_1.webp', 'necklace'),
(32, 'Talking Heart', 'Collar de acero inoxidable con cuentas de turquesa en forma de corazón y cristal transparente.\r\n45cm\r\nPertenece a la colección permanente.', '45cm', 'Stainless Steel\r\nTransparent Crystal\r\nTurquoise Heart', NULL, 'Silver\r\nTransparent\r\nBlue', 22, 1, 'Talking_heart_1.webp', 'necklace'),
(33, 'Marine', 'Pieza Única. Pulsera de acero inoxidable con perlas metalizadas.\r\n20 cm.', '20cm', 'Stainless Steel\r\nMetalized Pearl', NULL, 'Silver', 10, 1, 'Marine_1.webp', 'bracelet'),
(34, 'Mare', 'Collar de acero inoxidable con perlas. Pertenece a la colección permanente.\r\n\r\nStainless steel necklace with pearls. It belongs to the permanent collection.', NULL, 'Stainless Steel\r\nPearls', NULL, 'Silver\r\nPearl', 25, 1, 'Mare_1.webp', 'necklace'),
(35, 'Heaven', 'Pieza Única. Pulsera de acero inoxidable con cuentas de cristal azul y corazones de nácar.\r\n20 cm', '20cm', 'Stainless Steel\r\nBlue Crystal\r\nNacar Crystal', NULL, 'Silver\r\nBlue', 6, 1, 'Heaven_1.webp', 'bracelet'),
(36, 'Heaven Collar', 'Pieza Única. Collar de acero inoxidable que contiene cristales y corazones de nácar.\r\n47cm', '47cm', 'Stainless Steel', '2024-01-01', 'Silver\r\nBlue\r\nWhite', 18, 1, NULL, 'necklace'),
(37, 'Fosc', 'Unique piece. Stainless steel necklace with mother-of-pearl, pearls, lapislazuli and crystal beads.\r\n43cm.\r\n\r\nPieza Única. Collar de acero inoxidable con cuentas de nácar, perlas, lapislázuli y cristal.\r\n43 cm.', '43cm', 'Stainless Steel\r\nMother-of-pearl\r\nPearl\r\nLapislazuli\r\nCrystal Beads', NULL, 'Silver\r\nBlue\r\nPearl\r\n', 25, 1, 'Fosc_1.webp', 'necklace'),
(38, 'Parella', 'Cadena simple con doble eslabón de acero inoxidable.\r\n40 cm\r\nCualquier pieza puede ser alargada o acortada sin coste indicando en observaciones al finalizar la compra.', '40cm', 'Stainless Steel', NULL, 'Silver', 16, 1, 'Parella_1.webp', 'necklace'),
(39, 'Ocean', 'Collar de acero inoxidable. Contiene: corazones de nácar, lapislazuli, ágata negra, turquesa, cristales variados.\r\n43cm\r\nCualquier pieza puede ser alargada o acortada sin coste indicando en observaciones al finalizar la compra.', '43cm', 'Stainless Steel\r\nNacre Hearts\r\nLapislazuli\r\nBlack Agata\r\nTurquoise\r\nCrystals', NULL, 'Silver\r\nBlue\r\nWhite\r\nBlack', 24, 1, 'Ocean_1.webp', 'necklace'),
(40, 'Same Moon', 'Collar de acero inoxidable con cuentas de nácar y turmalina. Pertenece a la colección permanente.\r\n45cm', '45cm', 'Stainless Steel\r\nNacre', NULL, 'Silver\r\n', 22, 1, 'Same_moon_1.webp', 'necklace'),
(41, 'Deset', 'Collar de acero inoxidable. Contiene turquesa, nácar, turmalina, ágata negra, coral blanco tintado,malaquita cerámica, lapislazuli y cristales.\r\n\r\nCualquier pieza puede ser alargada o acortada sin coste indicando en observaciones al finalizar la compra.\r\n', '47cm', 'Stainless Steel\r\nTurquoise Heart\r\nNacre Heart\r\nTurmalina\r\nBlack Agata\r\nWhite Coral\r\nMalaquite Ceramic\r\nLapislazuli\r\nCrystal\r\n', NULL, 'Silver\r\nWhite\r\nRed\r\nGreen\r\nRed', 24, 1, 'Deset_1.webp', 'necklace'),
(42, 'Shinny', 'Collar de acero inoxidable con cuentas de cristal transparente y una estrella de nácar.\r\n\r\nPertenece a la colección permanente.', '40cm', 'Stainless Steel\r\nCrystal\r\nNacre Star', NULL, 'Silver\r\nWhite', 15, 1, 'Shinny_1.webp', 'necklace'),
(43, 'Pendientes Lovetalk', 'Pendientes de acero inoxidable con turquesas de corazón.', '', 'Stainless Steel\r\nTurquoise Heart', '2024-01-01', 'Silver\r\nTurquoise', 5, 1, 'Pendientes_Lovetalk_1.webp', 'earing'),
(44, 'Turmala', 'Pieza única. Collar doble de acero inoxidable con cuentas de turmalina y malaquita cerámica.\r\n', '42cm', 'Stainless Steel\r\nTurmaline\r\nMalaquite', NULL, 'Silver\r\nBlack\r\nGreen', 20, 1, 'Turmala_1.webp', 'necklace'),
(45, 'Lil Amulet 001', 'Amuleto para decorar el móvil o utilizar de llavero.\r\nHecho con acero inoxidable, contiene cristales y pieza de metal de corazón con incrustraciones.', NULL, 'Stainless Steel\r\nCrystals\r\nMetal Heart with Crystals', NULL, 'Silver\r\nBlue', 4, 1, 'Lil_Amulet_001_1.webp', 'earings'),
(46, 'Pendientes Verdet', 'Pendientes de acero inoxidable con malaquita cerámica y ágata negra.', NULL, 'Stainless Steel\r\nMalaquite\r\nBlack Agata', NULL, 'Silver\r\nGreen\r\nBlack', 5, 1, 'Pendientes_Verdet_1.webp', 'earings'),
(47, 'Lil Amulet 004', 'Amuleto de acero inoxidable para decorar el móvil o llavero. Contiene un charm de mano de la suerte y cristales.', NULL, 'Stainless Steel\r\nHand Charm\r\nCrystal', NULL, 'Silver\r\nRed\r\nBlack', 4, 1, 'Lil_Amulet_004_1.webp', 'earings'),
(48, 'Lil Amulet 002', 'Amuleto con enganche para decorar móvil o llavero. Acero inoxidable. Incluye mano de la suerte y cuenta de coral blanco tintado.', NULL, 'Stainless Steel\r\nCoral Nacre Star\r\nHand Charm\r\n', NULL, 'Silver\r\nRed\r\nWhite', 4, 1, 'Lil_Amulet_002_1.webp', 'earings'),
(49, 'Lil Amulet 006', 'Amuleto para decorar el móvil o llavero. Contiene turquesa, nácar, turmalina y charm de metal en forma de corazón.', NULL, 'Stainless Steel\r\nCoral Nacre Star\r\nTurquoise Heart\r\n', NULL, 'Silver\r\nNacre\r\nTurquoise', 4, 1, 'Lil_Amulet_006_1.webp', 'earing');

-- --------------------------------------------------------

--
-- Table structure for table `respuesta`
--

CREATE TABLE `respuesta` (
  `id` bigint NOT NULL,
  `id_usuario` bigint NOT NULL,
  `respuesta` varchar(512) NOT NULL,
  `id_noticia` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint NOT NULL,
  `nombre` varchar(64) DEFAULT NULL,
  `apellidos` varchar(128) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `direccion` varchar(128) DEFAULT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(64) NOT NULL,
  `role` bit(1) NOT NULL,
  `email` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `apellidos`, `fecha_nacimiento`, `direccion`, `username`, `password`, `role`, `email`) VALUES
(1, 'Sergioo', 'Romero Alarcón', '1998-12-13', 'C/9 D\'Octubre', 'Xekos', '6901e6a15d3f209a482acc5e084e229efd70f392f0d1718ee2e2ff9a0691890f', b'0', 'sergioromeroalarcon2b@gmail.com'),
(18, 'Pepinillo', 'Romero Alarcón', '1998-12-12', 'C/9 D\'Octubre', 'lolilo', '6901e6a15d3f209a482acc5e084e229efd70f392f0d1718ee2e2ff9a0691890f', b'1', 'sergioromeroalarcon2b@gmail.com'),
(22, 'Enerlo', 'Pqpislo Apiscopa', '2001-03-10', 'C/9cSKSK csdS', 'Supercalifrago', '6901e6a15d3f209a482acc5e084e229efd70f392f0d1718ee2e2ff9a0691890f', b'1', 'ernilo@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detallepedido`
--
ALTER TABLE `detallepedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_documento` (`id_documento`) USING BTREE;

--
-- Indexes for table `documento`
--
ALTER TABLE `documento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indexes for table `noticia`
--
ALTER TABLE `noticia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_noticia_usuario` (`id_usuario`);

--
-- Indexes for table `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `respuesta`
--
ALTER TABLE `respuesta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_noticia` (`id_noticia`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detallepedido`
--
ALTER TABLE `detallepedido`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `documento`
--
ALTER TABLE `documento`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- AUTO_INCREMENT for table `noticia`
--
ALTER TABLE `noticia`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `producto`
--
ALTER TABLE `producto`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `respuesta`
--
ALTER TABLE `respuesta`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detallepedido`
--
ALTER TABLE `detallepedido`
  ADD CONSTRAINT `detallepedido_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`),
  ADD CONSTRAINT `detallepedido_ibfk_2` FOREIGN KEY (`id_documento`) REFERENCES `documento` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `documento`
--
ALTER TABLE `documento`
  ADD CONSTRAINT `documento_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);

--
-- Constraints for table `noticia`
--
ALTER TABLE `noticia`
  ADD CONSTRAINT `fk_noticia_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);

--
-- Constraints for table `respuesta`
--
ALTER TABLE `respuesta`
  ADD CONSTRAINT `respuesta_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `respuesta_ibfk_2` FOREIGN KEY (`id_noticia`) REFERENCES `noticia` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
