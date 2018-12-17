package com.muhayu.syjeongboard.service.impl;

import com.muhayu.syjeongboard.mapper.BoardMapper;
import com.muhayu.syjeongboard.model.Board;
import com.muhayu.syjeongboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

    @Override
    public List<Board> boardList(String nickName) {
        return boardMapper.boardList(nickName);
    }

    public int boardInsert(Board board) {
        return boardMapper.boardInsert(board);
    }

    public Board boardView(int index) {
        return boardMapper.boardView(index);
    }

    public int boardDelete(int index) { return boardMapper.boardDelete(index); }
}


