package ua.edu.chdtu.fitis.studychoice.service;

import org.springframework.stereotype.Service;
import ua.edu.chdtu.fitis.studychoice.entity.Criteria;
import ua.edu.chdtu.fitis.studychoice.entity.University;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CriteriaService {


    public List<Criteria> getCriterionsDB() {
        List<Criteria> criterions = new ArrayList<>();
        Statement stmt = null;
        try {
            stmt = DBConnection.getConnection().createStatement();
            String sql = "SELECT * FROM selection_criterion";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                Criteria criteria = new Criteria();
                criteria.setId(rs.getInt("id"));
                criteria.setName(rs.getString("name"));
                criterions.add(criteria);
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
        return criterions;
    }
}
