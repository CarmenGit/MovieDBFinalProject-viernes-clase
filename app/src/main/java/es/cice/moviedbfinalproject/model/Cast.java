package es.cice.moviedbfinalproject.model;

import java.util.HashMap;
import java.util.Map;

public class Cast {

    private Integer cast_id;
    private String character;
    private String credit_id;
    private Integer id;
    private String name;
    private Integer order;
    private String profile_path;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getCastId() {
        return cast_id;
    }

    public void setCastId(Integer castId) {
        this.cast_id = castId;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCreditId() {
        return credit_id;
    }

    public void setCreditId(String creditId) {
        this.credit_id = creditId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getProfilePath() {
        return profile_path;
    }

    public void setProfilePath(String profilePath) {
        this.profile_path = profilePath;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
