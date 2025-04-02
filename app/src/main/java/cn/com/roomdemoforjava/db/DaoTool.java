package cn.com.roomdemoforjava.db;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import cn.com.roomdemoforjava.dbBean.Checkup;
import cn.com.roomdemoforjava.dbBean.Person;

@Dao
public interface DaoTool {
    @Query("select * from CHECKUP")
    public List<Checkup> queryCheckUp();
    @Query("select * from PERSON")
    public List<Person> queryPerson();
    @Query("select * from PERSON where name like :name")
    public List<Person> queryPerson(String name);

}
