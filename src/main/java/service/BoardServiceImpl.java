package service;

import domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BoardMapper;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

    @Override
    public boolean createBoard(Board board) {
        return boardMapper.createBoard(board) == 1;
    }

    @Override
    public Board getBoard(Long id) {
        return boardMapper.getBoard(id);
    }

    @Override
    public boolean updateBoard(Board board) {
        return boardMapper.updateBoard(board);
    }

    @Override
    public boolean deleteBoard(Long id) {
        return boardMapper.deleteBoard(id);
    }

    @Override
    public List<Board> getList() {
        return boardMapper.getBoardList();
    }
}
