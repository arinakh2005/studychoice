package ua.edu.chdtu.fitis.studychoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.chdtu.fitis.studychoice.entity.City;
import ua.edu.chdtu.fitis.studychoice.entity.Criteria;
import ua.edu.chdtu.fitis.studychoice.entity.CriterionComparison;
import ua.edu.chdtu.fitis.studychoice.service.CriterionComparisonService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    CriterionComparisonService criterionComparisonService;

    @GetMapping("/city")
    public ResponseEntity getCity() {
        List<City> cities = new ArrayList<>();
        City city = new City();
        city.setId(1);
        city.setName("Kyiv");
        City city2 = new City();
        city2.setId(2);
        city2.setName("Cherkassy");
        cities.add(city);
        cities.add(city2);
        return ResponseEntity.ok(cities);
    }
    @GetMapping("/criteria")
    public ResponseEntity getCriterion() {
        List<Criteria> criterions = new ArrayList<>();
        Criteria criteria = new Criteria();
        criteria.setId(1);
        criteria.setName("Доступність додаткового навчання (професійні курси тощо)");
        Criteria criteria2 = new Criteria();
        criteria2.setId(2);
        criteria2.setName("Наявність місць в гуртожитку та його якість");
        criterions.add(criteria);
        criterions.add(criteria2);
        return ResponseEntity.ok(criterions);
    }

    @GetMapping("/criteria-comparison")
    public ResponseEntity getCriteriaComparison() {
        int[] criteriaIds = {1, 2};
        int[] universityIds = {1, 2, 3};
        List<CriterionComparison> criteriaComparisons =
                criterionComparisonService.getCriteriaComparisonsDB(criteriaIds, universityIds);
        return ResponseEntity.ok(criteriaComparisons);
    }
}
