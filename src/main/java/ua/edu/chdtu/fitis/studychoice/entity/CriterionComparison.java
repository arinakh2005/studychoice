package ua.edu.chdtu.fitis.studychoice.entity;

public class CriterionComparison {
    private int criterionId;
    private int university1Id;
    private int university2Id;
    private double value;
    private int id;


    public int getCriterionId() {
        return criterionId;
    }

    public void setCriterionId(int criterionId) {
        this.criterionId = criterionId;
    }

    public int getUniversity1Id() {
        return university1Id;
    }

    public void setUniversity1Id(int university1Id) {
        this.university1Id = university1Id;
    }

    public int getUniversity2Id() {
        return university2Id;
    }

    public void setUniversity2Id(int university2Id) {
        this.university2Id = university2Id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
