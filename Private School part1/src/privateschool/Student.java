/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschool;

/**
 *
 * @author Desktop
 */
public class Student {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private float tuitionFees;

//===========================Getters===========================//
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public float getTuitionFees() {
        return tuitionFees;
    }
//===========================Setters===========================//

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setTuitionFees(float tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

//===========================Constructors===========================//
    public Student() {
    }

    public Student(String firstName, String lastName, String dateOfBirth, float tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;

    }

    //===========================toString===========================//
    @Override
    public String toString() {
        return "============================================================"+"\n"+"- FIRST NAME: " + firstName+ "\n"  + "- LAST NAME: " + lastName+ "\n"  + "- DATE OF BIRTH: " + dateOfBirth+ "\n"  + "- TUITION FEES: € " + tuitionFees;
    }

}
