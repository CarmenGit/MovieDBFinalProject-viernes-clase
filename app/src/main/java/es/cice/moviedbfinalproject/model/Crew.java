package es.cice.moviedbfinalproject.model;

import java.util.HashMap;
import java.util.Map;

public class Crew {

    private String credit_id;
    private String department;
    private Integer id;
    private String job;
    private String name;
    private Object profile_path;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getCreditId() {
        return credit_id;
    }

    public void setCreditId(String creditId) {
        this.credit_id = creditId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getProfilePath() {
        return profile_path;
    }

    public void setProfilePath(Object profilePath) {
        this.profile_path = profilePath;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
