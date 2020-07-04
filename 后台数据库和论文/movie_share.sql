-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2020-07-04 10:20:29
-- 服务器版本： 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `movie_share`
--

-- --------------------------------------------------------

--
-- 表的结构 `admin_info`
--

CREATE TABLE `admin_info` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `admin_info`
--

INSERT INTO `admin_info` (`id`, `name`, `password`) VALUES
(0, 'weven', '123456');

-- --------------------------------------------------------

--
-- 表的结构 `movie_comment`
--

CREATE TABLE `movie_comment` (
  `id` int(11) NOT NULL,
  `info_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  `comment` text NOT NULL,
  `c_date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `movie_comment`
--

INSERT INTO `movie_comment` (`id`, `info_id`, `author_id`, `comment`, `c_date`) VALUES
(1, 7, 2, '这是一条测试评论', '2019年11月8日23:55:44'),
(2, 1, 1, '这又是一条评论', '2019年11月10日22:34:40'),
(3, 7, 1, '123', '');

-- --------------------------------------------------------

--
-- 表的结构 `movie_info`
--

CREATE TABLE `movie_info` (
  `id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  `title` text NOT NULL,
  `content` text NOT NULL,
  `img` text NOT NULL,
  `fav` int(11) NOT NULL,
  `time` text NOT NULL,
  `m_pass` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `movie_info`
--

INSERT INTO `movie_info` (`id`, `author_id`, `title`, `content`, `img`, `fav`, `time`, `m_pass`) VALUES
(1, 1, '《招魂》为何会在恐怖片中大放异彩？', '《招魂》为何会在恐怖片中大放异彩？温氏恐怖占据了大头\r\n\r\n在欧美的恐怖片之中，血腥以及非常恐怖的营销范围是十分常见的。然而这样的恐怖片却令观众们感到审美疲劳。\r\n\r\n然而作为华人所导演的东方色彩电影现在这样的氛围之下，带来了不一样的感受。小编今天就来和大家一起探讨一下这个恐怖的电影吧。\r\n既然提到了招魂，那么就不得不提起这一位华人导演。我们的温导身为华人，便将东方的吓人方式进行了精彩的呈现。而在这期间又添加了来自于西方的恐怖手法，使得整个电影呈现出来的氛围十分的可怕与精彩。\r\n\r\n当人们看惯了血浆像是不要钱般的泼洒，电影的色调变得越发的昏暗，伴随着那种可怕的印象，使得观众们的第一印象就是在讲笑话的同时在挠你的痒痒肉一般。\r\n\r\n这样的机械式恐怖使得观众们在初期的惊奇过后，变得越来越麻木。而我们的温导则是在这样的氛围之下，将恐怖场景带动人们紧张刺激情绪的方式融入到了西式电影之中。', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577121835044&di=2171375c506f512467f9ddf46c2bc5c2&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Fsinacn%2Fw1597h1065%2F20180115%2F4cad-fyqrewi2316231.jpg', 0, '2019年10月23日23:08:46', 1),
(2, 1, '复联4是打情怀牌吗？', '  前20分钟真的以为罗素兄弟要捧出什么好菜，适量精准的文戏和反高潮的设置让我眼前一亮。然后电影就进入了前所未有的格外冗长的英雄重聚段落，紧接着是打着红旗反红旗的罔顾所有悖论的时空旅行。时间线变得空前混乱，拯救世界变得空前儿戏，好莱坞大片标准模式化叙事卷土重来。当生命变成某种可以轻易篡改的东西，它的诞生或者逝去就不会对观众产生丝毫情感冲击。这也就是为什么片末所谓史诗对决还是被世纪初的《指环王》吊打。所以，21部电影的铺垫，媒体的造神运动和公众的趋之若鹜，开启的不过是一场极度粉丝向的闹剧，一次对青春和情怀的过度消费，一次漫威宇宙的自我致敬/重复，一次超级英雄电影彻底暴露其娱乐商品属性的全民跟风运动。在零点场的抽泣、欢呼和掌声里，我感到自己是个彻底的局外人，是时候警惕创作者对荷尔蒙居高临下的操控了', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577121668497&di=8616abb1e0a216283b0d0f097f9dfe9d&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Fsinacn21%2F405%2Fw798h407%2F20180901%2Fefe3-hinpmnr5400765.jpg', 0, '2019年12月23日22:38:22', 1),
(4, 0, '1', '222222', '', 0, '', 0),
(5, 0, '2222', '2222', 'https://timgsa.baidu.com/timg?image&amp;quality=80&amp;size=b9999_10000&amp;sec=1573581286150&amp;di=7a367b9326f0cc64b900c7946a4ad041&amp;imgtype=0&amp;src=http%3A%2F%2Fwx1.sinaimg.cn%2Fwap720%2Fa46e3d25ly1femgg8mhgrj21ad0qoq7r.jpg', 0, '', -1),
(6, 0, '66', '66666', 'https://timgsa.baidu.com/timg?image&amp;quality=80&amp;size=b9999_10000&amp;sec=1573581286150&amp;di=7a367b9326f0cc64b900c7946a4ad041&amp;imgtype=0&amp;src=http%3A%2F%2Fwx1.sinaimg.cn%2Fwap720%2Fa46e3d25ly1femgg8mhgrj21ad0qoq7r.jpg', 0, '', 1),
(7, 1, '我是标题', '444', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577599166750&di=246a10e10eb523078d19c00107b54346&imgtype=0&src=http%3A%2F%2Fimg2.moko.cc%2Fusers%2F0%2F35%2F10534%2Fpost%2Fff%2Fimg2_src_10601702.jpg', 0, '2019-11-12 23:40:12', 1),
(8, 1, 'fabiao', '23f23fdasf23r2', 'https://timgsa.baidu.com/timg?image&amp;quality=80&amp;size=b9999_10000&amp;sec=1573581286150&amp;di=7a367b9326f0cc64b900c7946a4ad041&amp;imgtype=0&amp;src=http%3A%2F%2Fwx1.sinaimg.cn%2Fwap720%2Fa46e3d25ly1femgg8mhgrj21ad0qoq7r.jpg', 0, '2019-12-29 10:38:37', 1);

-- --------------------------------------------------------

--
-- 表的结构 `people_info`
--

CREATE TABLE `people_info` (
  `p_id` int(11) NOT NULL,
  `cell_phone` text NOT NULL,
  `password` text NOT NULL,
  `nick_name` text NOT NULL,
  `pic` text NOT NULL,
  `sex` int(11) NOT NULL,
  `introduce` text NOT NULL,
  `date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `people_info`
--

INSERT INTO `people_info` (`p_id`, `cell_phone`, `password`, `nick_name`, `pic`, `sex`, `introduce`, `date`) VALUES
(1, '123', '123', 'weven', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573411735731&di=6d384c53fb80e6ca8a8cf542f112ccb9&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F23%2F20160723143134_W82sw.jpeg', 1, '一个没有感情的观众', '2019年10月25日22:37:01'),
(2, '', '123', 'Yang', '', 0, '', ''),
(3, '', '123', 'Yang', '', 0, '', ''),
(4, '', '123', 'Yang', '', 0, '', ''),
(5, '', '123', 'Yang', '', 0, '', ''),
(6, '', '123', 'Yang', '', 0, '', ''),
(7, '', '123', 'Yang', '', 0, '', ''),
(8, '', '123', 'Yang', '', 0, '', ''),
(9, '', '123', 'Yang', '', 0, '', ''),
(10, '', '123456', 'yang', '', 0, '', ''),
(11, '', '123456', 'yang', '', 0, '', ''),
(12, '', '234567', '5555555', '', 0, '', ''),
(13, '12345578901', '123456', 'yang', '', 0, '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movie_comment`
--
ALTER TABLE `movie_comment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `movie_info`
--
ALTER TABLE `movie_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `people_info`
--
ALTER TABLE `people_info`
  ADD PRIMARY KEY (`p_id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `movie_comment`
--
ALTER TABLE `movie_comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- 使用表AUTO_INCREMENT `movie_info`
--
ALTER TABLE `movie_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- 使用表AUTO_INCREMENT `people_info`
--
ALTER TABLE `people_info`
  MODIFY `p_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
