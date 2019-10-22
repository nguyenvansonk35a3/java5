package edu.nguyenvanson.domain;

public class Record {

    private String idRecord;
    private String type;
    private String reason;
    private String date;
    private Staff staff;

    public Record() {
    }

    public Record(String idRecord, String type, String reason, String date, Staff staff) {
        this.idRecord = idRecord;
        this.type = type;
        this.reason = reason;
        this.date = date;
        this.staff = staff;
    }

    

    public String getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(String idRecord) {
        this.idRecord = idRecord;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    

}
