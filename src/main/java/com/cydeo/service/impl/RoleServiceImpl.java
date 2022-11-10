package com.cydeo.service.impl;

import com.cydeo.Mapper.RoleMapper;
import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import com.cydeo.repository.RoleRepository;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;// we need to get roles from db

    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;

        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDTO> listAllRoles() {
       List<Role> roleList= roleRepository.findAll();
        return roleList.stream().map(roleMapper::convertToDto).collect(Collectors.toList());

        //        controller called me and requesting all the RoleDTOs is it can show in the drop-down in the UI
//        I need to make a call to db and get all the roles from tables
//        Go to repo and find a service which gives me the roles from db
//        how I will call any service here?// DI
    }

    @Override
    public RoleDTO findById(Long id) {

        return roleMapper.convertToDto(roleRepository.findById(id).get());
    }
}
