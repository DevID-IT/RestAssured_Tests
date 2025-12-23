package model.orders.confirm;

public class MyBank {
    String name;
    String country_code;
    ExperienceContext experience_context;

    public MyBank(String name, String country_code, ExperienceContext experience_context) {
        this.name = name;
        this.country_code = country_code;
        this.experience_context = experience_context;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getCountry_code() {return country_code;}

    public void setCountry_code(String country_code) {this.country_code = country_code;}

    public ExperienceContext getExperience_context() {return experience_context;}

    public void setExperience_context(ExperienceContext experience_context) {this.experience_context = experience_context;}

}
