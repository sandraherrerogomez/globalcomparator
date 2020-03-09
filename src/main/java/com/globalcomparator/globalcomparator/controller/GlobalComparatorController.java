package com.globalcomparator.globalcomparator.controller;

import com.globalcomparator.globalcomparator.model.ComparatorRequest;
import com.globalcomparator.globalcomparator.service.GlobalComparatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GlobalComparatorController {


        @Autowired
        private GlobalComparatorService gbComparatorsvc;


        @PostMapping("cityComparator")
        @CrossOrigin
        public List<String> getCityData(@RequestBody ComparatorRequest request){
               return gbComparatorsvc.processComparatorRequest(request);
        }
}
