package com.fizz.spring.part8.flow;

import com.fizz.spring.part8.entity.Customer;
import com.fizz.spring.part8.entity.Order;
import com.fizz.spring.part8.entity.Payment;
import com.fizz.spring.part8.entity.PaymentDetails;
import com.fizz.spring.part8.exception.CustomerNotFoundException;
import com.fizz.spring.part8.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
public class PizzaFlowActions {

    @Autowired
    private CustomerService customerService;

    /**
     * 查找顾客
     * @param phoneNumber
     * @return
     * @throws CustomerNotFoundException
     */
    public Customer lookCustomer(String phoneNumber) throws CustomerNotFoundException {
        Customer customer = customerService.getCustomer(phoneNumber);
        if (customer != null) {
            return customer;
        } else {
            throw new CustomerNotFoundException();
        }
    }

    /**
     * 添加顾客
     * @param customer
     */
    public void addCustomer(Customer customer) {
        customerService.saveCustomer(customer);
    }

    /**
     * 支付
     * @param paymentDetails
     * @return
     */
    public Payment verifyPayment(PaymentDetails paymentDetails) {
        Payment payment = null;
        /*if (paymentDetails.getPaymentType() == CREDIT_CARD) {
            payment = new CreditCardPayment();
        } else {
            payment = new CashOrCheckPayment();
        }*/
        return payment;
    }

    /**
     * 存储订单
     * @param order
     */
    public void saveOrder(Order order) {

    }

    /**
     * 校验配送区域
     * @param zipCode
     * @return
     */
    public boolean checkDeliveryArea(String zipCode) {
        return "75075".equals(zipCode);
    }

}
