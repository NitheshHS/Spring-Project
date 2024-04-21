package com.example.demo.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
