package service;

import java.util.List;

import dto.BoardDTO;

public interface BoardService {
	List<BoardDTO> listAll();
	BoardDTO getRow(int bno);
	boolean update(BoardDTO updateDto);
	boolean delete(int bno, String password);
	boolean create(BoardDTO insertDto);
}
