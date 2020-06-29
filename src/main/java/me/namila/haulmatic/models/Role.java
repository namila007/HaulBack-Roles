package me.namila.haulmatic.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import me.namila.haulmatic.constants.enums.RoleType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Role Object")
public class Role {
    @Id
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, notes = "ID of the Object", position = 0)
    private UUID id = UUID.randomUUID();

    @ApiModelProperty(example = "Harry", notes = "Role's first name", required = true , position = 1)
    private String firstName;

    @ApiModelProperty(example = "Potter", value = "Role's Last name", required = true , position = 2)
    private String lastName;

    @ApiModelProperty(example = "Hogwarts", value = "Role's Organization", required = true , position = 3)
    private String organization;

    @ApiModelProperty(example = "2636437372v", value = "Role's NIC number", required = true , position = 4)
    private String nic;

    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, value = "Role Created Date and Time", position = 6)
    @CreatedDate
    private Date createdDate;

    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, value = "Role's Last Modified Date and Time ", position = 7)
    @LastModifiedDate
    private Date lastModifiedDate;

    @ApiModelProperty(example = "DRIVER", value = "Role's Last name", required = true , position = 5, allowableValues = "DRIVER,ASSISTANT")
    private RoleType roleType;

    @Override
    public String toString() {
        return String.format("Role[id=%s, firstName='%s', lastName='%s', organization='%s', nic='%s', roleType='%s', createdAt='%s'" +
                "updatedAt='%s']",id,firstName,lastName,organization,nic,roleType,createdDate,lastModifiedDate);
    }

}
