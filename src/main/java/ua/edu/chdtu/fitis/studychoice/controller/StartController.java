package ua.edu.chdtu.fitis.studychoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.chdtu.fitis.studychoice.entity.City;
import ua.edu.chdtu.fitis.studychoice.entity.Criteria;
import ua.edu.chdtu.fitis.studychoice.entity.University;
import ua.edu.chdtu.fitis.studychoice.service.CityService;
import ua.edu.chdtu.fitis.studychoice.service.CriteriaService;
import ua.edu.chdtu.fitis.studychoice.service.CriterionComparisonService;
import ua.edu.chdtu.fitis.studychoice.service.UniversityService;

import java.util.List;

@Controller
public class StartController {
    @Autowired
    private UniversityService universityService;
    @Autowired
    private CityService cityService;
    @Autowired
    private CriteriaService criteriaService;
    @Autowired
    private CriterionComparisonService criterionComparisonDTOService;

    public StartController(CriteriaService criteriaService) {
        this.criteriaService = criteriaService;
    }

    @GetMapping("/")
    public String start()  {
        return "index2";
    }

    @GetMapping("/choose")
    public ModelAndView getChoosePanel() {
        ModelAndView modelAndView = new ModelAndView("form");
        List<University> universities = universityService.getUniversitiesDB();
        List<Criteria> criterions = criteriaService.getCriterionsDB();
        List<City> cities = cityService.getCitiesDB();
        modelAndView.addObject("universities", universities);
        modelAndView.addObject("criterions", criterions);
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @PostMapping("/send")
    public ModelAndView send(@RequestBody Info info) {
        ModelAndView modelAndView = new ModelAndView("result");
        return modelAndView;
    }

}
