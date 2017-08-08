package com.ezpay.web.dao.intf;

import java.util.List;

import com.ezpay.web.dto.Files;

public interface IFilesDAO {

	public Files find(Integer id);

	public List<Files> listAll();

	public void insert(Files file);

	public void delete(Files file);

}
