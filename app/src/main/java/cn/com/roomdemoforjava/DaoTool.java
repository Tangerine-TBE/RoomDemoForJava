package cn.com.roomdemoforjava;

import static cn.com.roomdemoforjava.db.AppDataBase.DB_FILE_NAME;

import android.content.Context;
import android.database.Cursor;


import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
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
    private static final String TAG = "DaoTool";
    private static String builder = "{";

    public static DaoLinker daoLinker;
    private static String glu = "餐前:/餐后:";

    public static final String DB_FILE_NAME = "di_health.db";
    public static final String DB_FILE_JUST_NAME = "di_health";


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

    public static Cursor listHuman(int type){
        return daoLinker.listHuman(type);
    }


//    private static void copyDbFromAssets(Context context) {
//        File outFile = context.getDatabasePath(DB_FILE_NAME);
//        if (!outFile.exists()) {
//            try {
//                InputStream is = context.getAssets().open(DB_FILE_NAME);
//                FileOutputStream fos = new FileOutputStream(outFile);
//                byte[] buffer = new byte[1024];
//                int byteCount;
//                while ((byteCount = is.read(buffer)) != -1) {
//                    fos.write(buffer, 0, byteCount);
//                }
//                fos.flush();
//                is.close();
//                fos.close();
////                T.t("复制数据库成功");
//            } catch (Exception e) {
//                e.printStackTrace();
////                T.t("复制数据库失败");
//            }
//
//            if (BuildConfig.DEBUG) {
//                String[] ecgFiles = new String[]{"-20181007105220.jpeg", "-20181007105220.xml", "-20181007105939.jpeg", "-20181007105939.xml"};
//                for (String fileName : ecgFiles) {
//                    if (fileName.endsWith(".jpeg")) {
//                        File path = new File(FileUtil.getSdcardPath("ECGDATA/JPEG/"));
//                        if (!path.exists()) {
//                            path.mkdirs();
//                        }
//                        outFile = new File(path, fileName);
//                    } else if (fileName.endsWith(".xml")) {
//                        File path = new File(FileUtil.getSdcardPath("ECGDATA/XML/"));
//                        if (!path.exists()) {
//                            path.mkdirs();
//                        }
//                        outFile = new File(path, fileName);
//                    }
//                    if (!outFile.exists()) {
//                        try {
//                            InputStream is = context.getAssets().open(fileName);
//                            FileOutputStream fos = new FileOutputStream(outFile);
//                            byte[] buffer = new byte[1024];
//                            int byteCount;
//                            while ((byteCount = is.read(buffer)) != -1) {
//                                fos.write(buffer, 0, byteCount);
//                            }
//                            fos.flush();
//                            is.close();
//                            fos.close();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }
//    }

}
