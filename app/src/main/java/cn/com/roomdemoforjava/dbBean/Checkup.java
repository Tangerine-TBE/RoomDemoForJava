package cn.com.roomdemoforjava.dbBean;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


/**
 * 查体数据
 */
@Entity(tableName = "CHECKUP")
public class Checkup implements IUnProguard {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Long id;
    @ColumnInfo(name = "TYPE")
    private int type;
    /// 1无创血压  2血糖  3心电图  4体温  5血氧饱和度 6尿常规
    @ColumnInfo(name = "PERSON")
    private String person;
    @ColumnInfo(name = "DOCTOR")
    private String doctor;
    @ColumnInfo(name = "VALUE")
    private String value;

    public Object getFollowUp() {
        return followUp;
    }

    public void setFollowUp(Object followUp) {
        this.followUp = followUp;
    }

    @ColumnInfo(name = "TIME")
    private long time;
    @ColumnInfo(name = "SYNC")
    private int sync;

    public String getFun() {
        return fun;
    }

    public void setFun(String fun) {
        this.fun = fun;
    }

    @ColumnInfo(name = "FUN")
    private String fun;
    /**
     * 数据同步后得到的反馈消息
     */

    @Ignore
    public String person_name;
    @Ignore
    public String doctor_name;
    @Ignore
    public Object followUp;


    public Checkup() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPerson() {
        return this.person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getDoctor() {
        return this.doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getSync() {
        return this.sync;
    }

    public void setSync(int sync) {
        this.sync = sync;
    }


}
