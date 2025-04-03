package cn.com.roomdemoforjava;

import android.content.Context;


import com.alibaba.fastjson.JSONObject;

import java.util.List;

import cn.com.roomdemoforjava.db.AppDataBase;
import cn.com.roomdemoforjava.db.DaoLinker;
import cn.com.roomdemoforjava.dbBean.Checkup;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class DaoTool {
    public static DaoLinker daoLinker;

    static void init(Context context) {
        daoLinker = AppDataBase.getInstance(context)
                .daoLinker();
    }
    public static Observable<String> getRecentWeightInfo(String idCard) {
        return daoLinker.getRecentWeightInfo(idCard)
                .subscribeOn(Schedulers.io())
                .map(checkups -> {
                    if (!checkups.isEmpty()) {
                        Checkup checkUp = checkups.get(0);
                        String weight = "";
                        String height = "";
                        int type = checkUp.getType();
                        if (type == 15 || type == 17 || type == 23 || type == 19) {
                            JSONObject jsonObject = JSONObject.parseObject(checkUp.getValue());
                            weight = jsonObject.getString("weight");
                            height = jsonObject.getString("height");
                        } else if (type == 29) {
                            JSONObject jsonObject = JSONObject.parseObject(checkUp.getValue());
                            weight = jsonObject.getString("ppWeightKg");
                            height = jsonObject.getString("ppHeightCm");
                        }
                        return weight + "/" + height;
                    }
                    return "";
                })
                .observeOn(AndroidSchedulers.mainThread());
    }
}
