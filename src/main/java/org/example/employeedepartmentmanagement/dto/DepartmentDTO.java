package org.example.employeedepartmentmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DepartmentDTO {

    private Long id;

    @NotBlank(message = "Ten phong ban khong duoc de trong")
    private String name;

    @NotBlank(message = "Dia diem khong duoc de trong")
    private String location;
}