package com.yacoding.apipassenger.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yacoding.apipassenger.constraints.DateTimeRange;
import com.yacoding.apipassenger.constraints.DicCheck;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

/**
 * @Author yaCoding
 * @create 2023-10-04 下午 1:52
 */
@Data
public class OrderRequest {

    /**
     * 订单id
     */
    @Positive(message = "订单号必须是正数")
    private Long orderId;

    // 乘客ID
    @NotNull(message = "乘客ID不能为空")
    @Positive(message = "乘客ID必须是正数")
    private Long passengerId;

    // 乘客手机号
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3,4,5,6,7,8,9]\\d{9}$",message = "请填写正确的乘客手机号")
    private String passengerPhone;

    // 下单行政区域
    @Pattern(regexp = "^\\d{6}$",message = "行政区域不正确")
    private String address;

    // 出发时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeRange(judge = DateTimeRange.IS_AFTER,message = "出发时间不正确")
    @NotNull(message = "出发时间不能为空")
    private LocalDateTime departTime;

    // 下单时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderTime = LocalDateTime.now();
    // 出发地址
    @NotNull(message = "出发地址不能为空")
    @Length(min = 2,message = "出发地址长度太短")
    private String departure;

    // 出发经度
    @NotBlank(message = "出发经度不能为空")
    @Pattern(regexp = "^[\\-\\+]?(0?\\d{1,2}\\.\\d{1,6}|1[0-7]\\d{1}\\.\\d{1,6}|180\\.0{1,6})$",message = "请输入正确的起点经度")
    private String depLongitude;

    // 出发纬度
    @NotBlank(message = "出发纬度不能为空")
    @Pattern(regexp = "^[\\-\\+]?([0-8]?\\d{1}\\.\\d{1,6}|90\\.0{1,6})$",message = "请输入正确的起点纬度")
    private String depLatitude;

    // 目的地地址
    @NotNull(message = "目的地不能为空")
    @Length(min = 2,message = "目的地地址长度太短")
    private String destination;

    // 目的地经度
    @NotBlank(message = "目的地经度不能为空")
    @Pattern(regexp = "^[\\-\\+]?(0?\\d{1,2}\\.\\d{1,6}|1[0-7]\\d{1}\\.\\d{1,6}|180\\.0{1,6})$",message = "请输入正确的起点经度")
    private String destLongitude;

    // 目的地纬度
    @NotBlank(message = "目的地纬度不能为空")
    @Pattern(regexp = "^[\\-\\+]?([0-8]?\\d{1}\\.\\d{1,6}|90\\.0{1,6})$",message = "请输入正确的起点纬度")
    private String destLatitude;

    // 坐标加密标识 1:gcj-02,2:wgs84,3:bd-09,4:cgcs2000北斗 0：其他
    @NotNull
    @DicCheck(dicValue = {"1","2","3","4","0"},message = "坐标加密标识不正确")
    private Integer encrypt;

    // 运价类型编码
    @NotBlank
    @Pattern(regexp = "^\\d{6}\\$\\d{1}$",message = "运价类型编码不正确")
    private String fareType;
    // 运价版本

    @NotNull(message = "计价版本不能为空")
    @Positive(message = "计价版本不正确")
    private Integer fareVersion;

    // 请求设备唯一码
    @NotBlank(message = "设备唯一码不能为空")
    @Length(min = 8,message = "设备唯一码长度不正确")
    private String deviceCode;

    /**
     * 车型
     */
    @NotBlank(message = "车辆类型不能为空")
    @DicCheck(dicValue = {"1","2"},message = "请填写正确的车辆类型")
    private String vehicleType;

    /**
     * 司机去接乘客出发时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime toPickUpPassengerTime;

    /**
     * 去接乘客时，司机的经度
     */
    private String toPickUpPassengerLongitude;

    /**
     * 去接乘客时，司机的纬度
     */
    private String toPickUpPassengerLatitude;

    /**
     * 去接乘客时，司机的地点
     */
    private String toPickUpPassengerAddress;

    /**
     * 接到乘客，乘客上车经度
     */
    private String pickUpPassengerLongitude;

    /**
     * 接到乘客，乘客上车纬度
     */
    private String pickUpPassengerLatitude;

    /**
     * 乘客下车经度
     */
    private String passengerGetoffLongitude;

    /**
     * 乘客下车纬度
     */
    private String passengerGetoffLatitude;

}
