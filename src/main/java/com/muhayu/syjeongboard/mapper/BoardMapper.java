package com.muhayu.syjeongboard.mapper;

import com.muhayu.syjeongboard.model.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BoardMapper {

    List<Board> selectBoardList(String nickName);

    int insertBoard(Board board);

    Board selectBoard(int index);

    int deleteBoard(int index);

    int updateBoard(Board board);
}


