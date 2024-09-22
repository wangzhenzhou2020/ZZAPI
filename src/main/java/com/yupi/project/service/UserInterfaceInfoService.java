package com.yupi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.project.common.RequestOptionEnum;
import com.yupi.yuapicommon.model.entity.UserInterfaceInfo;

/**
* @author wangzhenzhou
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2024-08-21 08:51:44
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, RequestOptionEnum requestOptionEnum);

//    public boolean invokeCount(long interfaceInfoId, long userId);

}
