-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 10 mai 2024 à 18:31
-- Version du serveur : 5.7.24
-- Version de PHP : 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `warehouse`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `nom`) VALUES
(2, 'shoes'),
(4, 'drink'),
(5, 'makeup'),
(6, 'PC'),
(7, 'accessoires'),
(8, 'fruits'),
(16, 'legumes'),
(17, 'téléphones'),
(18, 'maquillage'),
(19, 'chapeaux'),
(20, 'draps'),
(21, 'couvertures'),
(22, 'assiettes'),
(23, 'bijoux'),
(24, 'lampes'),
(25, 'verres'),
(26, 'lits'),
(27, 'parfums'),
(28, 'sacs');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `mail` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `adresse`, `phone`, `mail`) VALUES
(2, 'mimi', 'Oran', '066505899', 'mimi@mail.com'),
(5, 'Lilly', 'Alger', '07759302', 'lilly@mail.com');

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

DROP TABLE IF EXISTS `fournisseur`;
CREATE TABLE IF NOT EXISTS `fournisseur` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  `numero` int(50) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`id`, `nom`, `adresse`, `numero`, `mail`) VALUES
(1, 'Andrea', 'milan', 2588625, 'and@gmail.com'),
(2, 'melissa', 'a', 6, 'm'),
(3, 'amira', 'ttt', 77778, 'iii'),
(4, 'Nina', 'aa', 7777, 'le');

-- --------------------------------------------------------

--
-- Structure de la table `images`
--

DROP TABLE IF EXISTS `images`;
CREATE TABLE IF NOT EXISTS `images` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`image_id`),
  KEY `fk_images_produits` (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `images`
--

INSERT INTO `images` (`image_id`, `product_id`, `image_path`) VALUES
(1, 8, 'C:\\Users\\DELL-10\\Downloads\\icons8-hide-password-24 (1).png'),
(2, 9, 'C:\\Users\\DELL-10\\Downloads\\icons8-order-64.png'),
(3, 9, 'C:\\Users\\DELL-10\\Downloads\\icons8-profit-64.png'),
(22, 5, 'C:\\Users\\DELL-10\\Downloads\\fruit.png'),
(20, 4, 'C:\\Users\\DELL-10\\Downloads\\apple.png'),
(7, 11, 'C:\\Users\\DELL-10\\Downloads\\icons8-hide-password-24 (1).png'),
(27, 6, 'C:\\Users\\DELL-10\\Downloads\\orange.png'),
(19, 3, 'C:\\Users\\DELL-10\\Downloads\\apple.png'),
(25, 2, 'C:\\Users\\DELL-10\\Downloads\\drink.png'),
(17, 10, 'C:\\Users\\DELL-10\\Downloads\\Blank Network Diagram(2).png'),
(16, 10, 'C:\\Users\\DELL-10\\Downloads\\algeria-2284278_1920.jpg'),
(28, 7, 'C:\\Users\\DELL-10\\Downloads\\verre.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `order_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `quantity` int(11) DEFAULT NULL,
  `total_amount` decimal(10,2) DEFAULT NULL,
  `statut` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `client_id` (`client_id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `orders`
--

INSERT INTO `orders` (`id`, `product_id`, `client_id`, `user_id`, `order_date`, `quantity`, `total_amount`, `statut`) VALUES
(1, 4, 2, 1, '2024-02-29 16:45:18', 5, '990.00', 'sold'),
(2, 5, 2, 1, '2024-04-02 13:31:32', 5, '1300.00', 'sold'),
(3, 6, 2, 1, '2024-04-06 08:13:44', 10, '16500.00', 'sold'),
(4, 2, 2, 1, '2024-04-06 15:18:39', 1, '120.00', 'sold'),
(22, 2, 2, 1, '2024-04-14 15:39:19', 2, '240.00', 'accepted'),
(23, 5, 5, 1, '2024-04-14 15:41:47', 2, '260.00', 'pending'),
(20, 2, 2, 1, '2024-04-14 15:32:30', 4, '480.00', 'rejected'),
(21, 2, 2, 1, '2024-04-14 15:34:10', 4, '480.00', 'sold');

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

DROP TABLE IF EXISTS `produits`;
CREATE TABLE IF NOT EXISTS `produits` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `categorie` int(50) DEFAULT NULL,
  `fournisseur` int(50) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `prixv` double DEFAULT NULL,
  `qt` int(50) DEFAULT NULL,
  `code` int(50) DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foreign1` (`categorie`),
  KEY `foreign2` (`fournisseur`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produits`
--

INSERT INTO `produits` (`id`, `nom`, `categorie`, `fournisseur`, `prix`, `prixv`, `qt`, `code`, `image`, `description`) VALUES
(2, 'coca', 4, 1, 100, 120, 4, 7527, 'hdhd', NULL),
(4, 'pomme', 8, 3, 300, 330, 4, 99999, 'ab', NULL),
(5, 'Citron', 8, 3, 110, 130, 0, 2222, 'a', NULL),
(6, 'orangee', 8, 1, 300, 330, 30, 222, 'a', NULL),
(7, 'verre d\'eau', 25, 4, 320, 400, 3, 4587756, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `transaction_history`
--

DROP TABLE IF EXISTS `transaction_history`;
CREATE TABLE IF NOT EXISTS `transaction_history` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `transaction_type` varchar(50) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `transaction_date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `notes` text,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `fk_transaction_history_product` (`product_id`),
  KEY `fk_transaction_history_user` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `mdp` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `remember_me` tinyint(1) DEFAULT NULL,
  `numero` varchar(50) DEFAULT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `username`, `mdp`, `role`, `nom`, `prenom`, `email`, `remember_me`, `numero`, `adresse`) VALUES
(1, 'admin', 'admin', 'admin', 'Grine', 'Amina', 'amina@myinventory.com', 1, '', ''),
(3, 'user2', 'a', NULL, 'na', 'lili', 'lili@mail.com', NULL, '0444', 'alger');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `produits`
--
ALTER TABLE `produits`
  ADD CONSTRAINT `foreign1` FOREIGN KEY (`categorie`) REFERENCES `categorie` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `foreign2` FOREIGN KEY (`fournisseur`) REFERENCES `fournisseur` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
