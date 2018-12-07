package com.muhayu.syjeongboard.controller;

import com.muhayu.syjeongboard.model.Board;
import com.muhayu.syjeongboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value="/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){

        model.addAttribute("result", boardService.boardList());

        return "board/list";
    }

    @RequestMapping(value = "/write")
    public String write(){
        return "board/write";
    }

    @RequestMapping(value = "/writeProc")
    public String writeProc(HttpServletRequest request){

        Board board = new Board();

        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));

        boardService.boardInsert(board);

        return "redirect:/board/list";
    }

    @RequestMapping(value = "/view")
    public String view(){

        return "board/view";
    }
}
