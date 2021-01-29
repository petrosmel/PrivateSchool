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
public class Trainer {

    private String firstName;
    private String lastName;
    private String subject;

//===========================Getters===========================//
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSubject() {
        return subject;
    }

//===========================Setters===========================//
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
//===========================Constructors===========================//

    public Trainer() {
    }

    public Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }
//===========================ToString===========================//

    @Override
    public String toString() {
        return "============================================================"+"\n"+"- FIRST NAME: " + firstName+ "\n"  + "- LAST NAME: " + lastName+ "\n"  + "- SUBJECT: " + subject;
    }

}
