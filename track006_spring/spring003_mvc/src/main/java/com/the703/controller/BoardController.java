package com.the703.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController { 
	@RequestMapping("/board/list.do")
	public String list() { return  "board/list";  }
	//           /view(폴더)  +  board(폴더)/list(파일명)   +  .jsp (확장자)
	//테스트 : http://localhost:8282/spring003_mvc/board/list.do
	
	@RequestMapping("/board/write.do")
	public String write() { return  "board/write";  }
	//테스트 : http://localhost:8282/spring003_mvc/board/write.do

	@RequestMapping("/board/detail.do")
	public String detail() { return  "board/detail";  }
	//테스트 : http://localhost:8282/spring003_mvc/board/detail.do
	
	@RequestMapping("/board/edit.do")
	public String edit() { return  "board/edit";  } 
	//테스트 : http://localhost:8282/spring003_mvc/board/edit.do	
	
	@RequestMapping("/board/delete.do")
	public String delete() { return  "board/delete";  }
	//테스트 : http://localhost:8282/spring003_mvc/board/delete.do
}


/*
/board/list.do            /view/board/list.jsp 
/board/write.do           /view/board/write.jsp    (글쓰기폼)
/board/detail.do          /view/board/detailjsp    (상세보기)
/board/edit.do            /view/board/edit.jsp     (수정하기폼)
/board/delete.do          /view/board/delete.jsp   (삭제하기폼)
*/