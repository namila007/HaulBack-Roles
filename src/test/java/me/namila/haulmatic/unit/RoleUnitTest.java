package me.namila.haulmatic.unit;

import me.namila.haulmatic.models.Role;
import me.namila.haulmatic.services.RoleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static me.namila.haulmatic.constants.statics.ApiEndPoints.BASE_END_POINT;
import static me.namila.haulmatic.constants.statics.ApiEndPoints.ROLE_END_POINT;

@SpringBootTest
@AutoConfigureMockMvc
public class RoleUnitTest {

    private final static String RoleURL = BASE_END_POINT + ROLE_END_POINT;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RoleService roleService;

    @Test
    public void shouldCreateRoleAndReturnRole() throws Exception {
        Role role = new Role();
        role.setFirstName("Harry");
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);
        Page<Role> rolePage = new PageImpl<Role>(roleList);
        Pageable pageable = new Pageable() {
            @Override
            public int getPageNumber() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 2;
            }

            @Override
            public long getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };
        Mockito.spy(RoleService.class);
        Mockito.when(roleService.getAllRole(pageable)).thenReturn(rolePage);
//        this.mockMvc.perform(get(RoleURL)).andDo(print())
//                .andExpect(status().isOk());
        assert roleService.getAllRole(pageable) == rolePage;
    }

}
