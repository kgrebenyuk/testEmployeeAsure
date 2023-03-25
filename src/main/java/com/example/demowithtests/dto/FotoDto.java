package com.example.demowithtests.dto;

import java.time.Instant;
import java.util.Date;


public class FotoDto {

    public String link;
    public Integer length;
    public Integer width;
    public Boolean isDeleted = Boolean.FALSE;
    public Boolean isShown = Boolean.TRUE;
    public Date creationTime = Date.from(Instant.now());


}
