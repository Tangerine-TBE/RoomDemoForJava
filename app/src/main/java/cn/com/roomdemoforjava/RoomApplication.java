package cn.com.roomdemoforjava;

import android.app.Application;

import cn.com.roomdemoforjava.db.AppDataBase;

public class RoomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ///与随访包同步的DaoTool方法
        DaoTool.init(this);
    }
}
