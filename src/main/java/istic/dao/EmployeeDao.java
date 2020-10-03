package istic.dao;

import istic.services.Employee;

public class EmployeeDao extends AbstractJpaDao<Long, Employee>{

    public EmployeeDao() {
        super(Employee.class);
    }
}
