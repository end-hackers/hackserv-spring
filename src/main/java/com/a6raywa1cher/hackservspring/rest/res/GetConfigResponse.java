package com.a6raywa1cher.hackservspring.rest.res;

import lombok.Data;

@Data
public class GetConfigResponse {

    private String maxFileSize;

    private Integer minEmailReq;

    private Integer maxEmailDuration;
}