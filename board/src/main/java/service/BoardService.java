package service;

import java.util.List;

import dto.BoardDTO;
import dto.SearchDTO;

public interface BoardService {
	List<BoardDTO> listAll(SearchDTO searchDto);
	BoardDTO getRow(int bno);
	boolean update(BoardDTO updateDto);
	boolean delete(int bno, String password);
	boolean create(BoardDTO insertDto);
	
	boolean hitUpdate(int bno);
	boolean reply(BoardDTO boardDto);
	
	int getTotalRows();
}
