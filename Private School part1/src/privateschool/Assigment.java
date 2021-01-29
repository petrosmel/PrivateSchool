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
public class Assigment {

    private String title;
    private String description;
    private String subDateTime;
    private int oralMark;
    private int totalMark;

//===========================Getters===========================//
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSubDateTime() {
        return subDateTime;
    }

    public int getOralMark() {
        return oralMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

//===========================Setters===========================//
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSubDateTime(String subDateTime) {
        this.subDateTime = subDateTime;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

//===========================Constructors===========================//
 public Assigment(){
 }

    public Assigment(String title, String description, String subDateTime, int oralMark, int totalMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }
//===========================toString===========================//

    @Override
    public String toString() {
        return "============================================================"+"\n"+"- TITLE: " + title+ "\n"  + "- DESCRPTION: " + description+ "\n"  + "- SUBMITION DATE: " + subDateTime+ "\n"  + "- ORAL MARK: " + oralMark+ "\n"  + "- TOTAL MARK: " + totalMark;
    }
    
}
