package com.qlb.shop.auth.mapper;

import com.qlb.shop.auth.common.SuperMapper;
import com.qlb.shop.auth.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: wzl
 * @CreateDate: 2019/9/29$ 10:20$
 */
@Mapper
public interface UserMapper extends SuperMapper<User> {
    List<User> queryUserByuserName(@Param("user") User user);

    List<User> list(User user);

}
