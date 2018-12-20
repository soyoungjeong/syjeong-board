package com.muhayu.syjeongboard.controller;

import com.muhayu.syjeongboard.exception.UserException;
import com.muhayu.syjeongboard.model.Board;
import com.muhayu.syjeongboard.model.User;
import com.muhayu.syjeongboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model, HttpSession session) {

        try {
            User user = (User) session.getAttribute("user");
            if(user == null){
                throw new UserException("");
            }

            String writer = user.getNickname();
            List<Board> boardList = boardService.boardList(writer);

            model.addAttribute("result", boardList);
        }catch (UserException e) {
            model.addAttribute("msg", "로그인이 필요합니다.");
            return "/login";
        }catch (Exception e) {
            return "/error";
        }
        return "board/list";
    }

    @RequestMapping(value = "/write")
    public String write(HttpSession session, Model model) {
        try {
            User user = (User) session.getAttribute("user");
            if(user == null){
                throw new UserException("");
            }
        } catch (UserException e){
            model.addAttribute("msg", "로그인이 필요합니다.");
            return "/login";
        }catch (Exception e) {
            return "/error";
        }
        return "board/write";
    }

    @RequestMapping(value = "/write-proc")
    public String procWrite(HttpServletRequest request, HttpSession session) {

        User user = (User) session.getAttribute("user");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String nickname = user.getNickname();


        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(nickname);

        boardService.boardInsert(board);

        return "redirect:/board/list";
    }

    @RequestMapping(value = "/update/{index}")
    public String update(@PathVariable int index, Model model) {

        Board board = boardService.boardView(index);
        model.addAttribute("detail", board);

        return "board/update";
    }

    @RequestMapping(value = "/update-proc/{index}")
    public String procUpdate(@PathVariable int index, HttpServletRequest request){

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setIndex(index);

        boardService.boardUpdate(board);

        return "redirect:/board/list";
    }

    @RequestMapping(value = "/view/{index}")
    public String view(@PathVariable int index, Model model, HttpSession session) {

        try {
            User user = (User) session.getAttribute("user");

            if(user == null){
                throw new UserException("");
            }

            Board board = boardService.boardView(index);
            model.addAttribute("detail", board);

        }catch (UserException e){
            model.addAttribute("msg", "로그인이 필요합니다.");
            return "/login";
        }catch (Exception e){
            return "/error";
        }
        return "board/view";
    }

    @RequestMapping(value = "/delete/{index}")
    public String delete(@PathVariable int index){

        boardService.boardDelete(index);
        return "redirect:/board/list";
    }

    @RequestMapping(value = "/check-delete")
    public String checkDelete(@RequestParam(value = "check") List<Integer> check){

        for(int index : check) {
            boardService.boardDelete(index);
        }

        return "redirect:/board/list";
    }

    @RequestMapping(value = "/error")
    public String error(){
        return "redirect:/error";
    }
}
