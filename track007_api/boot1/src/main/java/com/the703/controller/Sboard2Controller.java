package com.the703.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.Sboard2Dto;
import com.the703.service.Sboard2Service;
import com.the703.util.UtilPaging;

@Controller
@RequestMapping("/board")   // 공통 prefix
public class Sboard2Controller {
	
	@Autowired private Sboard2Service service;
	//    /board/list
	//	@GetMapping("/list")
	//	public String list(Model model) {
	//		model.addAttribute("list", service.selectAll());  //처리
	//		return "board/list"; // 화면
	//	}
	
	//http://localhost:8080/board/list
	@GetMapping("/list")
	public String list(Model model , @RequestParam(value="pageNo" , defaultValue="1")  int pageNo) {
		model.addAttribute("paging" , new UtilPaging( service.selectTotalCnt()  , pageNo));  // 화면용계산 이전-1,2,3-다음
		model.addAttribute("list", service.select10(pageNo));  //처리- 게시글10개 가져오기
		return "board/list"; // 화면
	}
	
	//http://localhost:8484/boot001/board/search?pageNo=1&keyword=t
	@GetMapping("/search")
	@ResponseBody
	public Map<String, Object>  search(
		@RequestParam(value="pageNo"  , defaultValue="1")  int pageNo ,
		@RequestParam(value="keyword" , required=false  )  String keyword
	){
	
		Map<String, Object> result = new HashMap<>();
		int totalCnt = service.selectSearchTotalCnt(keyword);
		
		result.put("search", keyword);  //1.검색키워드
		result.put("list"  , service.select3(keyword, pageNo));  //2.키워드 페이지3개
		result.put("paging", new UtilPaging(  totalCnt      , pageNo , 3, 10)); //3. 페이징계산
		return result;                        //키워드검색갯수, 페이지번호, 몇개씩, 하단블록
	}
	
	
	 
	//    /board/write (글쓰기 폼)
	@GetMapping("/write") public String write_get() {  return "board/write";}
	
	//    /board/write (글쓰기 기능)
	@PostMapping("/write") public String write_post(
			MultipartFile file ,Sboard2Dto dto  , RedirectAttributes rttr) {
		String result ="글쓰기 실패";
		if(service.insert(file, dto) > 0) { result="글쓰기 성공!";}
		rttr.addFlashAttribute("success" , result);
		return "redirect:/board/list";
	} 
	
	
	
	//    /board/detail (상세보기)
	@GetMapping("/detail")
	public String detail(int id , Model model) {
		model.addAttribute("dto", service.select(id));  
		return "board/detail";  
	}
	//    /board/edit   (수정폼)
	@GetMapping("/edit")
	public String edit_get(int id , Model model) {
		model.addAttribute("dto", service.selectUpdateForm(id));   
		return "board/edit";  
	}	
	//    /board/edit   (수정기능)
	@PostMapping("/edit") 
	public String edit_post(
			MultipartFile file ,Sboard2Dto dto  , RedirectAttributes rttr) {
		String result ="글수정 실패";
		if(service.update(file, dto) > 0) { result="글수정 성공!";}
		rttr.addFlashAttribute("success" , result);
		return "redirect:/board/detail?id=" + dto.getId();
	} 	
	//    /board/delete (삭제폼)
	@GetMapping("/delete")
	public String delete_get( ) {  
		return "board/delete";  
	}
	//    /board/delete (삭제기능) 
	@PostMapping("/delete") 
	public String delete_post( Sboard2Dto dto  , RedirectAttributes rttr) {
		String result ="글삭제 실패";
		if(service.delete(dto) > 0) { result="글삭제 성공!";}
		rttr.addFlashAttribute("success" , result);
		return "redirect:/board/list";
	} 
}
