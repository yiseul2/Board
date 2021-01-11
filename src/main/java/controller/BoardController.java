package controller;

import domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.BoardService;

import java.util.List;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시글 작성
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> writeBoard(@ModelAttribute("Board") @RequestBody Board board) {
        // 로그인 확인
        return boardService.createBoard(board) ? new ResponseEntity<>("success", HttpStatus.OK) :
                new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 게시글 조회
    @ResponseBody
    @RequestMapping(value = "/{board-id}", method = RequestMethod.GET)
    public ResponseEntity<Board> readBoard(@PathVariable("board-id") Long id) {
        // 로그인 확인
        return new ResponseEntity<>(boardService.getBoard(id), HttpStatus.OK);
    }

    // 게시글 수정
    @ResponseBody
    @RequestMapping(value = "/{board-id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBoard(@PathVariable("board-id") Long id,
                                              @ModelAttribute("Board") @RequestBody Board board) {
        // 로그인 & 권한 확인
        board.setId(id);
        return boardService.updateBoard(board) ? new ResponseEntity<>("success", HttpStatus.OK) :
                new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 게시글 삭제
    @ResponseBody
    @RequestMapping(value = "/{board-id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBoard(@PathVariable("board-id") Long id) {
        // 로그인 & 권한 확인
        return boardService.deleteBoard(id) ? new ResponseEntity<>("success", HttpStatus.OK) :
                new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 게시글 리스트 조회
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Board>> readBoardList() {
        // 로그인 확인
        return new ResponseEntity<>(boardService.getList(), HttpStatus.OK);
    }
}
