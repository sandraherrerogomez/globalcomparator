package com.globalcomparator.globalcomparator.controller;

import com.globalcomparator.globalcomparator.model.ComparatorRequest;
import com.globalcomparator.globalcomparator.service.GlobalComparatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalComparatorController {


        @Autowired
        private GlobalComparatorService gbComparatorsvc;

        @GetMapping("cityComparator")
        public void getCityData(@RequestBody ComparatorRequest request){
                gbComparatorsvc.processComparatorRequest(request);
            //return numbeoParserSvc.getNumbeoData(country1, country2, cityName, cityName2, amount1, amount2, currency);
        }
}
