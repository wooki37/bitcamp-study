package bitcamp.myapp.controller;

import bitcamp.myapp.service.MemberService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("/member/list")
public class MemberListController implements PageController {
  @Autowired
  MemberService memberService;

  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    request.setAttribute("list", memberService.list());
    response.setContentType("text/html;charset=UTF-8");
    return "/WEB-INF/jsp/member/list.jsp";
  }
}