package ua.edu.chdtu.fitis.studychoice.service;

import org.springframework.stereotype.Service;
import ua.edu.chdtu.fitis.studychoice.entity.University;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {

    public List<University> getUniversitiesDB() {
        List<University> universities = new ArrayList<>();
        Statement stmt = null;
        try {
            stmt = DBConnection.getConnection().createStatement();
            String sql = "SELECT * FROM university";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                University university = new University();
                university.setId(rs.getInt("id"));
                university.setName(rs.getString("name"));
                universities.add(university);
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
        return universities;
    }
}
