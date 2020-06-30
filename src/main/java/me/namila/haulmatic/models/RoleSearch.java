package me.namila.haulmatic.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleSearch {
    private String firstName;
    private String lastName;
    private String nic;
}
