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
    public List<Board> selectBoardList(String nickName) {
        return boardMapper.selectBoardList(nickName);
    }

    public int insertBoard(Board board) {
        return boardMapper.insertBoard(board);
    }

    public Board selectBoard(int index) {
        return boardMapper.selectBoard(index);
    }

    public int deleteBoard(int index) { return boardMapper.deleteBoard(index); }

    public int updateBoard(Board board) { return boardMapper.updateBoard(board); }
}


