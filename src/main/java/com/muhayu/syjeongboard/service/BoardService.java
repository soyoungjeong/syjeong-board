package com.muhayu.syjeongboard.service;

import com.muhayu.syjeongboard.model.Board;

import java.util.List;

public interface BoardService {

    List<Board> selectBoardList(String nickName);

    int insertBoard(Board board);

    Board selectBoard(int index);

    int deleteBoard(int index);

    int updateBoard(Board board);
}
