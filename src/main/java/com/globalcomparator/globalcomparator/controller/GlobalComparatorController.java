package com.globalcomparator.globalcomparator.controller;

import com.globalcomparator.globalcomparator.model.ComparatorRequest;
import com.globalcomparator.globalcomparator.model.NumbeoData;
import com.globalcomparator.globalcomparator.service.GlobalComparatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class GlobalComparatorController {


        @Autowired
        private GlobalComparatorService gbComparatorsvc;


        @PostMapping("cityComparator")
        @CrossOrigin
        public List<String> getCityData(@RequestBody ComparatorRequest request){
               return gbComparatorsvc.processComparatorRequest(request);
        }

        @PostMapping("salaries")
        @CrossOrigin
        public List<String> getSalaries(@RequestBody ComparatorRequest request){
                return gbComparatorsvc.getSalaries(request);
        }



        @PostMapping("cityComparatorv2")
        @CrossOrigin
        public List<String> getAllCityData(@RequestBody ComparatorRequest request){
                return gbComparatorsvc.getAllNumbeoData(request);
        }
        @GetMapping("cities")
        @CrossOrigin
        public String getCities() throws ExecutionException, InterruptedException {
               return gbComparatorsvc.COLComparatorListAvailableCities();
        }

        @PostMapping("colData")
        @CrossOrigin
        public NumbeoData getColData(@RequestBody ComparatorRequest request) throws ExecutionException, InterruptedException {
                NumbeoData data = gbComparatorsvc.getCOLData(request);
                return data;
        }
}
