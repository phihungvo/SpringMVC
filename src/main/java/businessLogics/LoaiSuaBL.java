package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.LoaiSua;

public class LoaiSuaBL {
	public static int them(LoaiSua ls) {
		String sql = "insert into loai_sua(ma_loai_sua,ten_loai) values (?,?)";
		try (Connection kn = CSDL.getKetNoi()){
			PreparedStatement pst = kn.prepareStatement(sql);
			pst.setString(1, ls.getMaLoai());
			pst.setString(2, ls.getTenLoai());
			return pst.executeUpdate();
		} catch (Exception e) {
			return 0;
		}
	}
	public static List<LoaiSua> docTatCa(){
		List<LoaiSua> dsls = new ArrayList<>();
		String sql = "select * from loai_sua";
		try (Connection kn = CSDL.getKetNoi()){
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				LoaiSua ls = new LoaiSua();
				ls.setMaLoai(rs.getString("ma_loai_sua"));
				ls.setTenLoai(rs.getString("ten_loai"));
				dsls.add(ls);
			}
			return dsls;
		} catch (Exception e) {
			return null;
		}
	}
	public static LoaiSua docTheoMaLoai(String ml){
		LoaiSua ls = null;
		String sql = "select * from loai_sua where ma_loai_sua='" + ml + "'";
		try (Connection kn = CSDL.getKetNoi()){
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				ls = new LoaiSua();
				ls.setMaLoai(rs.getString("ma_loai_sua"));
				ls.setTenLoai(rs.getString("ten_loai"));
			}
			return ls;
		} catch (Exception e) {
			return null;
		}
	}
	public static void main(String[] args) {
//		LoaiSua ls = new LoaiSua();
//		ls.setMaLoai("AA");
//		ls.setTenLoai("Sữa AA");
//		if(them(ls)>0)
//			System.out.println("Da them loai sua thanh cong");
//		else
//			System.out.println("Khong them duoc loai sua");
		
//		List<LoaiSua> ds = docTatCa();
//		if(ds!=null)
//			ds.forEach(ls->System.out.println(ls.getTenLoai()));
		
//		LoaiSua lsAA = docTheoMaLoai("AA");
//		System.out.println(lsAA.getTenLoai());
	}
}
