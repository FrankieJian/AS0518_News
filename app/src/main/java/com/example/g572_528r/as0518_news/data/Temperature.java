package com.example.g572_528r.as0518_news.data;

import java.util.Date;

/**
 * Created by g572-528r on 2017/6/2.
 */

public class Temperature {
    public   int low;
    public  int high;
    public Date mDate;

    public Temperature(int low, int high, Date mDate) {
        this.high = high;
        this.low = low;
        this.mDate = mDate;
    }
}
