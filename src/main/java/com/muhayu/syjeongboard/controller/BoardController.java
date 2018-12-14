package com.muhayu.syjeongboard.controller;

import com.muhayu.syjeongboard.model.Board;
import com.muhayu.syjeongboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping(value="/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){

        List<Board> boardList = boardService.boardList();

        model.addAttribute("result", boardList);

        return "board/list";
    }

    @RequestMapping(value = "/write")
    public String write(){
        return "board/write";
    }

    @RequestMapping(value = "/write-proc")
    public String writeProc(HttpServletRequest request){

        String title = request.getParameter("title");
        String content = request.getParameter("content");


        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);

        boardService.boardInsert(board);

        return "redirect:/board/list";
    }

    @RequestMapping(value = "/view/{index}")
    public String view(@PathVariable int index, Model model){

        model.addAttribute("detail", boardService.boardView(index));


        return "board/view";
    }
}
