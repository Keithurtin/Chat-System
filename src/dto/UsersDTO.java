package dto;

import java.sql.*;
import java.time.LocalDateTime;

public class UsersDTO {
    int uID;
    String uName;
    boolean isAdmin;
    boolean isLocked;
    String fullname;
    String address;
    Date birthDate;
    String gender;
    String email;
    String password;
    String status;
    LocalDateTime createTime;

    public UsersDTO() {
        this.address = "";
        this.birthDate = new Date(System.currentTimeMillis());
        this.createTime = LocalDateTime.now();
        this.email = "";
        this.fullname = "";
        this.gender = "";
        this.isAdmin = false;
        this.isLocked = false;
        this.password = "";
        this.status = "";
        this.uID = 0;
        this.uName = "";
    }

    public UsersDTO(int uID, String uName, Boolean isAdmin, Boolean isLocked, String fullname, String address, Date birthDate, String gender, String email, String password, String status, LocalDateTime createTime) {
        this.address = address;
        this.birthDate = birthDate;
        this.createTime = createTime;
        this.email = email;
        this.fullname = fullname;
        this.gender = gender;
        this.isAdmin = isAdmin;
        this.isLocked = isLocked;
        this.password = password;
        this.status = status;
        this.uID = uID;
        this.uName = uName;
    }

    public UsersDTO(String uName, String fullname, String address, Date birthDate, String gender, String email, String password) {
        this.address = address;
        this.birthDate = birthDate;
        this.email = email;
        this.fullname = fullname;
        this.gender = gender;
        this.isAdmin = false;
        this.password = password;
        this.uName = uName;
    }

    public int getuID() {
        return uID;
    }

    public String getuName() {
        return uName;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public boolean getIsLocked() {
        return isLocked;
    }

    public String getFullname() {
        return fullname;
    }

    public String getAddress() {
        return address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

}