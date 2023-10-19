package ord.example.tdtu;

import java.util.Arrays;

public class InforUser {
    private String userName;
    private String email;
    private String birthday;
    private String birthtime;
    private String country;
    private double toeic;
    private String message;
    private String gender;
    private String[] selectedValues;


    public InforUser(String userName, String email, String birthday, String birthtime, String country, double toeic, String message, String gender, String[] selectedValues) {
        this.userName = userName;
        this.email = email;
        this.birthday = birthday;
        this.birthtime = birthtime;
        this.country = country;
        this.toeic = toeic;
        this.message = message;
        this.gender = gender;
        this.selectedValues = selectedValues;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthtime() {
        return birthtime;
    }

    public void setBirthtime(String birthtime) {
        this.birthtime = birthtime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getToeic() {
        return toeic;
    }

    public void setToeic(double toeic) {
        this.toeic = toeic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getSelectedValues() {
        return selectedValues;
    }

    public void setSelectedValues(String[] selectedValues) {
        this.selectedValues = selectedValues;
    }

    @Override
    public String toString() {
        return "InforUser{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", birthtime='" + birthtime + '\'' +
                ", country='" + country + '\'' +
                ", toeic='" + toeic + '\'' +
                ", message='" + message + '\'' +
                ", gender='" + gender + '\'' +
                ", selectedValues=" + Arrays.toString(selectedValues) +
                '}';
    }
}
