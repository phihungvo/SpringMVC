package controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.LoaiSuaBL;
import javaBeans.LoaiSua;

@Controller
public class LoaiSuaController {
	@ModelAttribute
	public void setFont(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(path = "/them-loai-sua-1", method = RequestMethod.GET)
	public String themLoaiSua1() {
		return "them-loai-sua-1";
	}
	@RequestMapping(path = "/them-loai-sua-1", method = RequestMethod.POST)
	public String themLoaiSua1(HttpServletRequest request) {
		String ml, tl;
		ml = request.getParameter("txtMaLoai");
		tl = request.getParameter("txtTenLoai");
		LoaiSua ls = new LoaiSua();
		ls.setMaLoai(ml);
		ls.setTenLoai(tl);
		LoaiSuaBL.them(ls);
		return "them-loai-sua-1";
	}
	@RequestMapping(path = "/them-loai-sua-2", method = RequestMethod.GET)
	public String themLoaiSua2() {
		return "them-loai-sua-2";
	}
	@RequestMapping(path = "/them-loai-sua-2", method = RequestMethod.POST)
	public String themLoaiSua2(@RequestParam(name = "txtMaLoai") String ml, @RequestParam(name = "txtTenLoai") String tl) {
		//String ml, tl;
		//ml = request.getParameter("txtMaLoai");
		//tl = request.getParameter("txtTenLoai");
		LoaiSua ls = new LoaiSua();
		ls.setMaLoai(ml);
		ls.setTenLoai(tl);
		LoaiSuaBL.them(ls);
		return "them-loai-sua-2";
	}
	@RequestMapping(path = "/them-loai-sua-3", method = RequestMethod.GET)
	public String themLoaiSua3() {
		//return "them-loai-sua-3";
		return "themLoaiSua3";
	}
	@RequestMapping(path = "/them-loai-sua-3", method = RequestMethod.POST)
	public String themLoaiSua3(LoaiSua ls) {
		//String ml, tl;
		//ml = request.getParameter("txtMaLoai");
		//tl = request.getParameter("txtTenLoai");
		//LoaiSua ls = new LoaiSua();
		//ls.setMaLoai(ml);
		//ls.setTenLoai(tl);
		LoaiSuaBL.them(ls);
		//return "them-loai-sua-3";
		return "redirect:/loai-sua.html";
	}
	@RequestMapping("/loai-sua.html")
	public String loaiSua(Model model, HttpServletRequest request) {
		String pml = request.getParameter("maLoai");
		List<LoaiSua> dsls;
		if(pml==null)
			dsls = LoaiSuaBL.docTatCa();
		else {
			LoaiSua ls = LoaiSuaBL.docTheoMaLoai(pml);
			dsls = new ArrayList<>();
			dsls.add(ls);
		}
		model.addAttribute("dsls", dsls);
		//return "loai-sua";
		return "loaiSua";	//ten dinh nghia trong tiles.xml
	}
	@RequestMapping("/loai-sua/{ml}")
	public String loaiSua(Model model, @PathVariable(name = "ml") String ml) {
		List<LoaiSua> dsls = new ArrayList<>();
		LoaiSua ls = LoaiSuaBL.docTheoMaLoai(ml);
		dsls = new ArrayList<>();
		dsls.add(ls);
		model.addAttribute("dsls", dsls);
		return "loai-sua";
	}
}
