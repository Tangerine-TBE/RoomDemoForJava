package cn.com.roomdemoforjava.db;

import androidx.room.Dao;
import androidx.room.Query;

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

}
