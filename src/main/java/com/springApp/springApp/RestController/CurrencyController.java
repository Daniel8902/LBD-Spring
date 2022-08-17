package com.springApp.springApp.RestController;

import com.springApp.springApp.service.NBP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class CurrencyController {
    @Autowired
    NBP nbp;



    @GetMapping("/yesterday")
    public List<Object> getAllExchangeRatest() {


        return nbp.getFromYesterdayExchangeRates() ;


    }
    @GetMapping("/usd")
    public List<Object> getUSDExchangeFromLast10Days() {


        return  nbp.getUSDLast10Days();


    }

}
