package org.example.employeedepartmentmanagement.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.example.employeedepartmentmanagement.entity.EmployeeStatus;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Ten nhan vien khong duoc de trong")
    private String name;

    @NotNull(message = "Tuoi khong duoc de trong")
    @Min(value = 18, message = "Tuoi phai >= 18")
    @Max(value = 65, message = "Tuoi phai <= 65")
    private Integer age;

    private String avatar;

    private MultipartFile file;

    @NotNull(message = "Trang thai khong duoc de trong")
    private EmployeeStatus status;

    @NotNull(message = "Phong ban khong duoc de trong")
    private Long departmentId;
}