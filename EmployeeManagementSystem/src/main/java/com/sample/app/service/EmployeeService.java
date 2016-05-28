package com.sample.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.app.domain.EmployeeInfo;
import com.sample.app.enums.IsDeleted;

@Service
@Transactional
public class EmployeeService {

	/**
	 * JdbcTemplate宣言
	 */
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	private static final RowMapper<EmployeeInfo> employeeRowMapper = (rs, i) -> {
		String abbreviation = rs.getString("abbreviation");
		String employeeId = rs.getString("employee_id");	
		String department = rs.getString("department");
		String name = rs.getString("name");
		String nameHiragana = rs.getString("name_hiragana");
		String birthday = rs.getString("birthday");
		String sex = rs.getString("sex");
		String mailAddress = rs.getString("mail_address");
		String telephoneNumber = rs.getString("telephone_number");
		String companyInfoId = rs.getString("company_info_id");
		String businessManager = rs.getString("business_manager");
		String commissioningStatus = rs.getString("commissioning_status");
		String enterDate = rs.getString("enter_date");
		String retireDate = rs.getString("retire_date");
		String status = rs.getString("status");
		return new EmployeeInfo(abbreviation, employeeId, department, name, nameHiragana,
				birthday, sex, mailAddress, telephoneNumber, companyInfoId, 
				businessManager, enterDate, retireDate, commissioningStatus, status);
	};
	
	/**
	 * 社員情報テーブルのレコード取得
	 * @param empId
	 * @return 社員情報
	 */
	public List<EmployeeInfo> find(String empId) {
		/*
		 * SQL文
		 */
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT c.abbreviation, ei.department, ei.employee_id, ei.name, ei.name_hiragana, ");
		sql.append("ei.birthday, ei.sex, ei.mail_address, ei.telephone_number, ");
		sql.append("ei.company_info_id, ei.business_manager, ei.commissioning_status, ");
		sql.append("es.enter_date, es.retire_date, es.status ");
		sql.append("FROM employee_info ei ");
		sql.append("JOIN employee_state es ON (ei.employee_id=es.employee_info_id) ");
		sql.append("JOIN company_info c ON (ei.company_info_id=c.company_id) ");
		sql.append("WHERE ei.employee_id=:empId AND ei.is_deleted= ");
		sql.append(IsDeleted.EXIST.ordinal());
		sql.append(" ");
		sql.append("AND es.is_deleted= ");
		sql.append(IsDeleted.EXIST.ordinal());
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("empId", empId);
		
		return jdbcTemplate.query(sql.toString(), param, employeeRowMapper);
	}

	/**
	 * 社員情報テーブルのレコードを全て取得
	 * @return 社員情報
	 */
	public List<EmployeeInfo> findAll() {
		/*
		 * SQL文
		 */
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT c.abbreviation, ei.department, ei.employee_id, ei.name, ei.name_hiragana, ");
		sql.append("ei.birthday, ei.sex, ei.mail_address, ei.telephone_number, ");
		sql.append("ei.company_info_id, ei.business_manager, ei.commissioning_status, ");
		sql.append("es.enter_date, es.retire_date, es.status ");
		sql.append("FROM employee_info ei ");
		sql.append("JOIN employee_state es ON (ei.employee_id=es.employee_info_id) ");
		sql.append("JOIN company_info c ON (ei.company_info_id=c.company_id)");
		sql.append("WHERE ei.is_deleted=0 AND es.is_deleted= ");
		sql.append(IsDeleted.EXIST.ordinal());
		sql.append(" ");
		sql.append("ORDER BY ei.employee_id ASC");
		
		return jdbcTemplate.query(sql.toString(), employeeRowMapper);
	}
	
	/**
	 * 社員情報テーブル新規登録
	 * @param employee
	 * @param loginId
	 */
	public void add(EmployeeInfo employee, String loginId) {
		/*
		 * SQL文
		 * 社員情報テーブル追加
		 */
		StringBuilder sql1 = new StringBuilder();
		sql1.append("INSERT INTO employee_info(name, name_hiragana, birthday, sex, ");
		sql1.append("mail_address, telephone_number, company_info_id, business_manager, ");
		sql1.append("department, commissioning_status, created_id, modified_id) ");
		sql1.append("VALUES(:name, :name_hiragana, :birthday, :sex, :mail_address, :telephone_number, ");
		sql1.append(":company_info_id, :business_manager, :department, :commissioning_status, ");
		sql1.append(":created_id, :modified_id)");
		SqlParameterSource param1 = new MapSqlParameterSource()
				.addValue("name", employee.getName())
				.addValue("name_hiragana", employee.getNameHiragana())
				.addValue("birthday", employee.getBirthday())
				.addValue("sex", employee.getSex())
				.addValue("mail_address", employee.getMailAddress())
				.addValue("telephone_number", employee.getTelephoneNumber())
				.addValue("company_info_id", employee.getCompanyInfoId())
				.addValue("business_manager", employee.getBusinessManager())
				.addValue("department", employee.getDepartment())
				.addValue("commissioning_status", employee.getCommissioningStatus())
				.addValue("created_id", loginId)
				.addValue("modified_id", loginId);
		jdbcTemplate.update(sql1.toString(), param1);

		/*
		 * SQL文
		 * 新規追加した社員ID取得
		 */
		String sql2 = "SELECT employee_id FROM employee_info WHERE name=:name";
		SqlParameterSource param2 = new MapSqlParameterSource()
				.addValue("name", employee.getName());
		int empId = jdbcTemplate.queryForObject(sql2.toString(), param2, Integer.class);

		/*
		 * SQL文
		 * 社員状況テーブル追加
		 */
		StringBuilder sql3 = new StringBuilder();
		sql3.append("INSERT INTO employee_state(employee_info_id, enter_date, retire_date, ");
		sql3.append("status, created_id, modified_id) ");
		sql3.append("VALUES(:employee_info_id, :enter_date, :retire_date, :status, :created_id, :modified_id)");
		SqlParameterSource param3 = new MapSqlParameterSource()
				.addValue("employee_info_id", empId)
				.addValue("enter_date", employee.getEnterDate())
				.addValue("retire_date", employee.getRetireDate())
				.addValue("status", employee.getStatus())
				.addValue("created_id", loginId)
				.addValue("modified_id", loginId);
		jdbcTemplate.update(sql3.toString(), param3);
	}
	
	/**
	 * 社員情報テーブル更新
	 * @param employee
	 * @param loginId
	 */
	public void update(EmployeeInfo employee, String loginId) {	
		/*
		 * SQL文
		 * 社員情報テーブル更新
		 */
		StringBuilder sql1 = new StringBuilder();
		sql1.append("UPDATE employee_info SET name=:name, name_hiragana=:name_hiragana, birthday=:birthday, ");
		sql1.append("sex=:sex, mail_address=:mail_address, telephone_number=:telephone_number, company_info_id=:company_info_id, ");
		sql1.append("business_manager=:business_manager, department=:department, commissioning_status=:commissioning_status, ");
		sql1.append("modified_id=:modified_id ");
		sql1.append("WHERE employee_id=:employee_id");
		SqlParameterSource param1 = new MapSqlParameterSource()
				.addValue("name", employee.getName())
				.addValue("name_hiragana", employee.getNameHiragana())
				.addValue("birthday", employee.getBirthday())
				.addValue("sex", employee.getSex())
				.addValue("mail_address", employee.getMailAddress())
				.addValue("telephone_number", employee.getTelephoneNumber())
				.addValue("company_info_id", employee.getCompanyInfoId())
				.addValue("business_manager", employee.getBusinessManager())
				.addValue("department", employee.getDepartment())
				.addValue("commissioning_status", employee.getCommissioningStatus())
				.addValue("modified_id", loginId)
				.addValue("employee_id", employee.getEmployeeId());
		jdbcTemplate.update(sql1.toString(), param1);

		/*
		 * SQL文
		 * 社員状況テーブル更新
		 */
		StringBuilder sql2 = new StringBuilder();
		sql2.append("UPDATE employee_state SET enter_date=:enter_date, retire_date=:retire_date, ");
		sql2.append("status=:status, modified_id=:modified_id ");
		sql2.append("WHERE employee_info_id=:employee_info_id");
		SqlParameterSource param2 = new MapSqlParameterSource()
				.addValue("enter_date", employee.getEnterDate())
				.addValue("retire_date", employee.getRetireDate())
				.addValue("status", employee.getStatus())
				.addValue("modified_id", loginId)
				.addValue("employee_info_id", employee.getEmployeeId());
		jdbcTemplate.update(sql2.toString(), param2);
	}

	/**
	 * 社員情報テーブル削除
	 * @param empId
	 */
	public void delete(String empId) {
		/*
		 * SQL文
		 * 社員情報テーブルから削除
		 */
		StringBuilder sql1 = new StringBuilder();
		sql1.append("UPDATE employee_info SET is_deleted=");
		sql1.append(IsDeleted.DELETE.ordinal());
		sql1.append(" ");
		sql1.append("WHERE employee_id=:empId");

		/*
		 * SQL文
		 * 社員状況テーブルから削除
		 */
		StringBuilder sql2 = new StringBuilder();
		sql2.append("UPDATE employee_state SET is_deleted=");
		sql2.append(IsDeleted.DELETE.ordinal());
		sql2.append(" ");
		sql2.append("WHERE employee_info_id=:empId");

		/*
		 * SQL実行
		 */
		SqlParameterSource param = new MapSqlParameterSource().addValue("empId", empId);
		jdbcTemplate.update(sql1.toString(), param);
		jdbcTemplate.update(sql2.toString(), param);
	}
}
