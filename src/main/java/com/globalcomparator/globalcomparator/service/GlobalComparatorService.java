package com.globalcomparator.globalcomparator.service;
import com.globalcomparator.globalcomparator.model.ComparatorRequest;
import com.globalcomparator.globalcomparator.model.NumbeoData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GlobalComparatorService {
    private RestTemplate restTemplate= new RestTemplateBuilder().build();
    @Value("${colservice.host}")
    private String colservice;

    @Value("${salservice.host}")
    private String salservice;

    public List<String> processComparatorRequest(ComparatorRequest request){
        List<String> data = new ArrayList<>();
        //data.add(getCOLData(request));
        data.add(SALCalculatorData1(request));
        data.add(SALCalculatorData2(request));
        data.add(COLComparatorGetIndices1(request));
        data.add(COLComparatorGetIndices2(request));
        data.add(COLComparatorGetCityPrices1(request));
        data.add(COLComparatorGetCityPrices2(request));
        return data;
    }

    public List<String> getSalaries(ComparatorRequest request){
        List<String> data = new ArrayList<>();
        //data.add(getCOLData(request));
        data.add(SALCalculatorData1(request));
        data.add(SALCalculatorData2(request));

        return data;
    }


    public List<String> getAllNumbeoData(ComparatorRequest request){
        String URL="https://"+colservice+"/allData?cityName="+request.getCity1()+"&cityName2="+request.getCity2()+"&country1="+request.getCountry1()+
                "&country2="+request.getCountry2();
        return this.restTemplate.getForObject(URL, List.class);
    }

    public NumbeoData getCOLData(ComparatorRequest request){
        String URL="https://"+colservice+"/cityComparator?cityName="+request.getCity1()+"&cityName2="+request.getCity2()+"&country1="+request.getCountry1()+
                "&country2="+request.getCountry2()+"&amount1="+request.getAmountCity1()+"&amount2="+request.getAmountCity2()+"&currency=EUR";
        return this.restTemplate.getForObject(URL, NumbeoData.class);
    }

    @Async
    String SALCalculatorData1(ComparatorRequest request){
        String URL="https://"+salservice+"/salary?countryName="+request.getCountry1()+"&grossSalary="+request.getAmountCity1();
        return this.restTemplate.getForObject(URL, String.class);
    }

    @Async
    String SALCalculatorData2(ComparatorRequest request){
        String URL="https://"+salservice+"/salary?countryName="+request.getCountry2()+"&grossSalary="+request.getAmountCity2();
        return this.restTemplate.getForObject(URL, String.class);

    }

    @Async
    String COLComparatorGetIndices1(ComparatorRequest request){
        String URL="https://"+colservice+"/indices?city="+request.getCity1()+"&country="+request.getCountry1();
        return this.restTemplate.getForObject(URL, String.class);
    }

    @Async
    String COLComparatorGetIndices2(ComparatorRequest request){
        String URL="https://"+colservice+"/indices?city="+request.getCity2()+"&country="+request.getCountry2();
        return this.restTemplate.getForObject(URL, String.class);
    }

    @Async
    String COLComparatorGetCityPrices1(ComparatorRequest request){
        String URL="https://"+colservice+"/cityPrices?city="+request.getCity1()+"&country="+request.getCountry1();
        return this.restTemplate.getForObject(URL, String.class);
    }

    @Async
    String COLComparatorGetCityPrices2(ComparatorRequest request){
        String URL="https://"+colservice+"/cityPrices?city="+request.getCity2()+"&country="+request.getCountry2();
        return this.restTemplate.getForObject(URL, String.class);
    }

    public String COLComparatorListAvailableCities(){
        String URL="https://"+colservice+"/cities";
        return this.restTemplate.getForObject(URL, String.class);
    }
}
