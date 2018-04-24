package com.example.administrator.traveldiary.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by NewHT on 2016/12/3.
 */
public class TimeUtil {

    public static TimeUtil newInstance() {
        return new TimeUtil();
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public String getTime() {
        String CurrentTime;
        Date date = new Date();// 创建一个时间对象，获取到当前的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置时间显示格式
        CurrentTime = sdf.format(date);

        return CurrentTime;
    }
}
