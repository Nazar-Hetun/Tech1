package springbootjwt.tech.service;

import springbootjwt.tech.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getRoleByName(String role);
}
