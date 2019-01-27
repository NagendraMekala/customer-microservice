package com.mng.spring.main.client;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mng.spring.main.model.Account;



@FeignClient(name ="account-service", fallback = AccountFallback.class)
@RibbonClient("account-service")
public interface AccountClient {

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/customer/{customerId}")
    public List<Account> getAccounts(@PathVariable("customerId") Integer customerId);
    
    @RequestMapping(value = "/accounts/elkdemo")
    public String helloWorld();
    
    @RequestMapping(value = "/accounts/exception")
    public String exception();
    
    @RequestMapping("/accounts/ribbon")
    public String backend();
    
}
