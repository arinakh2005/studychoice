package ua.edu.chdtu.fitis.studychoice.service;

import org.springframework.stereotype.Service;
import ua.edu.chdtu.fitis.studychoice.entity.CriterionComparison;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class CriterionComparisonService {

    public List<CriterionComparison> getCriteriaComparisonsDB(int[] criteriaIds, int[] universityIds) {
        List<CriterionComparison> criteriaComparisons = new ArrayList<>();
        Statement stmt = null;
        try {
            stmt = DBConnection.getConnection().createStatement();
            String sql = "SELECT * FROM criteria_comparison where criterion_id IN (";
            for (int i = 0; i<criteriaIds.length; i++) {
                sql += criteriaIds[i] + ",";
            }
            sql = sql.substring(0, sql.length()-1) + ") and university1_id IN (";
            for (int i = 0; i<universityIds.length; i++) {
                sql += universityIds[i] + ",";
            }
            sql = sql.substring(0, sql.length()-1) + ") and university2_id IN (";
            for (int i = 0; i<universityIds.length; i++) {
                sql += universityIds[i] + ",";
            }
            sql = sql.substring(0, sql.length()-1) + ")";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                CriterionComparison criteriaComparison = new CriterionComparison();
                criteriaComparison.setCriterionId(rs.getInt("criterion_id"));
                criteriaComparison.setUniversity1Id(rs.getInt("university1_id"));
                criteriaComparison.setUniversity2Id(rs.getInt("university2_id"));
                criteriaComparison.setValue(rs.getDouble("value"));
                criteriaComparison.setId(rs.getInt("id"));
                criteriaComparisons.add(criteriaComparison);
            }
            rs.close();
        } catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se){
            }// do nothing
        }
        return criteriaComparisons;
    }

    public double[][][] buildCriteriaComparisonArrays(List<CriterionComparison> criterionComparisons, int[] criteriaIds, int[] universityIds) {
        double[][][] data = new double[criteriaIds.length][universityIds.length][universityIds.length];
        for (int i = 0; i < criteriaIds.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j][j] = 1;
            }
            for (CriterionComparison criterionComparison : criterionComparisons) {
                if (criterionComparison.getCriterionId() == criteriaIds[i]) {
                    int criterionIndex = getCriterionIndex(criteriaIds, criterionComparison);
                    int university1Index = getUniversityIndex(universityIds, criterionComparison.getUniversity1Id());
                    int university2Index = getUniversityIndex(universityIds, criterionComparison.getUniversity2Id());
                    data[criterionIndex][university1Index][university2Index] = criterionComparison.getValue();
                    data[criterionIndex][university2Index][university1Index] = 1 / criterionComparison.getValue();
                }
            }
        }
        return data;
    }

    private int getCriterionIndex(int[] criteriaIds, CriterionComparison criterionComparison) {
        for (int j = 0; j < criteriaIds.length; j++) {
            if (criteriaIds[j] == criterionComparison.getCriterionId()) {
                return j;
            }
        }
        return -1;
    }

    private int getUniversityIndex(int universityIds[], int criterionComparisonUniversityId) {
        for (int j = 0; j < universityIds.length; j++) {
            if (universityIds[j] == criterionComparisonUniversityId) {
                return j;
            }
        }
        return -1;
    }

}

