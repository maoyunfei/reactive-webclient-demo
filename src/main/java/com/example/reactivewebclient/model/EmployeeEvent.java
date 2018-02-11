package com.example.reactivewebclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description
 *
 * @author maoyunfei
 * @Date 2018/2/11
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeEvent {

    private Employee employee;
    private Date date;

}
