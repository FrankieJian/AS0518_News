package com.example.g572_528r.as0518_news.data;

import cn.bmob.v3.BmobObject;

/**
 * Created by g572-528r on 2017/5/23.
 */
public class CommentData extends BmobObject{
    private String phone;
    private String content;
    private String newsKey;
    private String newsTitle;
    private boolean isDel;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNewsKey() {
        return newsKey;
    }

    public void setNewsKey(String newsKey) {
        this.newsKey = newsKey;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }
}
