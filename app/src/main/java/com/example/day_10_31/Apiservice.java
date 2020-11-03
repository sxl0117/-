package com.example.day_10_31;

import com.example.day_10_31.bean.CommentBean;
import com.example.day_10_31.bean.ShiBean;
import com.example.day_10_31.bean.TextBean;
import com.example.day_10_31.bean.TuiBean;
import com.example.day_10_31.bean.TwoShiBean;
import com.example.day_10_31.bean.XShiBean;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Apiservice {
    String STRING = "http://123.56.232.18:8080/serverdemo/";
    //@POST
    //@FormUrlEncoded
    //Observer<CommentBean> getdata();
    //http://123.56.232.18:8080/serverdemo/tag/queryTagList  推荐的

    @GET("tag/queryTagList")
    Observable<TuiBean> getTui();

    //http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList
    @GET("feeds/queryHotFeedsList")
    Observable<ShiBean> getShi();

    //http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics&feedId=0&userId=0
    @GET("feeds/queryHotFeedsList?pageCount=12&feedType=pics&feedId=0&userId=0")
    Observable<TwoShiBean> getTwoShi();

    //http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275&userId=0
    @GET("feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275&userId=0")
    Observable<TextBean> getText();

    //http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video&feedId=0&userId=0
    @GET("feeds/queryHotFeedsList?pageCount=12&feedType=video&feedId=0&userId=0")
    Observable<XShiBean> getXshi();
}
