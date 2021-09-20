package chinh.anh.controller;

import chinh.anh.model.Customer;
import chinh.anh.model.Province;
import chinh.anh.service.impl.CustomerServiceImpl;
import chinh.anh.service.impl.ProvinceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private ProvinceServiceImpl provinceService;
    @ModelAttribute("provinces")
    public Iterable<Province> listProvince(){
        return provinceService.findAll();
    }
    @GetMapping("/")
    public ModelAndView listCustomer(){
        Iterable<Customer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("listCustomer", customers);
        return modelAndView;
    }
    @GetMapping("/create/customer")
    public ModelAndView showCreateCustomerForm(){
        ModelAndView modelAndView = new ModelAndView("/customer/add");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @PostMapping("/create/customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/add");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "Create customer success!");
        return modelAndView;
    }
}
