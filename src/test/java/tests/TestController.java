package tests;


import com.andersen.maks.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class TestController {


    private MockMvc mockMvc;
    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }
    @Test
    public void testIndex() throws Exception{
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andDo(print());
    }

    @Test
    public void testCreateUser() throws Exception{
        this.mockMvc.perform(get("/addUser"))
                .andExpect(status().isOk())
                .andExpect(view().name("/createUser"))
                .andDo(print());
    }

}
