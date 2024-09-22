package com.yupi.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.common.RequestOptionEnum;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.UserInterfaceInfoMapper;
import com.yupi.project.service.UserInterfaceInfoService;
import com.yupi.project.util.CommonUtils;
import com.yupi.yuapicommon.model.entity.UserInterfaceInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

/**
* @author wangzhenzhou
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2024-08-21 08:51:44
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, RequestOptionEnum requestOptionEnum) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 要校验的参数应该是 几个Request类的并集属性
        Long id = userInterfaceInfo.getId();
        Long userId = userInterfaceInfo.getUserId();
        Long interfaceInfoId = userInterfaceInfo.getInterfaceInfoId();
        Integer totalNum = userInterfaceInfo.getTotalNum();
        Integer leftNum = userInterfaceInfo.getLeftNum();
        Integer status = userInterfaceInfo.getStatus();

        // 创建时，指定一些参数必须非空。
        if (requestOptionEnum.equals(RequestOptionEnum.Add)) {
            if (ObjectUtils.anyNull(userId,interfaceInfoId,totalNum,leftNum)){
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"存在空参数");
            }
        } else if(requestOptionEnum.equals(RequestOptionEnum.Update)) {
            if (id == null || CommonUtils.isOtherFieldsNull(userInterfaceInfo, "id")) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "id错误");
            }
        }
        //剩下是对参数的校验。。偷懒一下
        if (id != null && id < 1) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "id错误");
        }
        if (userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
        }
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于 0");
        }
    }

//    @Override
//    public boolean invokeCount(long interfaceInfoId, long userId) {
//        // 判断
//        if (interfaceInfoId <= 0 || userId <= 0) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        // todo 这里应该加单机锁保护，防止多个线程同时修改
//        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
//        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
//        updateWrapper.eq("userId", userId);
//
////        updateWrapper.gt("leftNum", 0);
//        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
//        return this.update(updateWrapper);
//    }
}




