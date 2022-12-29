package co.yedam;

import java.sql.Connection;
import java.util.List;

import co.yedam.common.Criteria;
import co.yedam.common.DAO;
import co.yedam.common.PageDTO;
import co.yedam.notice.dao.NoticeDAO;
import co.yedam.notice.vo.NoticeVO;

public class MainApp {
	public static void main(String[] args) {
		Criteria cri = new Criteria(3, 20);
		PageDTO dto = new PageDTO(cri, 150); //15page
		
		System.out.println(dto);

	}
		
	}
