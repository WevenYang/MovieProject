# MovieProject
采用豆瓣接口的电影信息App

[TravelDiary](https://github.com/WevenYang/TravelDiary.git)的精简版本，剔除了社交功能，所有数据取自于豆瓣接口，app可以独立运行而不会因后台配置问题而报错。

主要功能：热门电影、待映电影、经典电影、附近影讯、电影搜索、电影信息、主创阵容详情等

### 主要技术
RxJAVA + Retrofit + MVP

### 主体界面
<img src="/img/hot_frag.jpg" width="250" height="450" /> <img src="/img/loading_frag.jpg" width="250" height="450" /> <img src="/img/classic_frag.jpg" width="250" height="450" />

### 信息详情
<img src="/img/detail_screenshot.jpg" width="250" height="450" /> <img src="/img/detail.jpg" width="250" height="450" />

### 搜索界面
<img src="/img/search.jpg" width="250" height="450" /> <img src="/img/search_result.jpg" width="250" height="450" />

### 不足之处

* 首页的三大板块，并没有缓存功能，导致滑动两次就会重新请求一次数据
* 没有上拉刷新和下拉加载功能

### 声明
本项目仅做技术交流使用，任何人或组织无论以何种形式将其用在其他任何地方由此引发的各种问题均与本人无关
