package com.edts.tdlib.mapper.uam;


import com.edts.tdlib.bean.uam.RoleBean;
import com.edts.tdlib.mapper.EntityMapper;
import com.edts.tdlib.model.uam.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {}, imports = {})
public interface RoleMapper extends EntityMapper<RoleBean, Role> {

    RoleBean toDto(Role role);
    Role toEntity(RoleBean roleBean);
}
