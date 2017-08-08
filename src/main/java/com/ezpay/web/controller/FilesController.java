package com.ezpay.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ezpay.web.dao.intf.IFilesDAO;
import com.ezpay.web.dto.Files;

public class FilesController extends MultiActionController {

	private IFilesDAO filesDAO = null;

	/**
	 * upload
	 */
	public ModelAndView upload(HttpServletRequest request, HttpServletResponse response) throws Exception {

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("file");

		Files file = new Files();
		file.setFilename(multipartFile.getOriginalFilename());
		file.setNotes(ServletRequestUtils.getStringParameter(request, "notes"));
		file.setType(multipartFile.getContentType());
		file.setContent(multipartFile.getBytes());
		this.filesDAO.insert(file);
		
		return new ModelAndView("redirect:/files_show.do");
	}

	/**
	 * download
	 */
	public ModelAndView download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = ServletRequestUtils.getRequiredIntParameter(request, "id");

		Files file = this.filesDAO.find(id);

		response.setContentType(file.getType());
		response.setContentLength(file.getContent().length);
		response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getFilename() + "\"");

		FileCopyUtils.copy(file.getContent(), response.getOutputStream());
		return null;
	}

	/**
	 * delete
	 */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = ServletRequestUtils.getRequiredIntParameter(request, "id");
		Files file = this.filesDAO.find(id);
		this.filesDAO.delete(file);
		
		return new ModelAndView("redirect:/files_show.do");
	}
	
	/**
	 * show
	 */
	public ModelAndView show(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Files> files = this.filesDAO.listAll();
		return new ModelAndView("files_manager", "files", files);
	} 

	public IFilesDAO getFilesDAO() {
		return filesDAO;
	}

	public void setFilesDAO(IFilesDAO filesDAO) {
		this.filesDAO = filesDAO;
	}

}
