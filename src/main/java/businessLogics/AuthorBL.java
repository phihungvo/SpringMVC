package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.Author;

public class AuthorBL {
	private static JdbcTemplate jdbc = CSDL2.getJdbc();
	public static List<Author> getAuthors(){
		String sql = "select * from author";
		return jdbc.query(sql, new RowMapper<Author>() {
			@Override
			public Author mapRow(ResultSet rs, int numRow) throws SQLException {
				Author at = new Author();
				at.setId(rs.getInt("AuthorId"));
				at.setName(rs.getString("AuthorName"));
				return at;
			}
		});	
	}
	public static Author getAuthorById(int id) {
		String sql = "select * from author where authorid = ?";
		return jdbc.queryForObject(sql, new RowMapper<Author>() {
			@Override
			public Author mapRow(ResultSet rs, int numRow) throws SQLException {
				Author at = new Author();
				at.setId(rs.getInt("authorid"));
				at.setName(rs.getString("authorname"));
				return at;
			}
		}, id);
	}
	public static int addAuthor(Author at) {
		String sql = "insert into author(authorname) values (?)";
		return jdbc.update(sql, at.getName());
	}
	public static int editAuthor(Author at) {
		String sql = "update author set authorname = ?  where authorid = ?";
		return jdbc.update(sql, at.getName(), at.getId());
	}
	public static int delAuthor(int id) {
		String sql = "delete from author where authorid = ?";
		return jdbc.update(sql, id);
	}
	public static void main(String[] args) {
		//List<Author> ds = getAuthors();
		//ds.forEach(at->System.out.println(at.getName()));
		
		//Author at = getAuthorById(1);
		//System.out.println(at.getName());
		
		//Author at = new Author();
		//at.setName("aaaa");
		//addAuthor(at);
		
		//Author ats = getAuthorById(27);
		//ats.setName("bbbb");
		//editAuthor(ats);
		
		//delAuthor(27);
	}
}
