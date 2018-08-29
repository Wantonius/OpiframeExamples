package com.opiframe.android.listviewandadapter;

import android.net.Uri;
import android.provider.BaseColumns;

public class Contact implements BaseColumns {

    private int id;
    private String firstName;
    private String lastName;
    private String title;
    private String address;
    private String email;
    private String phone;

    public static final String FIRST_NAME = "firstname";
    public static final String LAST_NAME = "lastname";
    public static final String TITLE = "title";
    public static final String ADDRESS = "address";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";

    public static final Uri CONTENT_URI =
            Uri.parse("content://com.opiframe.android.listviewandadapter.ContactCardProvider/Contact");

    public static final String CONTENT_TYPE="vnd.android.cursor.dir/com.opiframe.android.Contact";

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
