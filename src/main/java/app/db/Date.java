package app.db;

import java.io.Serializable;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    public Date(int d, int m, int y) {
        this.day = d;
        this.month = m;
        this.year = y;
    }

    public Date(Date d) {
        this.day = d.day;
        this.month = d.month;
        this.year = d.year;
    }

    public int getDifference(Date date){
        if((this.getYear()-date.getYear())!=0){
            System.out.println(this.getYear()-date.getYear());
            return (this.getYear()-date.getYear());
        }
        else if(this.getMonth()-date.getMonth()!=0){
            return (this.getMonth()-date.getMonth());
        }
        else return (this.getDay()-date.getDay());

    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return ("" + day +" / " + month +" / " + year );
    }


}
