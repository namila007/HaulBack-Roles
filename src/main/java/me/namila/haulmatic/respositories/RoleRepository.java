package me.namila.haulmatic.respositories;

import me.namila.haulmatic.constants.enums.RoleType;
import me.namila.haulmatic.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoleRepository extends MongoRepository<Role, String> {

    public Role findByNic(String nic);

    public List<Role> findAllByOrganizationAndRoleType(String Organization, RoleType roleType);
}
