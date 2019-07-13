/*
 * Copyright (C) 2011 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.itsol.eas.dao;

import com.itsol.eas.bo.Intern05EmployeeBO;
import com.itsol.eas.dto.Intern05CitiesDTO;
import com.itsol.eas.dto.Intern05EmployeeDTO;
import com.itsol.eas.dto.Intern05EthnicDTO;
import com.viettel.service.base.dao.BaseFWDAOImpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.FloatType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

/**
 * @author BuiBaTruong
 * @version 1.0
 * @since 08-May-15 4:07 PM
 */
@Repository("intern05EmployeeDAO")
@SuppressWarnings("unchecked")
public class Intern05EmployeeDAO extends BaseFWDAOImpl<Intern05EmployeeBO, Long> {

	public Intern05EmployeeDAO() {
		this.model = new Intern05EmployeeBO();
	}

	public Intern05EmployeeDAO(Session session) {
		this.session = session;
	}

	public List<Intern05EmployeeDTO> getAll() {
		StringBuilder sql = new StringBuilder("SELECT 														");
		sql.append("								EM.EM_ID emId, 											");
		sql.append("								EM.EM_FIRSTNAME emFirstname,							");
		sql.append("								EM.EM_LASTNAME emLastname,								");
		sql.append("								EM.EM_BIRTHDAY emBirthday,								");
		sql.append("								EM.EM_HOMETOWN emHometown,								");
		sql.append("								EM.EM_SEX emSex,										");
		sql.append("								EM.EM_ETHNIC emEthnic,									");
		sql.append("								EM.EM_PHONE emPhone,									");
		sql.append("								EM.EM_STARTEDDATE emStarteddate,						");
		sql.append("								EM.DE_ID deId,											");
		sql.append("								EM.PO_ID poId,											");
		sql.append("								EM.LI_ID liId,											");
		sql.append("								EM.SA_LEVEL saLevel,									");
		sql.append("								LI.LI_NAME liName,										");
		sql.append("								PO.PO_NAME poName,										");
		sql.append("								DE.DE_NAME deName,										");
		sql.append("								SA.SA_BASIC saBasic,									");
		sql.append("								SA.SA_COEFFICIENT saCoefficient,						");
		sql.append("								SA.SA_ALLOWANCECOEFFICIENT saAllowanceCoefficient		");
		sql.append("  						   FROM 														");
		sql.append("  								INTERN05_EMPLOYEE EM 									");
		sql.append("						   JOIN    INTERN05_LITERACY LI ON EM.LI_ID = LI.LI_ID  		");
		sql.append("						   JOIN    INTERN05_POSITION PO ON EM.PO_ID = PO.PO_ID 			");
		sql.append("						   JOIN    INTERN05_DEPARTMENT DE ON EM.DE_ID = DE.DE_ID		");
		sql.append("						   JOIN    INTERN05_SALARY SA ON EM.SA_LEVEL = SA.SA_LEVEL		");
		sql.append("						   ORDER BY EM.EM_ID ASC										");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("emId", new LongType());
		query.addScalar("emFirstname", new StringType());
		query.addScalar("emLastname", new StringType());
		query.addScalar("emBirthday", new DateType());
		query.addScalar("emHometown", new StringType());
		query.addScalar("emSex", new LongType());
		query.addScalar("emEthnic", new StringType());
		query.addScalar("emPhone", new StringType());
		query.addScalar("emStarteddate", new DateType());
		query.addScalar("deId", new LongType());
		query.addScalar("poId", new LongType());
		query.addScalar("liId", new LongType());
		query.addScalar("saLevel", new LongType());
		query.addScalar("liName", new StringType());
		query.addScalar("poName", new StringType());
		query.addScalar("deName", new StringType());
		query.addScalar("saBasic", new FloatType());
		query.addScalar("saCoefficient", new FloatType());
		query.addScalar("saAllowanceCoefficient", new FloatType());

		query.setResultTransformer(Transformers.aliasToBean(Intern05EmployeeDTO.class));
		return query.list();
	}

	public Intern05EmployeeDTO getOneById(Long id) {
		StringBuilder sql = new StringBuilder("SELECT 														");
		sql.append("								EM.EM_ID emId, 											");
		sql.append("								EM.EM_FIRSTNAME emFirstname,							");
		sql.append("								EM.EM_LASTNAME emLastname,								");
		sql.append("								EM.EM_BIRTHDAY emBirthday,								");
		sql.append("								EM.EM_HOMETOWN emHometown,								");
		sql.append("								EM.EM_SEX emSex,										");
		sql.append("								EM.EM_ETHNIC emEthnic,									");
		sql.append("								EM.EM_PHONE emPhone,									");
		sql.append("								EM.EM_STARTEDDATE emStarteddate,						");
		sql.append("								EM.DE_ID deId,											");
		sql.append("								EM.PO_ID poId,											");
		sql.append("								EM.LI_ID liId,											");
		sql.append("								EM.SA_LEVEL saLevel,									");
		sql.append("								LI.LI_NAME liName,										");
		sql.append("								PO.PO_NAME poName,										");
		sql.append("								DE.DE_NAME deName,										");
		sql.append("								SA.SA_BASIC saBasic,									");
		sql.append("								SA.SA_COEFFICIENT saCoefficient,						");
		sql.append("								SA.SA_ALLOWANCECOEFFICIENT saAllowanceCoefficient		");
		sql.append("  						   FROM 														");
		sql.append("  								INTERN05_EMPLOYEE EM 									");
		sql.append("						   JOIN    INTERN05_LITERACY LI ON EM.LI_ID = LI.LI_ID  		");
		sql.append("						   JOIN    INTERN05_POSITION PO ON EM.PO_ID = PO.PO_ID 			");
		sql.append("						   JOIN    INTERN05_DEPARTMENT DE ON EM.DE_ID = DE.DE_ID		");
		sql.append("						   JOIN    INTERN05_SALARY SA ON EM.SA_LEVEL = SA.SA_LEVEL		");
		sql.append("						   WHERE   EM.EM_ID = :emId										");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("emId", new LongType());
		query.addScalar("emFirstname", new StringType());
		query.addScalar("emLastname", new StringType());
		query.addScalar("emBirthday", new DateType());
		query.addScalar("emHometown", new StringType());
		query.addScalar("emSex", new LongType());
		query.addScalar("emEthnic", new StringType());
		query.addScalar("emPhone", new StringType());
		query.addScalar("emStarteddate", new DateType());
		query.addScalar("deId", new LongType());
		query.addScalar("poId", new LongType());
		query.addScalar("liId", new LongType());
		query.addScalar("saLevel", new LongType());
		query.addScalar("liName", new StringType());
		query.addScalar("poName", new StringType());
		query.addScalar("deName", new StringType());
		query.addScalar("saBasic", new FloatType());
		query.addScalar("saCoefficient", new FloatType());
		query.addScalar("saAllowanceCoefficient", new FloatType());

		query.setParameter("emId", id);

		query.setResultTransformer(Transformers.aliasToBean(Intern05EmployeeDTO.class));
		return (Intern05EmployeeDTO) query.uniqueResult();
	}

	public List<Intern05EmployeeDTO> getByName(String name) {
		StringBuilder sql = new StringBuilder("SELECT 														");
		sql.append("								EM.EM_ID emId, 											");
		sql.append("								EM.EM_FIRSTNAME emFirstname,							");
		sql.append("								EM.EM_LASTNAME emLastname,								");
		sql.append("								EM.EM_BIRTHDAY emBirthday,								");
		sql.append("								EM.EM_HOMETOWN emHometown,								");
		sql.append("								EM.EM_SEX emSex,										");
		sql.append("								EM.EM_ETHNIC emEthnic,									");
		sql.append("								EM.EM_PHONE emPhone,									");
		sql.append("								EM.EM_STARTEDDATE emStarteddate,						");
		sql.append("								EM.DE_ID deId,											");
		sql.append("								EM.PO_ID poId,											");
		sql.append("								EM.LI_ID liId,											");
		sql.append("								EM.SA_LEVEL saLevel,									");
		sql.append("								LI.LI_NAME liName,										");
		sql.append("								PO.PO_NAME poName,										");
		sql.append("								DE.DE_NAME deName,										");
		sql.append("								SA.SA_BASIC saBasic,									");
		sql.append("								SA.SA_COEFFICIENT saCoefficient,						");
		sql.append("								SA.SA_ALLOWANCECOEFFICIENT saAllowanceCoefficient		");
		sql.append("  						   FROM 														");
		sql.append("  								INTERN05_EMPLOYEE EM 									");
		sql.append("						   JOIN    INTERN05_LITERACY LI ON EM.LI_ID = LI.LI_ID  		");
		sql.append("						   JOIN    INTERN05_POSITION PO ON EM.PO_ID = PO.PO_ID 			");
		sql.append("						   JOIN    INTERN05_DEPARTMENT DE ON EM.DE_ID = DE.DE_ID		");
		sql.append("						   JOIN    INTERN05_SALARY SA ON EM.SA_LEVEL = SA.SA_LEVEL		");
		sql.append("						   WHERE    													");
		sql.append("						   		(UPPER(EM.EM_FIRSTNAME) LIKE UPPER(:name))				");
		sql.append("						   OR															");
		sql.append("						   		(UPPER(EM.EM_LASTNAME) LIKE UPPER(:name))				");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("emId", new LongType());
		query.addScalar("emFirstname", new StringType());
		query.addScalar("emLastname", new StringType());
		query.addScalar("emBirthday", new DateType());
		query.addScalar("emHometown", new StringType());
		query.addScalar("emSex", new LongType());
		query.addScalar("emEthnic", new StringType());
		query.addScalar("emPhone", new StringType());
		query.addScalar("emStarteddate", new DateType());
		query.addScalar("deId", new LongType());
		query.addScalar("poId", new LongType());
		query.addScalar("liId", new LongType());
		query.addScalar("saLevel", new LongType());
		query.addScalar("liName", new StringType());
		query.addScalar("poName", new StringType());
		query.addScalar("deName", new StringType());
		query.addScalar("saBasic", new FloatType());
		query.addScalar("saCoefficient", new FloatType());
		query.addScalar("saAllowanceCoefficient", new FloatType());

		query.setParameter("name", "%" + name + "%");

		query.setResultTransformer(Transformers.aliasToBean(Intern05EmployeeDTO.class));
		return query.list();
	}

	public List<Intern05EmployeeDTO> getByHometown(String hometown) {
		StringBuilder sql = new StringBuilder("SELECT 														");
		sql.append("								EM.EM_ID emId, 											");
		sql.append("								EM.EM_FIRSTNAME emFirstname,							");
		sql.append("								EM.EM_LASTNAME emLastname,								");
		sql.append("								EM.EM_BIRTHDAY emBirthday,								");
		sql.append("								EM.EM_HOMETOWN emHometown,								");
		sql.append("								EM.EM_SEX emSex,										");
		sql.append("								EM.EM_ETHNIC emEthnic,									");
		sql.append("								EM.EM_PHONE emPhone,									");
		sql.append("								EM.EM_STARTEDDATE emStarteddate,						");
		sql.append("								EM.DE_ID deId,											");
		sql.append("								EM.PO_ID poId,											");
		sql.append("								EM.LI_ID liId,											");
		sql.append("								EM.SA_LEVEL saLevel,									");
		sql.append("								LI.LI_NAME liName,										");
		sql.append("								PO.PO_NAME poName,										");
		sql.append("								DE.DE_NAME deName,										");
		sql.append("								SA.SA_BASIC saBasic,									");
		sql.append("								SA.SA_COEFFICIENT saCoefficient,						");
		sql.append("								SA.SA_ALLOWANCECOEFFICIENT saAllowanceCoefficient		");
		sql.append("  						   FROM 														");
		sql.append("  								INTERN05_EMPLOYEE EM 									");
		sql.append("						   JOIN    INTERN05_LITERACY LI ON EM.LI_ID = LI.LI_ID  		");
		sql.append("						   JOIN    INTERN05_POSITION PO ON EM.PO_ID = PO.PO_ID 			");
		sql.append("						   JOIN    INTERN05_DEPARTMENT DE ON EM.DE_ID = DE.DE_ID		");
		sql.append("						   JOIN    INTERN05_SALARY SA ON EM.SA_LEVEL = SA.SA_LEVEL		");
		sql.append("						   WHERE    													");
		sql.append("						   		UPPER(EM.EM_HOMETOWN) LIKE UPPER(:hometown)				");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("emId", new LongType());
		query.addScalar("emFirstname", new StringType());
		query.addScalar("emLastname", new StringType());
		query.addScalar("emBirthday", new DateType());
		query.addScalar("emHometown", new StringType());
		query.addScalar("emSex", new LongType());
		query.addScalar("emEthnic", new StringType());
		query.addScalar("emPhone", new StringType());
		query.addScalar("emStarteddate", new DateType());
		query.addScalar("deId", new LongType());
		query.addScalar("poId", new LongType());
		query.addScalar("liId", new LongType());
		query.addScalar("saLevel", new LongType());
		query.addScalar("liName", new StringType());
		query.addScalar("poName", new StringType());
		query.addScalar("deName", new StringType());
		query.addScalar("saBasic", new FloatType());
		query.addScalar("saCoefficient", new FloatType());
		query.addScalar("saAllowanceCoefficient", new FloatType());

		query.setParameter("hometown", "%" + hometown + "%");

		query.setResultTransformer(Transformers.aliasToBean(Intern05EmployeeDTO.class));
		return query.list();
	}

	public List<Intern05EmployeeDTO> getByDepartment(String department) {
		StringBuilder sql = new StringBuilder("SELECT 														");
		sql.append("								EM.EM_ID emId, 											");
		sql.append("								EM.EM_FIRSTNAME emFirstname,							");
		sql.append("								EM.EM_LASTNAME emLastname,								");
		sql.append("								EM.EM_BIRTHDAY emBirthday,								");
		sql.append("								EM.EM_HOMETOWN emHometown,								");
		sql.append("								EM.EM_SEX emSex,										");
		sql.append("								EM.EM_ETHNIC emEthnic,									");
		sql.append("								EM.EM_PHONE emPhone,									");
		sql.append("								EM.EM_STARTEDDATE emStarteddate,						");
		sql.append("								EM.DE_ID deId,											");
		sql.append("								EM.PO_ID poId,											");
		sql.append("								EM.LI_ID liId,											");
		sql.append("								EM.SA_LEVEL saLevel,									");
		sql.append("								LI.LI_NAME liName,										");
		sql.append("								PO.PO_NAME poName,										");
		sql.append("								DE.DE_NAME deName,										");
		sql.append("								SA.SA_BASIC saBasic,									");
		sql.append("								SA.SA_COEFFICIENT saCoefficient,						");
		sql.append("								SA.SA_ALLOWANCECOEFFICIENT saAllowanceCoefficient		");
		sql.append("  						   FROM 														");
		sql.append("  								INTERN05_EMPLOYEE EM 									");
		sql.append("						   JOIN    INTERN05_LITERACY LI ON EM.LI_ID = LI.LI_ID  		");
		sql.append("						   JOIN    INTERN05_POSITION PO ON EM.PO_ID = PO.PO_ID 			");
		sql.append("						   JOIN    INTERN05_DEPARTMENT DE ON EM.DE_ID = DE.DE_ID		");
		sql.append("						   JOIN    INTERN05_SALARY SA ON EM.SA_LEVEL = SA.SA_LEVEL		");
		sql.append("						   WHERE    													");
		sql.append("						   		UPPER(DE.DE_NAME) LIKE UPPER(:department)				");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("emId", new LongType());
		query.addScalar("emFirstname", new StringType());
		query.addScalar("emLastname", new StringType());
		query.addScalar("emBirthday", new DateType());
		query.addScalar("emHometown", new StringType());
		query.addScalar("emSex", new LongType());
		query.addScalar("emEthnic", new StringType());
		query.addScalar("emPhone", new StringType());
		query.addScalar("emStarteddate", new DateType());
		query.addScalar("deId", new LongType());
		query.addScalar("poId", new LongType());
		query.addScalar("liId", new LongType());
		query.addScalar("saLevel", new LongType());
		query.addScalar("liName", new StringType());
		query.addScalar("poName", new StringType());
		query.addScalar("deName", new StringType());
		query.addScalar("saBasic", new FloatType());
		query.addScalar("saCoefficient", new FloatType());
		query.addScalar("saAllowanceCoefficient", new FloatType());

		query.setParameter("department", "%" + department + "%");

		query.setResultTransformer(Transformers.aliasToBean(Intern05EmployeeDTO.class));
		return query.list();
	}

	public List<Intern05EmployeeDTO> getByPosition(String position) {
		StringBuilder sql = new StringBuilder("SELECT 														");
		sql.append("								EM.EM_ID emId, 											");
		sql.append("								EM.EM_FIRSTNAME emFirstname,							");
		sql.append("								EM.EM_LASTNAME emLastname,								");
		sql.append("								EM.EM_BIRTHDAY emBirthday,								");
		sql.append("								EM.EM_HOMETOWN emHometown,								");
		sql.append("								EM.EM_SEX emSex,										");
		sql.append("								EM.EM_ETHNIC emEthnic,									");
		sql.append("								EM.EM_PHONE emPhone,									");
		sql.append("								EM.EM_STARTEDDATE emStarteddate,						");
		sql.append("								EM.DE_ID deId,											");
		sql.append("								EM.PO_ID poId,											");
		sql.append("								EM.LI_ID liId,											");
		sql.append("								EM.SA_LEVEL saLevel,									");
		sql.append("								LI.LI_NAME liName,										");
		sql.append("								PO.PO_NAME poName,										");
		sql.append("								DE.DE_NAME deName,										");
		sql.append("								SA.SA_BASIC saBasic,									");
		sql.append("								SA.SA_COEFFICIENT saCoefficient,						");
		sql.append("								SA.SA_ALLOWANCECOEFFICIENT saAllowanceCoefficient		");
		sql.append("  						   FROM 														");
		sql.append("  								INTERN05_EMPLOYEE EM 									");
		sql.append("						   JOIN    INTERN05_LITERACY LI ON EM.LI_ID = LI.LI_ID  		");
		sql.append("						   JOIN    INTERN05_POSITION PO ON EM.PO_ID = PO.PO_ID 			");
		sql.append("						   JOIN    INTERN05_DEPARTMENT DE ON EM.DE_ID = DE.DE_ID		");
		sql.append("						   JOIN    INTERN05_SALARY SA ON EM.SA_LEVEL = SA.SA_LEVEL		");
		sql.append("						   WHERE    													");
		sql.append("						   		UPPER(PO.PO_NAME) LIKE UPPER(:position)					");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("emId", new LongType());
		query.addScalar("emFirstname", new StringType());
		query.addScalar("emLastname", new StringType());
		query.addScalar("emBirthday", new DateType());
		query.addScalar("emHometown", new StringType());
		query.addScalar("emSex", new LongType());
		query.addScalar("emEthnic", new StringType());
		query.addScalar("emPhone", new StringType());
		query.addScalar("emStarteddate", new DateType());
		query.addScalar("deId", new LongType());
		query.addScalar("poId", new LongType());
		query.addScalar("liId", new LongType());
		query.addScalar("saLevel", new LongType());
		query.addScalar("liName", new StringType());
		query.addScalar("poName", new StringType());
		query.addScalar("deName", new StringType());
		query.addScalar("saBasic", new FloatType());
		query.addScalar("saCoefficient", new FloatType());
		query.addScalar("saAllowanceCoefficient", new FloatType());

		query.setParameter("position", "%" + position + "%");

		query.setResultTransformer(Transformers.aliasToBean(Intern05EmployeeDTO.class));
		return query.list();
	}

	public List<Intern05EmployeeDTO> getByLiteracy(String literacy) {
		StringBuilder sql = new StringBuilder("SELECT 														");
		sql.append("								EM.EM_ID emId, 											");
		sql.append("								EM.EM_FIRSTNAME emFirstname,							");
		sql.append("								EM.EM_LASTNAME emLastname,								");
		sql.append("								EM.EM_BIRTHDAY emBirthday,								");
		sql.append("								EM.EM_HOMETOWN emHometown,								");
		sql.append("								EM.EM_SEX emSex,										");
		sql.append("								EM.EM_ETHNIC emEthnic,									");
		sql.append("								EM.EM_PHONE emPhone,									");
		sql.append("								EM.EM_STARTEDDATE emStarteddate,						");
		sql.append("								EM.DE_ID deId,											");
		sql.append("								EM.PO_ID poId,											");
		sql.append("								EM.LI_ID liId,											");
		sql.append("								EM.SA_LEVEL saLevel,									");
		sql.append("								LI.LI_NAME liName,										");
		sql.append("								PO.PO_NAME poName,										");
		sql.append("								DE.DE_NAME deName,										");
		sql.append("								SA.SA_BASIC saBasic,									");
		sql.append("								SA.SA_COEFFICIENT saCoefficient,						");
		sql.append("								SA.SA_ALLOWANCECOEFFICIENT saAllowanceCoefficient		");
		sql.append("  						   FROM 														");
		sql.append("  								INTERN05_EMPLOYEE EM 									");
		sql.append("						   JOIN    INTERN05_LITERACY LI ON EM.LI_ID = LI.LI_ID  		");
		sql.append("						   JOIN    INTERN05_POSITION PO ON EM.PO_ID = PO.PO_ID 			");
		sql.append("						   JOIN    INTERN05_DEPARTMENT DE ON EM.DE_ID = DE.DE_ID		");
		sql.append("						   JOIN    INTERN05_SALARY SA ON EM.SA_LEVEL = SA.SA_LEVEL		");
		sql.append("						   WHERE    													");
		sql.append("						   		UPPER(LI.LI_NAME) LIKE UPPER(:literacy)					");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("emId", new LongType());
		query.addScalar("emFirstname", new StringType());
		query.addScalar("emLastname", new StringType());
		query.addScalar("emBirthday", new DateType());
		query.addScalar("emHometown", new StringType());
		query.addScalar("emSex", new LongType());
		query.addScalar("emEthnic", new StringType());
		query.addScalar("emPhone", new StringType());
		query.addScalar("emStarteddate", new DateType());
		query.addScalar("deId", new LongType());
		query.addScalar("poId", new LongType());
		query.addScalar("liId", new LongType());
		query.addScalar("saLevel", new LongType());
		query.addScalar("liName", new StringType());
		query.addScalar("poName", new StringType());
		query.addScalar("deName", new StringType());
		query.addScalar("saBasic", new FloatType());
		query.addScalar("saCoefficient", new FloatType());
		query.addScalar("saAllowanceCoefficient", new FloatType());

		query.setParameter("literacy", "%" + literacy + "%");

		query.setResultTransformer(Transformers.aliasToBean(Intern05EmployeeDTO.class));
		return query.list();
	}

	public List<Intern05EmployeeDTO> getBySalaryRate(Float salaryRate) {
		StringBuilder sql = new StringBuilder("SELECT 														");
		sql.append("								EM.EM_ID emId, 											");
		sql.append("								EM.EM_FIRSTNAME emFirstname,							");
		sql.append("								EM.EM_LASTNAME emLastname,								");
		sql.append("								EM.EM_BIRTHDAY emBirthday,								");
		sql.append("								EM.EM_HOMETOWN emHometown,								");
		sql.append("								EM.EM_SEX emSex,										");
		sql.append("								EM.EM_ETHNIC emEthnic,									");
		sql.append("								EM.EM_PHONE emPhone,									");
		sql.append("								EM.EM_STARTEDDATE emStarteddate,						");
		sql.append("								EM.DE_ID deId,											");
		sql.append("								EM.PO_ID poId,											");
		sql.append("								EM.LI_ID liId,											");
		sql.append("								EM.SA_LEVEL saLevel,									");
		sql.append("								LI.LI_NAME liName,										");
		sql.append("								PO.PO_NAME poName,										");
		sql.append("								DE.DE_NAME deName,										");
		sql.append("								SA.SA_BASIC saBasic,									");
		sql.append("								SA.SA_COEFFICIENT saCoefficient,						");
		sql.append("								SA.SA_ALLOWANCECOEFFICIENT saAllowanceCoefficient		");
		sql.append("  						   FROM 														");
		sql.append("  								INTERN05_EMPLOYEE EM 									");
		sql.append("						   JOIN    INTERN05_LITERACY LI ON EM.LI_ID = LI.LI_ID  		");
		sql.append("						   JOIN    INTERN05_POSITION PO ON EM.PO_ID = PO.PO_ID 			");
		sql.append("						   JOIN    INTERN05_DEPARTMENT DE ON EM.DE_ID = DE.DE_ID		");
		sql.append("						   JOIN    INTERN05_SALARY SA ON EM.SA_LEVEL = SA.SA_LEVEL		");
		sql.append("						   WHERE    													");
		sql.append("						   		SA.SA_COEFFICIENT = :salaryRate							");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("emId", new LongType());
		query.addScalar("emFirstname", new StringType());
		query.addScalar("emLastname", new StringType());
		query.addScalar("emBirthday", new DateType());
		query.addScalar("emHometown", new StringType());
		query.addScalar("emSex", new LongType());
		query.addScalar("emEthnic", new StringType());
		query.addScalar("emPhone", new StringType());
		query.addScalar("emStarteddate", new DateType());
		query.addScalar("deId", new LongType());
		query.addScalar("poId", new LongType());
		query.addScalar("liId", new LongType());
		query.addScalar("saLevel", new LongType());
		query.addScalar("liName", new StringType());
		query.addScalar("poName", new StringType());
		query.addScalar("deName", new StringType());
		query.addScalar("saBasic", new FloatType());
		query.addScalar("saCoefficient", new FloatType());
		query.addScalar("saAllowanceCoefficient", new FloatType());

		query.setParameter("salaryRate", salaryRate);

		query.setResultTransformer(Transformers.aliasToBean(Intern05EmployeeDTO.class));
		return query.list();
	}

	public List<Intern05EmployeeDTO> getByBirthday(String birthday) {
		StringBuilder sql = new StringBuilder("SELECT 														");
		sql.append("								EM.EM_ID emId, 											");
		sql.append("								EM.EM_FIRSTNAME emFirstname,							");
		sql.append("								EM.EM_LASTNAME emLastname,								");
		sql.append("								EM.EM_BIRTHDAY emBirthday,								");
		sql.append("								EM.EM_HOMETOWN emHometown,								");
		sql.append("								EM.EM_SEX emSex,										");
		sql.append("								EM.EM_ETHNIC emEthnic,									");
		sql.append("								EM.EM_PHONE emPhone,									");
		sql.append("								EM.EM_STARTEDDATE emStarteddate,						");
		sql.append("								EM.DE_ID deId,											");
		sql.append("								EM.PO_ID poId,											");
		sql.append("								EM.LI_ID liId,											");
		sql.append("								EM.SA_LEVEL saLevel,									");
		sql.append("								LI.LI_NAME liName,										");
		sql.append("								PO.PO_NAME poName,										");
		sql.append("								DE.DE_NAME deName,										");
		sql.append("								SA.SA_BASIC saBasic,									");
		sql.append("								SA.SA_COEFFICIENT saCoefficient,						");
		sql.append("								SA.SA_ALLOWANCECOEFFICIENT saAllowanceCoefficient		");
		sql.append("  						   FROM 														");
		sql.append("  								INTERN05_EMPLOYEE EM 									");
		sql.append("						   JOIN    INTERN05_LITERACY LI ON EM.LI_ID = LI.LI_ID  		");
		sql.append("						   JOIN    INTERN05_POSITION PO ON EM.PO_ID = PO.PO_ID 			");
		sql.append("						   JOIN    INTERN05_DEPARTMENT DE ON EM.DE_ID = DE.DE_ID		");
		sql.append("						   JOIN    INTERN05_SALARY SA ON EM.SA_LEVEL = SA.SA_LEVEL		");
		sql.append("						   WHERE    													");
		sql.append("					TRUNC(EM.EM_BIRTHDAY) = TO_DATE(TO_CHAR(:birthday),'DD-MON-YYYY')	");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("emId", new LongType());
		query.addScalar("emFirstname", new StringType());
		query.addScalar("emLastname", new StringType());
		query.addScalar("emBirthday", new DateType());
		query.addScalar("emHometown", new StringType());
		query.addScalar("emSex", new LongType());
		query.addScalar("emEthnic", new StringType());
		query.addScalar("emPhone", new StringType());
		query.addScalar("emStarteddate", new DateType());
		query.addScalar("deId", new LongType());
		query.addScalar("poId", new LongType());
		query.addScalar("liId", new LongType());
		query.addScalar("saLevel", new LongType());
		query.addScalar("liName", new StringType());
		query.addScalar("poName", new StringType());
		query.addScalar("deName", new StringType());
		query.addScalar("saBasic", new FloatType());
		query.addScalar("saCoefficient", new FloatType());
		query.addScalar("saAllowanceCoefficient", new FloatType());

		query.setParameter("birthday", birthday);

		query.setResultTransformer(Transformers.aliasToBean(Intern05EmployeeDTO.class));
		return query.list();
	}

	public List<Intern05EmployeeDTO> getByStartedDate(String startedDate) {
		StringBuilder sql = new StringBuilder("SELECT 														");
		sql.append("								EM.EM_ID emId, 											");
		sql.append("								EM.EM_FIRSTNAME emFirstname,							");
		sql.append("								EM.EM_LASTNAME emLastname,								");
		sql.append("								EM.EM_BIRTHDAY emBirthday,								");
		sql.append("								EM.EM_HOMETOWN emHometown,								");
		sql.append("								EM.EM_SEX emSex,										");
		sql.append("								EM.EM_ETHNIC emEthnic,									");
		sql.append("								EM.EM_PHONE emPhone,									");
		sql.append("								EM.EM_STARTEDDATE emStarteddate,						");
		sql.append("								EM.DE_ID deId,											");
		sql.append("								EM.PO_ID poId,											");
		sql.append("								EM.LI_ID liId,											");
		sql.append("								EM.SA_LEVEL saLevel,									");
		sql.append("								LI.LI_NAME liName,										");
		sql.append("								PO.PO_NAME poName,										");
		sql.append("								DE.DE_NAME deName,										");
		sql.append("								SA.SA_BASIC saBasic,									");
		sql.append("								SA.SA_COEFFICIENT saCoefficient,						");
		sql.append("								SA.SA_ALLOWANCECOEFFICIENT saAllowanceCoefficient		");
		sql.append("  						   FROM 														");
		sql.append("  								INTERN05_EMPLOYEE EM 									");
		sql.append("						   JOIN    INTERN05_LITERACY LI ON EM.LI_ID = LI.LI_ID  		");
		sql.append("						   JOIN    INTERN05_POSITION PO ON EM.PO_ID = PO.PO_ID 			");
		sql.append("						   JOIN    INTERN05_DEPARTMENT DE ON EM.DE_ID = DE.DE_ID		");
		sql.append("						   JOIN    INTERN05_SALARY SA ON EM.SA_LEVEL = SA.SA_LEVEL		");
		sql.append("						   WHERE    													");
		sql.append("				TRUNC(EM.EM_STARTEDDATE) = TO_DATE(TO_CHAR(:startedDate),'DD-MON-YYYY')	");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("emId", new LongType());
		query.addScalar("emFirstname", new StringType());
		query.addScalar("emLastname", new StringType());
		query.addScalar("emBirthday", new DateType());
		query.addScalar("emHometown", new StringType());
		query.addScalar("emSex", new LongType());
		query.addScalar("emEthnic", new StringType());
		query.addScalar("emPhone", new StringType());
		query.addScalar("emStarteddate", new DateType());
		query.addScalar("deId", new LongType());
		query.addScalar("poId", new LongType());
		query.addScalar("liId", new LongType());
		query.addScalar("saLevel", new LongType());
		query.addScalar("liName", new StringType());
		query.addScalar("poName", new StringType());
		query.addScalar("deName", new StringType());
		query.addScalar("saBasic", new FloatType());
		query.addScalar("saCoefficient", new FloatType());
		query.addScalar("saAllowanceCoefficient", new FloatType());

		query.setParameter("startedDate", startedDate);

		query.setResultTransformer(Transformers.aliasToBean(Intern05EmployeeDTO.class));
		return query.list();
	}

	public List<Intern05CitiesDTO> getAllCities() {
		StringBuilder sql = new StringBuilder("SELECT 														");
		sql.append("								CI.CI_ID ciId, 											");
		sql.append("								CI.CI_NAME ciName										");
		sql.append("  						   FROM 														");
		sql.append("  								INTERN05_CITIES CI  									");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("ciId", new LongType());
		query.addScalar("ciName", new StringType());

		query.setResultTransformer(Transformers.aliasToBean(Intern05CitiesDTO.class));
		return query.list();
	}

	public List<Intern05EthnicDTO> getAllEthnic() {
		StringBuilder sql = new StringBuilder("SELECT 														");
		sql.append("								ETH.ETH_ID ethId, 										");
		sql.append("								ETH.ETH_NAME ethName									");
		sql.append("  						   FROM 														");
		sql.append("  								INTERN05_ETHNIC ETH	  									");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("ethId", new LongType());
		query.addScalar("ethName", new StringType());

		query.setResultTransformer(Transformers.aliasToBean(Intern05EthnicDTO.class));
		return query.list();
	}

	public List<Intern05EmployeeDTO> search(Intern05EmployeeDTO employeeDTO) {

		StringBuilder sql = new StringBuilder("SELECT 														");
		sql.append("								EM.EM_ID emId, 											");
		sql.append("								EM.EM_FIRSTNAME emFirstname,							");
		sql.append("								EM.EM_LASTNAME emLastname,								");
		sql.append("								EM.EM_BIRTHDAY emBirthday,								");
		sql.append("								EM.EM_HOMETOWN emHometown,								");
		sql.append("								EM.EM_SEX emSex,										");
		sql.append("								EM.EM_ETHNIC emEthnic,									");
		sql.append("								EM.EM_PHONE emPhone,									");
		sql.append("								EM.EM_STARTEDDATE emStarteddate,						");
		sql.append("								EM.DE_ID deId,											");
		sql.append("								EM.PO_ID poId,											");
		sql.append("								EM.LI_ID liId,											");
		sql.append("								EM.SA_LEVEL saLevel,									");
		sql.append("								LI.LI_NAME liName,										");
		sql.append("								PO.PO_NAME poName,										");
		sql.append("								DE.DE_NAME deName,										");
		sql.append("								SA.SA_BASIC saBasic,									");
		sql.append("								SA.SA_COEFFICIENT saCoefficient,						");
		sql.append("								SA.SA_ALLOWANCECOEFFICIENT saAllowanceCoefficient		");
		sql.append("  						   FROM 														");
		sql.append("  								INTERN05_EMPLOYEE EM 									");
		sql.append("						   JOIN    INTERN05_LITERACY LI ON EM.LI_ID = LI.LI_ID  		");
		sql.append("						   JOIN    INTERN05_POSITION PO ON EM.PO_ID = PO.PO_ID 			");
		sql.append("						   JOIN    INTERN05_DEPARTMENT DE ON EM.DE_ID = DE.DE_ID		");
		sql.append("						   JOIN    INTERN05_SALARY SA ON EM.SA_LEVEL = SA.SA_LEVEL		");
		sql.append("						   WHERE														");
		sql.append("						   		   1=1													");

		if (employeeDTO.getEmId() != null) {
			sql.append("					   AND     EM.EM_ID = :emId										");
		}

		if (employeeDTO.getEmFirstname() != null && !employeeDTO.getEmFirstname().equals("")) {
			sql.append("					   AND     UPPER(EM.EM_FIRSTNAME) LIKE UPPER(:emFirstname) ESCAPE '\\'	");
		}

		if (employeeDTO.getEmLastname() != null && !employeeDTO.getEmLastname().equals("")) {
			sql.append("					   AND     UPPER(EM.EM_LASTNAME) LIKE UPPER(:emLastname) ESCAPE '\\'	");
		}

		if (employeeDTO.getEmBirthday() != null) {
			sql.append("					   AND     EM.EM_BIRTHDAY = :emBirthday								");
		}

		if (employeeDTO.getEmHometown() != null && !employeeDTO.getEmHometown().equals("")) {
			sql.append("					   AND     UPPER(EM.EM_HOMETOWN) LIKE UPPER(:emHometown) ESCAPE '\\'	");
		}

		if (employeeDTO.getEmSex() != null) {
			sql.append("					   AND     EM.EM_SEX = :emSex										");
		}

		if (employeeDTO.getEmEthnic() != null && !employeeDTO.getEmEthnic().equals("")) {
			sql.append("					   AND     UPPER(EM.EM_ETHNIC) LIKE UPPER(:emEthnic) ESCAPE '\\'		");
		}

		if (employeeDTO.getEmPhone() != null && !employeeDTO.getEmPhone().equals("")) {
			sql.append("					   AND     UPPER(EM.EM_PHONE) LIKE UPPER(:emPhone) ESCAPE '\\'		");
		}

		if (employeeDTO.getEmStarteddate() != null) {
			sql.append("					   AND     EM.EM_STARTEDDATE = :startedDate							");
		}

		if (employeeDTO.getDeName() != null && !employeeDTO.getDeName().equals("")) {
			sql.append("					   AND     UPPER(DE.DE_NAME) LIKE UPPER(:deName) ESCAPE '\\'			");
		}

		if (employeeDTO.getPoName() != null && !employeeDTO.getPoName().equals("")) {
			sql.append("					   AND     UPPER(PO.PO_NAME) LIKE UPPER(:poName) ESCAPE '\\'			");
		}

		if (employeeDTO.getLiName() != null && !employeeDTO.getLiName().equals("")) {
			sql.append("					   AND     UPPER(LI.LI_NAME) LIKE UPPER(:liName) ESCAPE '\\'			");
		}

		if (employeeDTO.getSaLevel() != null) {
			sql.append("					   AND     EM.SA_LEVEL = :saLevel									");
		}
		sql.append("						   ORDER BY EM.EM_ID ASC										");
		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("emId", new LongType());
		query.addScalar("emFirstname", new StringType());
		query.addScalar("emLastname", new StringType());
		query.addScalar("emBirthday", new DateType());
		query.addScalar("emHometown", new StringType());
		query.addScalar("emSex", new LongType());
		query.addScalar("emEthnic", new StringType());
		query.addScalar("emPhone", new StringType());
		query.addScalar("emStarteddate", new DateType());
		query.addScalar("deId", new LongType());
		query.addScalar("poId", new LongType());
		query.addScalar("liId", new LongType());
		query.addScalar("saLevel", new LongType());
		query.addScalar("liName", new StringType());
		query.addScalar("poName", new StringType());
		query.addScalar("deName", new StringType());
		query.addScalar("saBasic", new FloatType());
		query.addScalar("saCoefficient", new FloatType());
		query.addScalar("saAllowanceCoefficient", new FloatType());

		System.out.println(employeeDTO.toString());

		if (employeeDTO.getEmId() != null) {
			query.setParameter("emId", employeeDTO.getEmId());
		}

		if (employeeDTO.getEmFirstname() != null && !employeeDTO.getEmFirstname().equals("")) {
			employeeDTO.setEmFirstname(employeeDTO.getEmFirstname().replaceAll("%", "\\\\%"));
			employeeDTO.setEmFirstname(employeeDTO.getEmFirstname().replaceAll("_", "\\\\_"));
			query.setParameter("emFirstname", "%" + employeeDTO.getEmFirstname() + "%");
		}

		if (employeeDTO.getEmLastname() != null && !employeeDTO.getEmLastname().equals("")) {
			employeeDTO.setEmLastname(employeeDTO.getEmLastname().replaceAll("%", "\\\\%"));
			employeeDTO.setEmLastname(employeeDTO.getEmLastname().replaceAll("_", "\\\\_"));
			query.setParameter("emLastname", "%" + employeeDTO.getEmLastname() + "%");
		}

		if (employeeDTO.getEmBirthday() != null) {
			query.setParameter("emBirthday", employeeDTO.getEmBirthday());
		}

		if (employeeDTO.getEmHometown() != null && !employeeDTO.getEmHometown().equals("")) {
			employeeDTO.setEmHometown(employeeDTO.getEmHometown().replaceAll("%", "\\\\%"));
			employeeDTO.setEmHometown(employeeDTO.getEmHometown().replaceAll("_", "\\\\_"));
			query.setParameter("emHometown", "%" + employeeDTO.getEmHometown() + "%");
		}

		if (employeeDTO.getEmSex() != null) {
			query.setParameter("emSex", employeeDTO.getEmSex());
		}

		if (employeeDTO.getEmEthnic() != null && !employeeDTO.getEmEthnic().equals("")) {
			employeeDTO.setEmEthnic(employeeDTO.getEmEthnic().replaceAll("%", "\\\\%"));
			employeeDTO.setEmEthnic(employeeDTO.getEmEthnic().replaceAll("_", "\\\\_"));
			query.setParameter("emEthnic", "%" + employeeDTO.getEmEthnic() + "%");
		}

		if (employeeDTO.getEmPhone() != null && !employeeDTO.getEmPhone().equals("")) {
			employeeDTO.setEmPhone(employeeDTO.getEmPhone().replaceAll("%", "\\\\%"));
			employeeDTO.setEmPhone(employeeDTO.getEmPhone().replaceAll("_", "\\\\_"));
			query.setParameter("emPhone", "%" + employeeDTO.getEmPhone() + "%");
		}

		if (employeeDTO.getEmStarteddate() != null) {
			query.setParameter("emStarteddate", employeeDTO.getEmStarteddate());
		}

		if (employeeDTO.getDeName() != null && !employeeDTO.getDeName().equals("")) {
			employeeDTO.setDeName(employeeDTO.getDeName().replaceAll("%", "\\\\%"));
			employeeDTO.setDeName(employeeDTO.getDeName().replaceAll("_", "\\\\_"));
			query.setParameter("deName", "%" + employeeDTO.getDeName() + "%");
		}

		if (employeeDTO.getPoName() != null && !employeeDTO.getPoName().equals("")) {
			employeeDTO.setPoName(employeeDTO.getPoName().replaceAll("%", "\\\\%"));
			employeeDTO.setPoName(employeeDTO.getPoName().replaceAll("_", "\\\\_"));
			query.setParameter("poName", "%" + employeeDTO.getPoName() + "%");
		}

		if (employeeDTO.getLiName() != null && !employeeDTO.getLiName().equals("")) {
			employeeDTO.setLiName(employeeDTO.getLiName().replaceAll("%", "\\\\%"));
			employeeDTO.setLiName(employeeDTO.getLiName().replaceAll("_", "\\\\_"));
			query.setParameter("liName", "%" + employeeDTO.getLiName() + "%");
		}

		if (employeeDTO.getSaLevel() != null) {
			query.setParameter("saLevel", employeeDTO.getSaLevel());
		}

		query.setResultTransformer(Transformers.aliasToBean(Intern05EmployeeDTO.class));
		return query.list();
	}
}
