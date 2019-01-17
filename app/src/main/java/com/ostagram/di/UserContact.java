package com.ostagram.di;

import javax.inject.Inject;

public class UserContact {

    Contact contact;

    @Inject
    public UserContact(Contact contact) {
        this.contact = contact;
    }

    public void deleteEmail() {
        contact.deleteEmail();
    }

    public void setUserEmail(String email) {
        contact.setEmail(email);
    }

    public String getUserEmail() {
        return contact.getEmail();
    }

    public void print(){
        contact.print();
    }


}
