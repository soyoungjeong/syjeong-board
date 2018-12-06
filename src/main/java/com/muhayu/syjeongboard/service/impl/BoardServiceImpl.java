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
    public List<Board> boardList(){
        return boardMapper.boardList();
    }
}
