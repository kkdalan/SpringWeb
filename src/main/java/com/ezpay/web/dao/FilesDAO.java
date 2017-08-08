package com.ezpay.web.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.ezpay.web.dao.intf.IFilesDAO;
import com.ezpay.web.dto.Files;

public class FilesDAO implements IFilesDAO {

	private HibernateTemplate hibernateTemplate = null;

	public Files find(Integer id) {
		String queryString = "from Files files where files.id=" + id;
		List files = hibernateTemplate.find(queryString);
		if (files.size() == 0) {
			return null;
		} else {
			return (Files) files.get(0);
		}
	}

	public List<Files> listAll() {
		String queryString = "from Files files ";
		List files = hibernateTemplate.find(queryString);
		return files;
	}

	public void insert(Files file) {
		hibernateTemplate.saveOrUpdate(file);
	}

	public void delete(Files file) {
		hibernateTemplate.delete(file);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
