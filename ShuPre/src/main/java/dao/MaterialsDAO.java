package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Material;
import model.User;

public class MaterialsDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/shuPre?useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "";
	
	//教材登録処理
	public Material registerMaterial(Material rm) {
		Material material = null;
		String materialName = rm.getMaterialName();
		int pageStart = rm.getPageStart();
		int pageEnd = rm.getPageEnd();
		int sectionStart = rm.getSectionStart();
		int sectionEnd = rm.getSectionEnd();
		int userId = rm.getUserId();
		
		//JDBCドライバを読み込む
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		//データベースに接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER,DB_PASS)) {
			//INSERT文を準備
			String sql = "INSERT INTO Materials (materialName, pageStart, pageEnd, sectionStart, sectionEnd, userId) VALUES(?, ?, ?, ?, ?, ?);";
			PreparedStatement pStmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, materialName);
			pStmt.setInt(2, pageStart);
			pStmt.setInt(3, pageEnd);
			pStmt.setInt(4, sectionStart);
			pStmt.setInt(5, sectionEnd);
			pStmt.setInt(6, userId);
			
			//INSERT文の実行
			int affectedRows = pStmt.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLException("教材の登録に失敗しました。");
	        }

	        //生成されたmaterialIdキーを取得し、Materialインスタンスを生成
	        try (ResultSet generatedKeys = pStmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                int materialId = generatedKeys.getInt(1);
	                material = new Material(materialId, materialName, pageStart, pageEnd, sectionStart, sectionEnd, userId);
	            } else {
	                throw new SQLException("materialIDの取得に失敗しました。");
	            }
	        }
		}catch(SQLException e) {
			return null;
		}
		return material;
	}
	public List<Material> viewMaterialList(User user){
		List<Material> materialList = new ArrayList<Material>();
		//やることのメモ
		//ユーザーIDを引っ張ってきてMaterialsテーブルをUserIdで検索。
		//Materialをインスタンス化してListにまとめる
		return materialList;
	}
}
