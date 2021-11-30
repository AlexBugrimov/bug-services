package dev.bug.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public ResponseEntity<Void> registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest,
                                                 HttpServletRequest request) {
        log.info("New customer registration {}", customerRequest);
        customerService.registerCustomer(customerRequest);
        return ResponseEntity.created(URI.create(request.getRequestURI())).build();
    }
}
