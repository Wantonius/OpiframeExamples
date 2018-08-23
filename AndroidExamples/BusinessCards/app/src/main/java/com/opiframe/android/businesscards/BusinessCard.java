package com.opiframe.android.businesscards;

import android.net.Uri;
import android.provider.BaseColumns;

public class BusinessCard implements BaseColumns {

    private int id;
    private String firstName;
    private String lastName;
    private String title;
    private String phone;
    private String company;

    public static final String FIRST_NAME="firstname";
    public static final String LAST_NAME="lastname";
    public static final String TITLE="title";
    public static final String PHONE="phone";
    public static final String COMPANY="company";

    public static final Uri CONTENT_URI =
    Uri.parse("content://com.opiframe.android.businesscard.BusinessCardProvider/BusinessCard");

    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/com.opiframe.android.BusinessCard";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    @Override
    public String toString() {
        return "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company;
    }
}
