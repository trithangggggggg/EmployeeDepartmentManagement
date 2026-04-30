package org.example.employeedepartmentmanagement.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.example.employeedepartmentmanagement.entity.EmployeeStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "khong duoc de trong!")
    private String name;

    @NotNull(message = "tuoi khong duoc de trong!")
    @Min(value = 18, message = "tuoi phai >= 18")
    @Max(value = 65, message = "tuoi phai <= 65")
    private Integer age;

    @NotBlank(message = "avatar khong duoc de trong!")
    private String avatar;

    @NotNull(message = "status khong duoc de trong!")
    private EmployeeStatus status;

    @NotNull(message = "Department khong duoc de trong!")
    private Long departmentId;

    private String departmentName;
}