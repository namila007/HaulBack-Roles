package me.namila.haulmatic.services;

import me.namila.haulmatic.constants.enums.RoleType;
import me.namila.haulmatic.models.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {
    public Role addRole(Role role);
    public Role updateRole(Role role) throws RuntimeException;
    public Role deleteRoleById(String id) throws RuntimeException;
    public Role deleteRoleByNic(String nic) throws RuntimeException;
    public Role getRoleById(String id) throws RuntimeException;
    public Role getRoleByNic(String nic) throws RuntimeException;
    public Page<Role> getAllRole(Pageable pageable);
    public List<Role> getRolesByOrganizationAndRoleType(String organization, RoleType roleType) throws RuntimeException;
}
