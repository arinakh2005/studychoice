package ua.edu.chdtu.fitis.studychoice.service;

import org.springframework.stereotype.Service;
import ua.edu.chdtu.fitis.studychoice.entity.City;
import ua.edu.chdtu.fitis.studychoice.entity.Criteria;
import ua.edu.chdtu.fitis.studychoice.entity.University;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    public List<City> getCitiesDB() {
        List<City> cities = new ArrayList<>();
        Statement stmt = null;
        try {
            stmt = DBConnection.getConnection().createStatement();
            String sql = "SELECT * FROM town";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                City city = new City();
                city.setId(rs.getInt("id"));
                city.setName(rs.getString("name"));
                cities.add(city);
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
        return cities;
    }

}
