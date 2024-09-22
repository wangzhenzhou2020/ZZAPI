package com.yupi.project.util;

import com.yupi.yuapicommon.model.entity.User;
import com.yupi.project.model.vo.UserVO;
import org.springframework.beans.BeanUtils;

public class DomainToVOUtils {
    public static UserVO userToUserVO(User user){
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);
        return userVO;
    }
}
