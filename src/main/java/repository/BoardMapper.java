package repository;

import domain.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {
    int createBoard(Board board);
    Board getBoard(Long id);
    boolean updateBoard(Board board);
    boolean deleteBoard(Long board);
    List<Board> getBoardList();
}
