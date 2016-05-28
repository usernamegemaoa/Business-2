package com.sample.app.logic;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeLogicTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
 
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
 
	@Before
	public void setUp() throws Exception {
	}
 
	@After
	public void tearDown() throws Exception {
	}
 
	@Test
	public void 年月日フォーマットのテスト() {
		EmployeeLogic logic = new EmployeeLogic();
		assertThat(logic.formatDate("1990-01-01"), is("1990/01/01"));
		assertThat(logic.formatDate("2016-04-01"), is("2016/04/01"));
	}
	
	@Test
	public void 誕生日から年齢算出のテスト() {
		EmployeeLogic logic = new EmployeeLogic();
		assertThat(logic.formatAge("2000-04-01"), is("16"));		
		assertThat(logic.formatAge("1994-01-24"), is("22"));	
	}
}
