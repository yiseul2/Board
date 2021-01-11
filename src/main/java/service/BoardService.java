package service;

import domain.Board;

import java.util.List;

public interface BoardService {
    List<Board> getList();
    boolean createBoard(Board board);
    Board getBoard(Long id);
    boolean updateBoard(Board board);
    boolean deleteBoard(Long id);
}
