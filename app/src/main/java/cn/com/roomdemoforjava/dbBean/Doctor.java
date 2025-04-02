package cn.com.roomdemoforjava.dbBean;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "DOCTOR")
public class Doctor implements IUnProguard {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Long id;
    @ColumnInfo(name = "IDCARD")
    private String idcard;
    @ColumnInfo(name = "NAME")
    private String name;
    @ColumnInfo(name = "GENDER")
    private int gender;//1男 2女
    @ColumnInfo(name = "DATE_OF_BIRTH")
    private String date_of_birth;
    @ColumnInfo(name = "ADDR")
    private String addr;
    @ColumnInfo(name = "PHONE")
    private String phone;
    @ColumnInfo(name = "STATUS")
    private int status;//0禁用 1启用
    @ColumnInfo(name = "RECORD_WAY")
    private int record_way;//0刷卡录入 1手工输入
    @ColumnInfo(name = "CREATE_TIME")
    private long create_time;
    @ColumnInfo(name = "UPDATE_TIME")
    private long update_time;
    @ColumnInfo(name = "LAST_LOGIN")
    private long last_login;
    @ColumnInfo(name = "SYNC")
    private int sync;
    @Ignore
    public String avatar;



    public Doctor() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDate_of_birth() {
        return this.date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddr() {
        return this.addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRecord_way() {
        return this.record_way;
    }

    public void setRecord_way(int record_way) {
        this.record_way = record_way;
    }

    public long getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    public long getLast_login() {
        return this.last_login;
    }

    public void setLast_login(long last_login) {
        this.last_login = last_login;
    }

    public int getSync() {
        return this.sync;
    }

    public void setSync(int sync) {
        this.sync = sync;
    }

}
