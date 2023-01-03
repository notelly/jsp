package co.yedam.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.yedam.book.vo.BookVO;
import co.yedam.common.DAO;

public class BookDAO {
	Connection conn;
	ResultSet rs;
	PreparedStatement psmt;
	Statement smt;

	private static BookDAO instance = new BookDAO();

	private BookDAO() {
	}

	public static BookDAO getInstance() {
		return instance;
	}

	public void close() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 도서추가
	public int insertBook(BookVO vo) {
		String sql = "INSERT INTO tbl_book VALUES (?,?,?,?,?)";
		conn = DAO.getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			psmt.setString(2, vo.getBookTitle());
			psmt.setString(3, vo.getBookAuthor());
			psmt.setString(4, vo.getBookPress());
			psmt.setInt(5, vo.getBookPrice());

			int rs = psmt.executeUpdate();
			return rs;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	// 도서목록
	public List<BookVO> BookList() {
		List<BookVO> list = new ArrayList<>();
		BookVO vo = null;
		conn = DAO.getConn();
		String sql = "SELECT * FROM tbl_book ORDER BY book_code";

		try {
			smt = conn.createStatement();
			rs = smt.executeQuery(sql);

			while (rs.next()) {
				vo = new BookVO();
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookAuthor(rs.getString("book_title"));
				vo.setBookTitle(rs.getString("book_title"));
				vo.setBookPress(rs.getString("book_press"));
				vo.setBookPrice(rs.getInt("book_price"));
				list.add(vo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}

	// 도서상세
	public BookVO searchBook(String bookCode) {

		String sql = "SELECT * FROM tbl_book WHERE book_code = ?";
		conn = DAO.getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);

			rs = psmt.executeQuery();
			if (rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookTitle(rs.getString("book_title"));
				vo.setBookAuthor(rs.getString("book_author"));
				vo.setBookPress(rs.getString("book_press"));
				vo.setBookPrice(rs.getInt("book_price"));

				return vo;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;

	}

	// 도서수정
	public int updateBook(BookVO vo) {
		String sql = "UPDATE tbl_book set book_code = ?, book_title = ?, book_author = ?, book_press = ?, book_price = ?";
		conn = DAO.getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			psmt.setString(2, vo.getBookTitle());
			psmt.setString(3, vo.getBookAuthor());
			psmt.setString(4, vo.getBookPress());
			psmt.setInt(5, vo.getBookPrice());

			int result = psmt.executeUpdate();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;

	}

}
