package tests;

import com.andersen.maks.controller.UserController;
import org.junit.Before;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@WebAppConfiguration
public class UserSaveTest {
    private MockMvc mockMvc;
    @BeforeMethod
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }
        @Test
        public void testSave () throws Exception {
            mockMvc.perform(get("/addUser")
                    .param("name", "TestName")
                    .param("email", "test.feit@gmail.com")
                    .param("phoneNumber", "0994997855"))
                    .andExpect(handler().methodName("createUserPage"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("/createUser"))
                    .andExpect(forwardedUrl("/createUser"))
                    .andDo(print());
        }
    }

