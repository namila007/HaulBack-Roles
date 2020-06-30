package me.namila.haulmatic.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.namila.haulmatic.constants.enums.RoleType;
import me.namila.haulmatic.models.Role;
import me.namila.haulmatic.models.RoleSearch;
import me.namila.haulmatic.response.ResponseWrapper;
import me.namila.haulmatic.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static me.namila.haulmatic.constants.statics.ApiEndPoints.*;

@RestController
@RequestMapping(BASE_END_POINT + ROLE_END_POINT)
@Api(value = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Role.")
public class RoleController {


    private RoleService roleService;

    @GetMapping(value = ID_VARIABLE)
    @ApiOperation(value = "Return a Role by ID", produces = "application/json")
    public ResponseWrapper<Role> getRoleById(@PathVariable(value = "id") String id) throws Exception {
        return new ResponseWrapper<>(roleService.getRoleById(id), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create a new Role", produces = "application/json")
    public ResponseWrapper<Role> createRole(@RequestBody Role role) throws Exception {
        return new ResponseWrapper<>(roleService.addRole(role), HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Returns list of all Roles in the system.", produces = "application/json")
    public ResponseWrapper<Page<Role>> getAllRoles(Pageable pageable) throws Exception {
        return new ResponseWrapper<>(roleService.getAllRole(pageable), HttpStatus.OK);
    }

    @GetMapping(value = NIC_END_POINT + ID_VARIABLE)
    @ApiOperation(value = "Return a Role by NIC", produces = "application/json")
    public ResponseWrapper<Role> getRoleByNIC(@PathVariable(value = "id") String id) throws Exception {
        return new ResponseWrapper<>(roleService.getRoleByNic(id), HttpStatus.OK);
    }

    @PutMapping(value = ID_VARIABLE)
    @ApiOperation(value = "Update a Role by ID", produces = "application/json")
    public ResponseWrapper<Role> updateRole(@RequestBody Role role, @PathVariable(value = "id") String id) throws Exception {
        return new ResponseWrapper<>(roleService.updateRole(role, id), HttpStatus.OK);
    }

    @DeleteMapping(value = ID_VARIABLE)
    @ApiOperation(value = "Delete a Role by ID", produces = "application/json")
    public ResponseWrapper<Role> deleteRoleById(@PathVariable(value = "id") String id) throws Exception {
        return new ResponseWrapper<>(roleService.deleteRoleById(id), HttpStatus.OK);
    }

    @GetMapping(value = SEARCH_END_POINT)
    @ApiOperation(value = "Search  Roles by Organization and RoleType", produces = "application/json")
    public ResponseWrapper<List<RoleSearch>> findRolesByOrgAndType(@RequestParam(value = ORGANIZATION_VARIABLE) String org, @RequestParam(value = ROLETYPE_VARIABLE) RoleType type) throws Exception {
        return new ResponseWrapper<>(roleService.getRolesByOrganizationAndRoleType(org, type), HttpStatus.OK);

    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
