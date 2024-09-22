package com.yupi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.project.common.RequestOptionEnum;
import com.yupi.yuapicommon.model.entity.InterfaceInfo;

/**
* @author wangzhenzhou
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-08-21 08:51:25
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 新增或更新参数校验
     * @param interfaceInfo
     * @param requestOptionEnum
     */
    void validAddOrUpdateInterfaceInfoRequest(InterfaceInfo interfaceInfo, RequestOptionEnum requestOptionEnum);
}
