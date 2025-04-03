package cn.com.roomdemoforjava.db;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.List;

import cn.com.roomdemoforjava.dbBean.Checkup;
import cn.com.roomdemoforjava.dbBean.Person;
import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface DaoLinker {
    @Query("select * from CHECKUP")
    public List<Checkup> queryCheckUp();
    @Query("select * from PERSON")
    public List<Person> queryPerson();
    @Query("select * from PERSON where name like :name")
    public List<Person> queryPerson(String name);
    @Query("select *  from CHECKUP where type = 15 or type = 17 or type = 23 or type = 29 or type = 19 and person = :idCard order by time")
    Observable<List<Checkup>> getRecentWeightInfo(String idCard);

    @RawQuery
    Cursor listHuman(SupportSQLiteQuery query);

    default Cursor listHuman(int type) {
        String tableName = type == 1 ? "PERSON" : "DOCTOR";
        String sql = "SELECT _id, IDCARD, NAME FROM " + tableName +
                " WHERE STATUS = 1 ORDER BY IDCARD";
        return listHuman(new SimpleSQLiteQuery(sql));
    }

}
