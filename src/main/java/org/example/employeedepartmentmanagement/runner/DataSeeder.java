package org.example.employeedepartmentmanagement.runner;

import lombok.RequiredArgsConstructor;
import org.example.employeedepartmentmanagement.entity.Department;
import org.example.employeedepartmentmanagement.entity.Employee;
import org.example.employeedepartmentmanagement.entity.EmployeeStatus;
import org.example.employeedepartmentmanagement.repository.IDepartmentRepository;
import org.example.employeedepartmentmanagement.repository.IEmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final IDepartmentRepository departmentRepository;
    private final IEmployeeRepository employeeRepository;

    @Override
    public void run(String... args) {
        if (departmentRepository.count() == 0 && employeeRepository.count() == 0) {

            Department it = new Department();
            it.setName("IT Department");
            it.setLocation("Ha Noi");
            departmentRepository.save(it);

            Department hr = new Department();
            hr.setName("HR Department");
            hr.setLocation("Da Nang");
            departmentRepository.save(hr);

            Employee emp1 = new Employee();
            emp1.setName("Nguyen Van Anh");
            emp1.setAge(22);
            emp1.setAvatar("https://cdn2.fptshop.com.vn/unsafe/Uploads/images/tin-tuc/174978/Originals/avatar%20one%20piece%20(40).jpg");
            emp1.setStatus(EmployeeStatus.ACTIVE);
            emp1.setDepartment(it);
            employeeRepository.save(emp1);

            Employee emp2 = new Employee();
            emp2.setName("Nguyen Tri Thang");
            emp2.setAge(25);
            emp2.setAvatar("https://cdn2.fptshop.com.vn/unsafe/Uploads/images/tin-tuc/174978/Originals/avatar%20one%20piece%20(13).jpg");
            emp2.setStatus(EmployeeStatus.ACTIVE);
            emp2.setDepartment(hr);
            employeeRepository.save(emp2);

            Employee emp3 = new Employee();
            emp3.setName("Nguyen Tuan Minh");
            emp3.setAge(30);
            emp3.setAvatar("https://cdn2.fptshop.com.vn/unsafe/Uploads/images/tin-tuc/174978/Originals/avatar%20one%20piece%20(6).jpg");
            emp3.setStatus(EmployeeStatus.INACTIVE);
            emp3.setDepartment(it);
            employeeRepository.save(emp3);
        }
    }
}