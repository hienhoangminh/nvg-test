package utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DataHelper {

    @JsonProperty("email")
    String email;

    @JsonProperty("validPassword")
    String validPassword;

    @JsonProperty("inValidPassword")
    String inValidPassword;

    @JsonProperty("keyword")
    String keyword;

    @JsonProperty("department")
    String department;

    @JsonProperty("sort")
    String sort;

    @JsonProperty("language")
    String language;

    public static DataHelper get(String fileName) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(fileName), DataHelper.class);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public void setValidPassword(String validPassword) {
        this.validPassword = validPassword;
    }

    public String getInValidPassword() {
        return inValidPassword;
    }

    public void setInValidPassword(String inValidPassword) {
        this.inValidPassword = inValidPassword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
