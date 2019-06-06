package com.t1708m.entity;

public class Student {

    private String username;
    private String password;
    private String email;
    private String fullName;
    private String address;
    private String phone;
    private int Statu;
    private int role;


    public enum Status {
        ACTIVE(1), DEACTIVE(0), DELETE(-1);

        private int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Status findByValue(int value) {
            for (Status status : Status.values()
            ) {
                if (status.getValue() == value) {
                    return status;
                }

            }
            return null;
        }
    }


    public Student() {
        this.username = "";
        this.password = "";
        this.email = "";
        this.fullName = "";
        this.address = "";
        this.phone = "";
        this.Statu = 1;
        this.role = 1;
    }

    public int getStatu() {
        return Statu;
    }

    public void setStatu(Status status) {
        if (status == null) {
            status = Status.DEACTIVE;
        }
        Statu = status.getValue();
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
