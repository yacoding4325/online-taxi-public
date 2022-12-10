package com.yacoding.apiDriver.service;
;
import com.yacoding.apiDriver.remote.ServiceDriverUserClient;
import com.yacoding.internalcommon.dto.DriverCarBindingRelationship;
import com.yacoding.internalcommon.dto.DriverUser;
import com.yacoding.internalcommon.dto.DriverUserWorkStatus;
import com.yacoding.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yaCoding
 * @create 2022-11-24 上午 8:33
 */
@Service
public class UserService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult updateUser(DriverUser driverUser){
        return serviceDriverUserClient.updateUser(driverUser);
    }

    public ResponseResult changeWorkStatus(DriverUserWorkStatus driverUserWorkStatus) {
        return serviceDriverUserClient.changeWorkStatus(driverUserWorkStatus);
    }

    public ResponseResult<DriverCarBindingRelationship> getDriverCarBindingRelationship(String driverPhone){
        // 根据driverPhone查询司机信息
        return serviceDriverUserClient.getDriverCarRelationShip(driverPhone);
    }

}

