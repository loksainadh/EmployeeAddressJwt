package com.neo.employee.jwt.security.services;

import com.neo.employee.jwt.models.Employee;
import com.neo.employee.jwt.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("user name  loadUserByUsername "+username);
        Optional<Employee> employee = employeeRepository.findByEmployeeName(username);
        return EmployeeDetailsImpl.build(employee);
    }
}
