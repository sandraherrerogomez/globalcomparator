package com.globalcomparator.globalcomparator.service;
import com.globalcomparator.globalcomparator.model.ComparatorRequest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GlobalComparatorService {
    private RestTemplate restTemplate= new RestTemplateBuilder().build();

    public void processComparatorRequest(ComparatorRequest request){
        System.out.println(getCOLData(request));
        System.out.println(SALCalculatorData1(request));
        System.out.println(SALCalculatorData2(request));
        System.out.println(COLComparatorGetIndices1(request));
        System.out.println(COLComparatorGetIndices2(request));
    }

    private String getCOLData(ComparatorRequest request){
        String URL="http://localhost:8081/cityComparator?cityName="+request.getCity1()+"&cityName2="+request.getCity2()+"&country1="+request.getCountry1()+
                "&country2="+request.getCountry2()+"&amount1="+request.getAmountCity1()+"&amount2="+request.getAmountCity2()+"&currency=EUR";
        return this.restTemplate.getForObject(URL, String.class);
    }

    private String SALCalculatorData1(ComparatorRequest request){
        String URL="http://localhost:8082/salary?countryName="+request.getCountry1()+"&grossSalary="+request.getAmountCity1();
        return this.restTemplate.getForObject(URL, String.class);
    }

    private String SALCalculatorData2(ComparatorRequest request){
        String URL="http://localhost:8082/salary?countryName="+request.getCountry2()+"&grossSalary="+request.getAmountCity2();
        return this.restTemplate.getForObject(URL, String.class);

    }

    private String COLComparatorGetIndices1(ComparatorRequest request){
        String URL="http://localhost:8081/indices?city="+request.getCity1()+"&country="+request.getCountry1();
        return this.restTemplate.getForObject(URL, String.class);
    }

    private String COLComparatorGetIndices2(ComparatorRequest request){
        String URL="http://localhost:8081/indices?city="+request.getCity2()+"&country="+request.getCountry2();
        return this.restTemplate.getForObject(URL, String.class);
    }
}
