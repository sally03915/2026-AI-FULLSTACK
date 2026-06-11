package com.the703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.BoardDto;
import com.the703.service.BoardService;
import com.the703.util.PagingUtil;

@Controller
public class BoardController {  
	
	@Autowired BoardService  service;
	
	//■1.  전체리스트
	//	@RequestMapping("/board/list.do")
	//	public String list(Model model) {  
	//		model.addAttribute("list", service.selectAll());  
	//		return  "board/list";   
	//	}
	
	@RequestMapping("/board/list.do")
	public String list(Model model  , @RequestParam(value="pstartno" , defaultValue = "1" ) int pstartno  ) {
		
		model.addAttribute("paging" , new PagingUtil( service.selectCnt() , pstartno) );  /*  service전체갯수 */
		model.addAttribute("list"   , service.select10(pstartno));     /*  list10 */
		return  "board/list";   
	} 
	
	//           /view(폴더)  +  board(폴더)/list(파일명)   +  .jsp (확장자)
	//테스트 : http://localhost:8282/spring003_mvc/board/list.do

	//■2. 글쓰기 폼경로
	@RequestMapping( value="/board/write.do" , method=RequestMethod.GET)
	public String write() { return  "board/write";  }
	//테스트 : http://localhost:8282/spring003_mvc/board/write.do
	
	//■2. 글쓰기 기능  
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_MEMBER')")  //4. 안에 있는 권한중
	//@PreAuthorize("isAuthenticated()  and  hasRole('ROLE_ADMIN')") //3. 로그인 + ADMIN 권한이 있다면

	//@PreAuthorize("isAnonymous()")       // 1. 로그인하지 않은 사용자
	@PreAuthorize("isAuthenticated()") // 2. 로그인을 했다면
	@RequestMapping( value="/board/write.do" 
							,method = RequestMethod.POST , headers=("content-type=multipart/*"))
	public String write_post(BoardDto dto ,
			 @RequestParam("file") MultipartFile file   ,
			RedirectAttributes rttr) { 
		String result ="글쓰기 실패";
		
		if(service.insert(dto , file) > 0) {  result = "글쓰기 성공"; }
		rttr.addFlashAttribute("result", result);  // Flash - 1번만동작
		return "redirect:/board/list.do";   //response.sendRedirect + alert (x)
	}
	

	//■3. 글상세보기
	@RequestMapping("/board/detail.do")
	public String detail( int bno ,  Model model ) {  
		model.addAttribute("dto" , service.detail(bno)); 
		return  "board/detail";  
	}
	//테스트 : http://localhost:8282/spring003_mvc/board/detail.do
	 
	//■4. 글수정폼 경로
	@RequestMapping( value= "/board/edit.do" , method = RequestMethod.GET)
	public String edit( int bno  , Model model) {  // 넘겨받는 bno , edit.jsp  
		model.addAttribute("dto" , service.editView(bno));
		return  "board/edit";  
	} 
	//테스트 : http://localhost:8282/spring003_mvc/board/edit.do		
	//■4. 글수정 기능 
	@RequestMapping( value= "/board/edit.do" , method = RequestMethod.POST)
	public String edit_post(
			BoardDto dto,
			@RequestParam("file")  MultipartFile file, 
			RedirectAttributes rttr) { 
		// 알림창
		String result = "비밀번호 확인!";
		if( service.edit(dto , file) > 0 ) {  result = "수정성공";  }
		rttr.addFlashAttribute("result", result);
		
		return "redirect:/board/detail.do?bno=" + dto.getBno();
	} 
	//■5. 글삭제폼 경로	
	@RequestMapping( value="/board/delete.do", method = RequestMethod.GET)
	public String delete(int bno) { return  "board/delete";  }
	
	//테스트 : http://localhost:8282/spring003_mvc/board/delete.do
	//■5. 글삭제 기능
	@RequestMapping( value="/board/delete.do" , method = RequestMethod.POST)
	public String delete_post(BoardDto dto, RedirectAttributes rttr) {  
		String result = "비밀번호 확인!";
		if( service.delete(dto) > 0 ) {  result = "삭제성공";  }
		rttr.addFlashAttribute("result", result);
		
		return  "redirect:/board/list.do";  
	}

}
 