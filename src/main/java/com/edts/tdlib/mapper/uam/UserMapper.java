package com.edts.tdlib.mapper.uam;

import com.edts.tdlib.bean.uam.UserBean;
import com.edts.tdlib.mapper.EntityMapper;
import com.edts.tdlib.model.uam.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {}, imports = {})
public interface UserMapper extends EntityMapper<UserBean, User> {
    @Mappings({
            @Mapping(target = "roleId", source = "user.role.id"),
            @Mapping(target = "roleName", source = "user.role.name"),
            @Mapping(target = "firstName", source = "firstName"),
            @Mapping(target = "status", source = "status")
    })
    UserBean toDto(User user);
    User toEntity(UserBean userBean);
}
