package com.yupi.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.common.RequestOptionEnum;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.InterfaceInfoMapper;
import com.yupi.yuapicommon.model.entity.InterfaceInfo;
import com.yupi.project.service.InterfaceInfoService;
import com.yupi.project.util.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author wangzhenzhou
 * @description 针对表【interface_info(接口信息)】的数据库操作Service实现
 * @createDate 2024-08-21 08:51:25
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
        implements InterfaceInfoService {

    /**
     * 校验Add Or Update的参数
     *
     * @param interfaceInfo
     * @param requestOptionEnum
     */
    @Override
    public void validAddOrUpdateInterfaceInfoRequest(InterfaceInfo interfaceInfo, RequestOptionEnum requestOptionEnum) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 要校验的参数应该是 几个Request类的并集属性
        Long id = interfaceInfo.getId();
        String name = interfaceInfo.getName();
        String description = interfaceInfo.getDescription();
        String url = interfaceInfo.getUrl();
        String requestParams = interfaceInfo.getRequestParams();
        String requestHeader = interfaceInfo.getRequestHeader();
        String responseHeader = interfaceInfo.getResponseHeader();
        Integer status = interfaceInfo.getStatus();
        String method = interfaceInfo.getMethod();
        // 创建时，所有参数必须非空。且还有范围校验
        if (requestOptionEnum.equals(RequestOptionEnum.Add)) {
            if (StringUtils.isAnyBlank(name, description, url, requestParams, responseHeader, method) ){
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        } else if(requestOptionEnum.equals(RequestOptionEnum.Update)) {
            if (id == null || CommonUtils.isOtherFieldsNull(interfaceInfo, "id")) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        // 对各个属性单独校验
        if (id != null && id < 1) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "id错误");
        }
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
        // 剩下是对参数的校验。。偷懒一下
    }
}




