package springbootjwt.tech.service.impl;

import org.springframework.stereotype.Service;
import springbootjwt.tech.exception.DataProcessingException;
import springbootjwt.tech.model.Role;
import springbootjwt.tech.repository.RoleRepository;
import springbootjwt.tech.service.RoleService;

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
