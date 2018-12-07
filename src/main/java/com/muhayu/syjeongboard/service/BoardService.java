package com.muhayu.syjeongboard.service;

import com.muhayu.syjeongboard.model.Board;

import java.util.List;

public interface BoardService {

    List<Board> boardList();

    int boardInsert(Board board);

    Board boardView(int index);
}
