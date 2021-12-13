package spring_boot_jwt.tech1.service.impl;

import org.springframework.stereotype.Service;
import spring_boot_jwt.tech1.exception.DataProcessingException;
import spring_boot_jwt.tech1.model.Role;
import spring_boot_jwt.tech1.repository.RoleRepository;
import spring_boot_jwt.tech1.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.getRoleByName(name).orElseThrow(
                () -> new DataProcessingException("Role with name " + name + " don't exist"));
    }
}
