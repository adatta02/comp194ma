
# This is a fix for InnoDB in MySQL >= 4.1.x
# It "suspends judgement" for fkey relationships until are tables are set.
SET FOREIGN_KEY_CHECKS = 0;

#-----------------------------------------------------------------------------
#-- user
#-----------------------------------------------------------------------------

DROP TABLE IF EXISTS `user`;


CREATE TABLE `user`
(
	`id` VARCHAR(32)  NOT NULL,
	`password` VARCHAR(36),
	`number_kills` INTEGER,
	`number_deaths` INTEGER,
	`games_played` INTEGER,
	`wins` INTEGER,
	`losses` INTEGER,
	`current_game_id` INTEGER,
	`latitude` VARCHAR(45),
	`longitude` VARCHAR(45),
	PRIMARY KEY (`id`),
	INDEX `FI_r_game` (`current_game_id`),
	CONSTRAINT `user_game`
		FOREIGN KEY (`current_game_id`)
		REFERENCES `game` (`id`)
)Type=InnoDB;

#-----------------------------------------------------------------------------
#-- game
#-----------------------------------------------------------------------------

DROP TABLE IF EXISTS `game`;


CREATE TABLE `game`
(
	`id` INTEGER  NOT NULL AUTO_INCREMENT,
	`start_time` DATETIME,
	`end_time` DATETIME,
	`active_players` INTEGER,
	`latitude` VARCHAR(45),
	`longitude` VARCHAR(45),
	`is_active` TINYINT,
	PRIMARY KEY (`id`)
)Type=InnoDB;

#-----------------------------------------------------------------------------
#-- target
#-----------------------------------------------------------------------------

DROP TABLE IF EXISTS `target`;


CREATE TABLE `target`
(
	`id` INTEGER  NOT NULL AUTO_INCREMENT,
	`from_user_id` VARCHAR(32),
	`to_user_id` VARCHAR(32),
	PRIMARY KEY (`id`),
	INDEX `FI_m_user_target` (`from_user_id`),
	CONSTRAINT `from_user_target`
		FOREIGN KEY (`from_user_id`)
		REFERENCES `user` (`id`),
	INDEX `FI_user_target` (`to_user_id`),
	CONSTRAINT `to_user_target`
		FOREIGN KEY (`to_user_id`)
		REFERENCES `user` (`id`)
)Type=InnoDB;

#-----------------------------------------------------------------------------
#-- game_member
#-----------------------------------------------------------------------------

DROP TABLE IF EXISTS `game_member`;


CREATE TABLE `game_member`
(
	`id` INTEGER  NOT NULL AUTO_INCREMENT,
	`user_id` VARCHAR(45),
	`game_id` INTEGER,
	`is_playing` TINYINT,
	PRIMARY KEY (`id`),
	INDEX `FI_e_member_user` (`user_id`),
	CONSTRAINT `game_member_user`
		FOREIGN KEY (`user_id`)
		REFERENCES `user` (`id`),
	INDEX `FI_e_member_game` (`game_id`),
	CONSTRAINT `game_member_game`
		FOREIGN KEY (`game_id`)
		REFERENCES `game` (`id`)
)Type=InnoDB;

# This restores the fkey checks, after having unset them earlier
SET FOREIGN_KEY_CHECKS = 1;
