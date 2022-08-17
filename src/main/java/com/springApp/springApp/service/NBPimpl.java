package com.springApp.springApp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
@Service
public class NBPimpl implements NBP{


    @Override
    public List<Object> getFromYesterdayExchangeRates() {



        String url="http://api.nbp.pl/api/exchangerates/tables/A/"+ LocalDate.now().minusDays(1)+"/";
        RestTemplate restTemplate =new RestTemplate();
        String result=restTemplate.getForObject(url,String.class);

        return List.of(result);


    }
    @Override
    public List<Object> getUSDLast10Days()  {

        String url="http://api.nbp.pl/api/exchangerates/rates/A/USD/"+LocalDate.now().minusDays(10)+"/"+LocalDate.now()+"/";
        RestTemplate restTemplate =new RestTemplate();
        Object result = restTemplate.getForObject(url,Object.class);
        return List.of(result);
    }
}
