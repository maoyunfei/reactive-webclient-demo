package com.example.reactivewebclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description
 *
 * @author maoyunfei
 * @Date 2018/2/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String id;
    private String name;
    private Long salary;
}
