package cn.com.roomdemoforjava.dbBean;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "PERSON",indices = {@Index(value = "IDCARD",unique = true,name = "uniq_id_num")})
public class Person implements IUnProguard {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Long id;
    @ColumnInfo(name = "IDCARD")
    private String idcard;
    @ColumnInfo(name = "HEALTH_CARD")
    private String health_card;
    @ColumnInfo(name = "NAME")
    private String name;
    @ColumnInfo(name = "GENDER")
    private int gender;//1男 2女
    @ColumnInfo(name = "DATE_OF_BIRTH")
    private String date_of_birth;
    @ColumnInfo(name = "NATION")
    private String nation;
    @ColumnInfo(name = "ADDR")
    private String addr;
    @ColumnInfo(name = "PHONE")
    private String phone;
    @ColumnInfo(name = "STATUS")
    private int status;//0禁用 1启用
    @ColumnInfo(name = "RECORD_WAY")
    private int record_way;//0刷卡录入 1手工输入
    @ColumnInfo(name = "HEALTH_DOC")
    private String health_doc;
    @ColumnInfo(name = "CREATE_TIME")
    private long create_time;
    @ColumnInfo(name = "CREATE_DOCTOR")
    private String create_doctor;
    @ColumnInfo(name = "UPDATE_TIME")
    private long update_time;
    @ColumnInfo(name = "UPDATE_DOCTOR")
    private String update_doctor;
    @ColumnInfo(name = "SYNC")
    private int sync;
    @Ignore
    public String avatar;


    public Person() {
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

    public String getHealth_card() {
        return this.health_card;
    }

    public void setHealth_card(String health_card) {
        this.health_card = health_card;
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

    public String getNation() {
        return this.nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
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

    public String getHealth_doc() {
        return this.health_doc;
    }

    public void setHealth_doc(String health_doc) {
        this.health_doc = health_doc;
    }

    public long getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public String getCreate_doctor() {
        return this.create_doctor;
    }

    public void setCreate_doctor(String create_doctor) {
        this.create_doctor = create_doctor;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    public String getUpdate_doctor() {
        return this.update_doctor;
    }

    public void setUpdate_doctor(String update_doctor) {
        this.update_doctor = update_doctor;
    }

    public int getSync() {
        return this.sync;
    }

    public void setSync(int sync) {
        this.sync = sync;
    }
}
