package com.ezpay.web.tools;

import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateGenerator {

	private static final String OUTPUT_DIR = "D:/Projects/SpringWeb/sql/DDL/hbm2ddl";
	private static final String SCHEMA_PATH = OUTPUT_DIR + "/create_schema.sql";
	private static final String DELIMITER = ";";

	public static void main(String[] args) throws HibernateException {
		Configuration config = new Configuration().configure("hibernate.cfg2.xml");
		generateSQLSchema(config);
	}

	private static void generateSQLSchema(Configuration config) throws HibernateException {
		SchemaExport schemaExport = new SchemaExport(config);
		schemaExport.setDelimiter(DELIMITER);
		schemaExport.setOutputFile(SCHEMA_PATH);
		schemaExport.drop(true, true);
		schemaExport.create(true, true);
	}

}
