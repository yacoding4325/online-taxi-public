package com.yacoding.internalcommon.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author yaCoding
 * @create 2022-11-17 下午 4:54
 */
@Data
public class PassengerUser {

    private Long id;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private String passengerPhone;

    private String passengerName;

    private byte passengerGender;

    private byte state;

    private String profilePhoto;

}
