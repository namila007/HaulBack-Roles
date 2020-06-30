package me.namila.haulmatic.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel
public class RoleSearch {
    @ApiModelProperty(value = "First Name", example = "Harry")
    private String firstName;
    @ApiModelProperty(value = "Last Name", example = "Potter")
    private String lastName;
    @ApiModelProperty(value = "NIC Number", example = "93432345v")
    private String nic;
}
