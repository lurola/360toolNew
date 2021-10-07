package com.appraisaltool.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GGResponse<T> {
    private T data;
    private List<String> errors;
    private Boolean success;

}