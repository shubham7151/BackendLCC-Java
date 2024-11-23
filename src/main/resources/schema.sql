CREATE TABLE IF NOT EXISTS `USER_T` (
    `user_id` int AUTO_INCREMENT PRIMARY KEY,
    `firstName` varchar(100) NOT NULL,
    `lastName` varchar(100) NOT NULL,
    `email` varchar(100) NOT NULL,
    `info` varchar(100),
    `imageURL` varchar(100),
    `position` varchar(100) NOT NULL,
    `created_at` date NOT NULL,
    `created_by` varchar(20) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` date DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    `updated_by` varchar(20) DEFAULT NULL
);
