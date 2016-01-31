SET NAMES utf8;
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `user`; 
CREATE TABLE `user`(
    `uid` int(11) NOT NULL AUTO_INCREMENT,
    `email`    text,
    `username` text,
    `nickname` text,
    `imagesrc` text,
    `registetime` timestamp,
     PRIMARY KEY (`uid`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`(
    `shopid` int(11) NOT NULL AUTO_INCREMENT,
    `shopname` text,
    `imagesrc` text,
    `shopkeywords` text,
    `uid` int(11),-- owner
    `longtitude` decimal(10,7),
    `latitude` decimal(10,7),
    PRIMARY KEY(`shopid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`(
    `goodsid` int(11) NOT NULL AUTO_INCREMENT,
    `goodsname` text,
    `classid` int(11),
    `imagesrc` text,
    PRIMARY KEY(`goodsid`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`(
    `classid` int(11),
    `classname` text,
    `unit` text,
    PRIMARY KEY(classid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `shopcar`;
CREATE TABLE `shopcar`(
    `carid` int(11) NOT NULL AUTO_INCREMENT,
    `userid` int(11),
    `goodsid` int(11),
    `addtime` timestamp NOT NULL,
    `stateid` int(11),
    PRIMARY KEY(carid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `state`;
CREATE TABLE `state`(
    `stateid` int(11),
    `statename` text,
    `stateinfo` text,
    PRIMARY KEY(stateid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
