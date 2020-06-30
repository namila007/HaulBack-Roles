package me.namila.haulmatic.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.namila.haulmatic.constants.enums.RoleType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Role Object")
@Document(collection = "role")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role {

    @ApiModelProperty(notes = "ID of the Object", position = 0, readOnly = true)
    @Id
    private String id;

    @ApiModelProperty(example = "Harry", notes = "Role's first name", required = true, position = 1)
    private String firstName;

    @ApiModelProperty(example = "Potter", value = "Role's Last name", required = true, position = 2)
    private String lastName;

    @ApiModelProperty(example = "Hogwarts", value = "Role's Organization", required = true, position = 3)
    private String organization;

    @ApiModelProperty(example = "2636437372v", value = "Role's NIC number", required = true, position = 4)
    @Indexed(name = "nic_index", unique = true, direction = IndexDirection.ASCENDING)
    private String nic;

    @ApiModelProperty(value = "Role Created Date and Time", position = 6, readOnly = true)
    @CreatedDate
    private Date createdDate;

    @ApiModelProperty(value = "Role's Last Modified Date and Time ", position = 7, readOnly = true)
    @LastModifiedDate
    private Date lastModifiedDate;

    @ApiModelProperty(example = "DRIVER", value = "Role's Last name", required = true , position = 5, allowableValues = "DRIVER,ASSISTANT")
    private RoleType roleType;

    @Override
    public String toString() {
        return String.format("Role[id=%s, firstName='%s', lastName='%s', organization='%s', nic='%s', roleType='%s', createdDate='%s'" +
                "updatedAt='%s']", id, firstName, lastName, organization, nic, roleType, createdDate, lastModifiedDate);
    }

}
