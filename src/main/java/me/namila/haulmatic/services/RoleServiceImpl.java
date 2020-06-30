package me.namila.haulmatic.services;

import lombok.NoArgsConstructor;
import me.namila.haulmatic.constants.enums.RoleType;
import me.namila.haulmatic.exceptionHandler.exceptions.ResourceNotFoundException;
import me.namila.haulmatic.models.Role;
import me.namila.haulmatic.models.RoleSearch;
import me.namila.haulmatic.respositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role, String id) throws RuntimeException {

        Optional<Role> originalRole = roleRepository.findById(id);
        originalRole.ifPresent(role1 -> {
            if (!role.getFirstName().isEmpty()) role1.setFirstName(role.getFirstName());
            if (!role.getLastName().isEmpty()) role1.setLastName(role.getLastName());
            if (!role.getOrganization().isEmpty()) role1.setOrganization(role.getOrganization());
            if (!role.getNic().isEmpty()) role1.setNic(role.getNic());
            if (!role.getRoleType().name().isEmpty()) role1.setRoleType(role.getRoleType());
            role1.setLastModifiedDate(new Date());
        });
        originalRole.orElseThrow(() -> new ResourceNotFoundException("Role ID: " + id + " Not found"));
        return roleRepository.save(originalRole.get());
    }

    @Override
    public Role deleteRoleById(String id) throws RuntimeException {
        Optional<Role> originalRole = roleRepository.findById(id);
        originalRole.ifPresent( role1 -> {
            roleRepository.delete(role1);
        });
        originalRole.orElseThrow(()-> new ResourceNotFoundException("Role ID: "+id +" Not found"));
        return originalRole.get();
    }

    @Override
    public Role deleteRoleByNic(String nic) throws RuntimeException {
        Optional<Role> originalRole = Optional.ofNullable(roleRepository.findByNic(nic));
        originalRole.ifPresent( role1 -> {
            roleRepository.delete(role1);
        });
        originalRole.orElseThrow(()-> new ResourceNotFoundException("Role with NIC : "+nic +" Not found"));
        return originalRole.get();
    }

    @Override
    public Role getRoleById(String id) throws RuntimeException {
        Optional<Role> originalRole = roleRepository.findById(id);
        if(originalRole.isPresent()) return originalRole.get();
        else throw new ResourceNotFoundException("Role ID: "+id +" Not found");
    }

    @Override
    public Role getRoleByNic(String nic) throws RuntimeException {
        Optional<Role> originalRole = Optional.ofNullable(roleRepository.findByNic(nic));
        if(originalRole.isPresent()) return originalRole.get();
        else throw new ResourceNotFoundException("Role with NIC: "+nic +" Not found");
    }

    @Override
    public List<RoleSearch> getRolesByOrganizationAndRoleType(String organization, RoleType roleType) throws RuntimeException {
        List<RoleSearch> roleSearch = new ArrayList<>();
        Optional<List<Role>> roleList = Optional.ofNullable(roleRepository.findAllByOrganizationAndRoleType(organization, roleType));
        if (roleList.isPresent()) {
            roleList.get().forEach(role -> {
                RoleSearch roleSearch1 = new RoleSearch();
                roleSearch1.setFirstName(role.getFirstName());
                roleSearch1.setLastName(role.getFirstName());
                roleSearch1.setNic(role.getNic());
                roleSearch.add(roleSearch1);
            });
            return roleSearch;
        } else
            throw new ResourceNotFoundException("Roles Not Found for Org:" + organization + " and RoleType: " + roleType);
    }

    @Override
    public Page<Role> getAllRole(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }
}
