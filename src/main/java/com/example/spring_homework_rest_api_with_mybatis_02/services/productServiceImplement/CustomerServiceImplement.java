package com.example.spring_homework_rest_api_with_mybatis_02.services.productServiceImplement;
import com.example.spring_homework_rest_api_with_mybatis_02.model.entity.Customer;
import com.example.spring_homework_rest_api_with_mybatis_02.model.request.CustomerRequest;
import com.example.spring_homework_rest_api_with_mybatis_02.repository.CustomerRepository;
import com.example.spring_homework_rest_api_with_mybatis_02.services.CustomerService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CustomerServiceImplement implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImplement(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomer()  {
        return customerRepository.findAllCustomer();
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return customerRepository.getCustomerById(customerId);
    }

    @Override
    public boolean deleteCustomerById (Integer customerId) {
        return customerRepository.deleteCustomerById(customerId);
    }

    @Override
    public Integer addNewCustomer(CustomerRequest customerRequest) {
        Integer customerId =  customerRepository.saveDataCustomer(customerRequest );
        return customerId;
    }

    @Override
    public Integer updateCustomer(CustomerRequest customerRequest, Integer customerId) {
        Integer customerIdUpdate = customerRepository.updateCustomer(customerRequest, customerId);
        return customerIdUpdate;
    }
}
