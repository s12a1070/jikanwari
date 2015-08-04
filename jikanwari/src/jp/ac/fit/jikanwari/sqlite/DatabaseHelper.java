package jp.ac.fit.jikanwari.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * データベースヘルパークラス
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    /** データベースバージョン */
	final static private int DB_VERSION = 1;	// 何かデータベースの定義が変更された時にインクリメントする

    /** データベース名 */
    private final static String DB_NAME = "testdb.sqlite";

	/**
	 * コンストラクター(必ず呼ばれる)
	 */
	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	/**
	 * このクラスが呼び出された時の最初の一回だけ呼ばれる
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// テーブル作成
		String sql = "";
		sql += " CREATE TABLE schedule (";	// personという名前のテーブル作成
		sql += "     no      int";			// 学生番号をnoのint型で定義
		sql += "    ,kamoku  text";			// 学部をgakubuのint型で定義
		sql += "    ,basyo   text";			// 名前をnameのtext型で定義
		sql += "    ,teacher text";			// 年
		sql += "    ,hisu    int";			// 年
		sql += "    ,color   text";			// 年
		sql += "    ,primary key(no)";		// プライマリーキーをnoで定義
		sql += " );";
		db.execSQL(sql);

		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values ( 1,'','１限目','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values ( 2,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values ( 3,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values ( 4,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values ( 5,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values ( 6,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values ( 7,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values ( 8,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values ( 9,'','２限目','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (10,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (11,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (12,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (13,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (14,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (15,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (16,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (17,'','昼休み','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (18,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (19,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (20,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (21,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (22,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (23,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (24,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (25,'','３限目','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (26,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (27,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (28,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (29,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (30,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (31,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (32,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (33,'','４限目','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (34,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (35,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (36,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (37,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (38,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (39,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (40,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (41,'','５限目','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (42,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (43,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (44,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (45,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (46,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (47,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (48,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (49,'','６限目','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (50,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (51,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (52,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (53,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (54,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (55,'','','',0,'#000000');");
		db.execSQL("insert into schedule(no, kamoku, basyo, teacher, hisu, color) values (56,'','','',0,'#000000');");
	}

	/**
	 * DB_VERSIONの定数がインクリメントされた時の最初の一回だけ呼ばれる
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// データベースの変更が生じた場合は、ここに処理を記述する。
	}
}