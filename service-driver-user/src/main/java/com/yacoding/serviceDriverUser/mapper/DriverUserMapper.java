package com.yacoding.serviceDriverUser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yacoding.internalcommon.dto.DriverUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author yaCoding
 * @create 2022-11-22 下午 11:04
 */

@Repository
public interface DriverUserMapper extends BaseMapper<DriverUser> {

    public int selectDriverUserCountByCityCode(@Param("cityCode") String cityCode);

}

