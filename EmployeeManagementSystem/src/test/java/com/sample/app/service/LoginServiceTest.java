package com.sample.app.service;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.File;

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
import com.sample.app.domain.LoginInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EmployeeManagementSystemApplication.class)
@WebAppConfiguration
public class LoginServiceTest {

	private IDatabaseTester databaseTester;

	@Autowired
	LoginService service = new LoginService();

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

		databaseTester.setDataSet(new CsvDataSet(new File("./DBUnit/login_info")));
		databaseTester.setSetUpOperation(DatabaseOperation.INSERT);
		databaseTester.onSetup();
	}

	@After
	public void tearDown() throws Exception {
		databaseTester.setTearDownOperation(DatabaseOperation.DELETE);
		databaseTester.onTearDown();
	}

	@Test
	public void ログイン情報テーブルからレコード1件検索() throws Exception {
		LoginInfo login = null;
		try {
			login = service.find("testuser", "testuser").get(0);
		} catch (IndexOutOfBoundsException ex) {

		}
		assertThat(login, is(notNullValue()));
		assertThat(login.getLoginId(), is("testuser"));
	}
}
