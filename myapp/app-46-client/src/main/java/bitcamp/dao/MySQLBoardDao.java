package bitcamp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;

public class MySQLBoardDao implements BoardDao {

  Connection con;

  public MySQLBoardDao(Connection con) {
    this.con = con;
  }

  @Override
  public void insert(Board board) {
    try (Statement stmt = con.createStatement()) {

      stmt.executeUpdate(String.format(
          "insert into myapp_board(title,content,writer,password,view_count,created_date,category) "
              + "values(%s, %s, %s, %s, %d, %tY-%5$tm-%5$td, %s)",
          board.getNo(), board.getTitle(), board.getWriter(), board.getViewCount(),
          board.getCreatedDate()));

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Board> list() {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "SELECT board_no,title,content,writer,password,view_count,created_date,category FROM myapp_board")) {

      List<Board> list = new ArrayList<>();

      while (rs.next()) {
        Board b = new Board();
        b.setNo(rs.getInt("board_no"));
        b.setTitle(rs.getString("title"));
        b.setContent(rs.getString("content"));
        b.setWriter(rs.getString("writer"));
        b.setPassword(rs.getString("password"));
        b.setViewCount(rs.getInt("view_count"));
        b.setCreatedDate(rs.getDate("created_date"));
        b.setCategory(rs.getInt("category"));

        list.add(b);
      }
      return list;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Board findBy(int no) {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "SELECT board_no,title,content,writer,password,view_count,created_date,category FROM myapp_board WHERE board_no="
                + no)) {

      while (rs.next()) {
        Board b = new Board();
        b.setNo(rs.getInt("board_no"));
        b.setTitle(rs.getString("title"));
        b.setContent(rs.getString("content"));
        b.setWriter(rs.getString("writer"));
        b.setPassword(rs.getString("password"));
        b.setViewCount(rs.getInt("view_count"));
        b.setCreatedDate(rs.getDate("created_date"));
        b.setCategory(rs.getInt("category"));
        return b;
      }
      throw new RuntimeException("Not Found");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int update(Board board) {
    try (Statement stmt = con.createStatement()) {
      return stmt.executeUpdate(String.format(
          "update myapp_board set  title = '%s', content = '%s', writer = '%s',"
              + " password = '%s', view_count = %d, created_date = '%s', category = %d "
              + " where board_no = %d",
          board.getTitle(), board.getContent(), board.getWriter(), board.getPassword(),
          board.getViewCount(), board.getCreatedDate(), board.getCategory(), board.getNo()));

    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @Override
  public int delete(int no) {
    try (Statement stmt = con.createStatement()) {
      return stmt.executeUpdate(String.format("delete from myapp_board where board_no=%d", no));

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
