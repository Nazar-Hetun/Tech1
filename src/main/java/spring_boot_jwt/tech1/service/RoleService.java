package spring_boot_jwt.tech1.service;

import spring_boot_jwt.tech1.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getRoleByName(String role);
}
