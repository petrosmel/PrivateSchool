/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschool;

import java.util.Date;

/**
 *
 * @author Desktop
 */
public class Course {

    private String title; // CB11, CB10, etc
    private String stream; // JAVA, C++,Python etc
    private String type; // Full time, part time
    private String startDate;
    private String endDate;

//===========================Getters===========================//
    public String getTitle() {
        return title;
    }

    public String getStream() {
        return stream;
    }

    public String getType() {
        return type;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
//===========================Setters===========================//

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

//===========================Constructors===========================//
    public Course() {
    }

    public Course(String title, String stream, String type, String startDate, String endDate) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }
//===========================toString===========================//

    @Override
    public String toString() {
        return "============================================================"+"\n"+"- TITLE: " + title + "\n" + "- STREAM: " + stream + "\n" + "- TYPE: " + type + "\n" + "- START DATE: " + startDate + "\n" + "- END DATE: " + endDate;
    }

}
