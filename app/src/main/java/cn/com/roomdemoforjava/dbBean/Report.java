package cn.com.roomdemoforjava.dbBean;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName ="REPORT" )
public class Report implements IUnProguard {

    @PrimaryKey(autoGenerate = true )
    @ColumnInfo(name = "_id")
    private Long id;
    @ColumnInfo(name = "PERSON")
    private String person;
    @ColumnInfo(name = "DOCTOR")
    private String doctor;
    @ColumnInfo(name = "TIME")
    private long time;
    @ColumnInfo(name = "CHECKUPS")
    private String checkups;
    @ColumnInfo(name = "COMMENT")
    private String comment;
    @ColumnInfo(name = "SYNC")
    private int sync;

    @Ignore
    public String doctor_name;



    public Report() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public long getTime() {
        return this.time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getCheckups() {
        return this.checkups;
    }

    public void setCheckups(String checkups) {
        this.checkups = checkups;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getSync() {
        return this.sync;
    }

    public void setSync(int sync) {
        this.sync = sync;
    }


}
