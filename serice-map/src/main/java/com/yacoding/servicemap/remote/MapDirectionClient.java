package com.yacoding.servicemap.remote;

import com.yacoding.internalcommon.constant.AmapConfigConstants;
import com.yacoding.internalcommon.dto.ResponseResult;
import com.yacoding.internalcommon.responese.DirectionResponse;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//https://restapi.amap.com/v3/direction/driving?origin=116.45925,39.910031&destination=116.587922,40.081577&output=json&key=a509233cb5a717b62f3430d3760ced92
@Service
@Slf4j
public class MapDirectionClient {

    @Value("${amap.key}")
    private String amapKey;

    @Autowired
    private RestTemplate restTemplate;

    public DirectionResponse direction(String depLongitude, String depLatitude, String destLongitude, String destLatitude){
        // 组装请求调用url
        StringBuilder urlBuild = new StringBuilder();
        urlBuild.append(AmapConfigConstants.DIRECTION_URL);
        urlBuild.append("?");
        urlBuild.append("origin="+depLongitude+","+depLatitude);
        urlBuild.append("&");
        urlBuild.append("destination="+destLongitude+","+destLatitude);
        urlBuild.append("&");
        urlBuild.append("extensions=base");
        urlBuild.append("&");
        urlBuild.append("output=json");
        urlBuild.append("&");
        urlBuild.append("key="+amapKey);
        log.info(urlBuild.toString());
        // 调用高德接口
        log.info("高德地图：路径规划，请求信息："+urlBuild.toString());
        ResponseEntity<String> directionEntity = restTemplate.getForEntity(urlBuild.toString(), String.class);
        String directionString = directionEntity.getBody();
        log.info("高德地图：路径规划，返回信息："+directionString);
        // 解析接口
        DirectionResponse directionResponse = parseDirectionEntity(directionString);
        return directionResponse;
    }

    private DirectionResponse parseDirectionEntity(String directionString){
        DirectionResponse directionResponse = null;
        try {
            // 最外层
            JSONObject result = JSONObject.fromObject(directionString);
            if(result.has(AmapConfigConstants.STATUS)) {
                int status = result.getInt(AmapConfigConstants.STATUS);
                if (status == 1){
                    if (result.has(AmapConfigConstants.ROUTE)){
                        JSONObject routeObject = result.getJSONObject(AmapConfigConstants.ROUTE);
                        JSONArray pathsArray = routeObject.getJSONArray(AmapConfigConstants.PATHS);
                        JSONObject pathObject = pathsArray.getJSONObject(0);
                        directionResponse = new DirectionResponse();

                        if (pathObject.has(AmapConfigConstants.DISTANCE)){
                            int distance = pathObject.getInt(AmapConfigConstants.DISTANCE);
                            directionResponse.setDistance(distance);
                        }
                        if (pathObject.has(AmapConfigConstants.DURATION)){
                            int duration = pathObject.getInt(AmapConfigConstants.DURATION);
                            directionResponse.setDuration(duration);
                        }
                    }
                }
            }

        }catch (Exception e){
        }
        return directionResponse;
    }
}
