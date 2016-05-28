package com.sample.app.web;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sample.app.EmployeeManagementSystemApplication;

/**
 * 一覧画面のJUnit。一覧画面Test
 * @author miyata
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EmployeeManagementSystemApplication.class)
@WebAppConfiguration
public class ListControllerTest {

	@Rule
	public final MockitoRule rule = MockitoJUnit.rule();
	
	@InjectMocks
    private ListController controller;
	
	private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    
    @Test
    public void 一覧画面の初期処理テスト() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/list"))
    			.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/login"));
    }

    @Test
    public void 詳細ボタン押下時のテスト() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.post("/detail"))
    			.andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void ログアウトボタン押下時のテスト() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/logout"))
    			.andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void 削除ボタン押下時のテスト() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/delete"))
    			.andDo(MockMvcResultHandlers.print());
    }
}
