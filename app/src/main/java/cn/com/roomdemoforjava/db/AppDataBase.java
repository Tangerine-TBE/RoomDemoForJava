package cn.com.roomdemoforjava.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import cn.com.roomdemoforjava.dbBean.Checkup;
import cn.com.roomdemoforjava.dbBean.Doctor;
import cn.com.roomdemoforjava.dbBean.Person;
import cn.com.roomdemoforjava.dbBean.Report;


@Database(entities = {Checkup.class, Person.class, Doctor.class, Report.class}, version = 3)
public abstract class AppDataBase extends RoomDatabase {
    public static final String DB_FILE_NAME = "di_health.db";
    public static boolean dbInit = false;
    private static volatile AppDataBase mAppDatabase;

    // TODO 在实例化 AppDatabase 对象时应遵循单例设计模式。每个 RoomDatabase 实例的成本相当高，几乎不需要在单个进程中访问多个实例。
    public static AppDataBase getInstance(Context context) {
        if (mAppDatabase == null) {
            synchronized (AppDataBase.class) {
                if (mAppDatabase == null) {
                    mAppDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "di_health.db")
                            .addMigrations(MIGRATION_1_2)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        dbInit = true;
        return mAppDatabase;
    }
    static final Migration MIGRATION_1_2 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // 添加fun字段
            database.execSQL("ALTER TABLE CHECKUP ADD COLUMN FUN TEXT");
        }
    };
   public   abstract DaoLinker daoLinker();
}
