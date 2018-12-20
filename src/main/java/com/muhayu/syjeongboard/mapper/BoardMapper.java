package com.muhayu.syjeongboard.mapper;

import com.muhayu.syjeongboard.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> boardList(String nickName);

    int boardInsert(Board board);

    Board boardView(int index);

    int boardDelete(int index);

    int boardUpdate(Board board);
}


