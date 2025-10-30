package org.eg.AddressBookSystem;

public class Person {
    String first_name;
    String last_name;
    String phone_number;
    String email;

    public Person(String first_name,String last_name, String email, String phone_number){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "First Name: "+first_name +
                "\n"+"Last Name: "+last_name
                +"\n"+"Email: "+email
                +"\n"+"Phone Number: "+phone_number;
    }

}
