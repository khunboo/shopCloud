package com.khunboo.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class DateUtils {

    public static Logger logger = LoggerFactory.getLogger(DateUtils.class);


    public static String getAllTime(){
        return formatDate(new Date(), "yyyyMMddHHmmss");
    }

    public static String formatDate(Date date, String pattern){

        String formatDate = null;
        if(StringUtils.isNotBlank(pattern)){
            formatDate = DateFormatUtils.format(date, pattern);
        } else{
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }

        return formatDate;
    }

}
