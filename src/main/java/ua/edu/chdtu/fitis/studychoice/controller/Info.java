package ua.edu.chdtu.fitis.studychoice.controller;

import java.util.List;

public class Info {
    List<String> universities;
    List<String> criteria;
    List<String> coefficients;

    public List<String> getUniversities() {
        return universities;
    }

    public void setUniversities(List<String> universities) {
        this.universities = universities;
    }

    public List<String> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<String> criteria) {
        this.criteria = criteria;
    }

    public List<String> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(List<String> coefficients) {
        this.coefficients = coefficients;
    }
}
