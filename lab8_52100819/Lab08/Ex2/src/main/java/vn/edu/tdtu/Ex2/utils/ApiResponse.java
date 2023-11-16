package vn.edu.tdtu.Ex2.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ApiResponse {
    private String message;
    private Object data;
    private int status;
}

