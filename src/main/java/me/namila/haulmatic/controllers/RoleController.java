package me.namila.haulmatic.controllers;

import me.namila.haulmatic.models.Role;
import me.namila.haulmatic.response.ResponseWrapper;
import me.namila.haulmatic.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping(value = {"/{id}"})
    public ResponseWrapper<Role> getRoleById(@PathVariable (value = "id") String id) throws Exception {
        return new ResponseWrapper<>(roleService.getRoleById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseWrapper<Role> createRole(@RequestBody Role role) throws Exception {
        return new ResponseWrapper<>(roleService.addRole(role),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseWrapper<Page<Role>> getAllRoles(Pageable pageable) throws Exception {
        return new ResponseWrapper<>(roleService.getAllRole(pageable), HttpStatus.OK);
    }


}
