package com.fizz.spring.part8.flow;

import com.fizz.spring.part8.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/flowView")
public class FlowViewController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "pizza/customer/welcome";
    }

    @RequestMapping(value = "/registrationForm", method = RequestMethod.GET)
    public String registrationForm() {
        return "pizza/customer/registrationForm";
    }

    @RequestMapping(value = "/deliveryWarning", method = RequestMethod.GET)
    public String deliveryWarning() {
        return "pizza/customer/deliveryWarning";
    }

    @RequestMapping(value = "/showOrder", method = RequestMethod.GET)
    public String showOrder() {
        return "pizza/order/showOrder";
    }

    @RequestMapping(value = "/createPizza", method = RequestMethod.GET)
    public String createPizza() {
        return "pizza/order/createPizza";
    }

    @RequestMapping(value = "/takePayment", method = RequestMethod.GET)
    public String takePayment() {
        return "pizza/payment/takePayment";
    }

    @RequestMapping(value = "/thankYou", method = RequestMethod.GET)
    public String thankYou() {
        return "pizza/thankYou";
    }

}
