package com.sample.app.service;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.List;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.csv.CsvDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sample.app.EmployeeManagementSystemApplication;
import com.sample.app.domain.EmployeeInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EmployeeManagementSystemApplication.class)
@WebAppConfiguration
public class EmployeeServiceTest {

	private IDatabaseTester databaseTester;

	@Autowired
	EmployeeService employeeService = new EmployeeService();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost/employee_management_system?useUnicode=true&characterEncoding=utf8", "root",
				"root");

		databaseTester.setDataSet(new CsvDataSet(new File("./DBUnit/employee_info")));
		databaseTester.setSetUpOperation(DatabaseOperation.INSERT);
		databaseTester.onSetup();
	}

	@After
	public void tearDown() throws Exception {
		databaseTester.setTearDownOperation(DatabaseOperation.DELETE);
		databaseTester.onTearDown();
	}

	@Test
	public void 社員情報テーブルからレコード1件検索() throws Exception {
		String empId = "87";
		EmployeeInfo employee = null;
		try {
			employee = employeeService.find(empId).get(0);
		} catch (IndexOutOfBoundsException ex) {
		}

		assertThat(employee, is(notNullValue()));
	}

	@Test
	public void 社員情報テーブルからレコード検索() throws Exception {
		List<EmployeeInfo> employee = null;
		try {
			employee = employeeService.findAll();
		} catch (IndexOutOfBoundsException ex) {
		}

		assertThat(employee, is(notNullValue()));
	}
}
