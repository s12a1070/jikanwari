package jp.ac.fit.jikanwari.dao;

import java.util.ArrayList;

import jp.ac.fit.jikanwari.data.ScheduleData;
import jp.ac.fit.jikanwari.sqlite.DatabaseHelper;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;

/**
 * データベースアクセスオブジェクト(dao)
 * データベースへの実際の操作をここに書きます。
 */
public class ScheduleDao {

	/**
	 * scheduleデータの全ての行を返します。
	 * @param context
	 * @return scheduleデータの全て
	 */
	public static ArrayList<ScheduleData> selectAll(Context context){
		// ＤＢ接続
		DatabaseHelper hp= new DatabaseHelper(context);			// データベースヘルパー
		final SQLiteDatabase db = hp.getReadableDatabase();		// SQLiteオブジェクト
		// カーソル
		Cursor cursor = null;									// カーソル

		// 戻り値
		ArrayList<ScheduleData> result = new ArrayList<ScheduleData>();

		// SQL処理
		try {
			// SQLECT文
			String sql = "";
			sql =  "";
			sql += " SELECT";
			sql += "      *";							// 学生番号
			sql += " FROM";
			sql += "     schedule";						// テーブル名
			sql += " ORDER BY";
			sql += "     no ASC";	// ASCは昇順 DESCは降順

			// SQL実行
			cursor = db.rawQuery(sql, null);

			// データの取得
			if(!cursor.moveToFirst()){
				return null; // １件もない場合
			}
			do{
				// １件分のscheduleData
				ScheduleData scheduleData = new ScheduleData();
				// DBから取得
				scheduleData.setNo( cursor.getInt(cursor.getColumnIndex("no")) );
				scheduleData.setKamoku( cursor.getString(cursor.getColumnIndex("kamoku")) );
				scheduleData.setBasyo( cursor.getString(cursor.getColumnIndex("basyo")) );
				scheduleData.setTeacher( cursor.getString(cursor.getColumnIndex("teacher")) );
				scheduleData.setHisu( cursor.getInt(cursor.getColumnIndex("hisu")) );
				scheduleData.setColor( cursor.getString(cursor.getColumnIndex("color")) );
				// 戻り値に設定
				result.add(scheduleData);
			}while(cursor.moveToNext());

		} catch (SQLiteException e) {
			e.printStackTrace();
		} catch (IllegalStateException ie) {
			ie.printStackTrace();
		} finally {
			// DB接続切断
			cursor.close();
			db.close();
			hp.close();
		}
		return result;

	}

	/**
	 * scheduleデータの１件を返します。
	 * @param context
	 * @param no
	 * @return scheduleデータ
	 */
	public static ScheduleData selectPrimaryKey(Context context, int no){
		// ＤＢ接続
		DatabaseHelper hp= new DatabaseHelper(context);			// データベースヘルパー
		final SQLiteDatabase db = hp.getReadableDatabase();		// SQLiteオブジェクト
		Cursor cursor = null;									// カーソル

		// 戻り値
		ScheduleData result = new ScheduleData();

		// SQL処理
		try {
			// SQLECT文
			String sql = "";
			sql =  "";
			sql += " SELECT";
			sql += "      *";
			sql += " FROM";
			sql += "     schedule";
			sql += " WHERE";
			sql += "     no = " + no;

			// SQL実行
			cursor = db.rawQuery(sql, null);

			// データの取得
			if(!cursor.moveToFirst()) return null;
			do{
				// １件分のscheduleData
				ScheduleData scheduleData = new ScheduleData();
				// DBから取得
				scheduleData.setNo( cursor.getInt(cursor.getColumnIndex("no")) );
				scheduleData.setKamoku( cursor.getString(cursor.getColumnIndex("kamoku")) );
				scheduleData.setBasyo( cursor.getString(cursor.getColumnIndex("basyo")) );
				scheduleData.setTeacher( cursor.getString(cursor.getColumnIndex("teacher")) );
				scheduleData.setHisu( cursor.getInt(cursor.getColumnIndex("hisu")) );
				scheduleData.setColor( cursor.getString(cursor.getColumnIndex("color")) );
				//戻り値に設定
			}while(cursor.moveToNext());

		} catch (SQLiteException e) {
			e.printStackTrace();
		} catch (IllegalStateException ie) {
			ie.printStackTrace();
		} finally {
			// DB接続切断
			cursor.close();
			db.close();
			hp.close();
		}
		return result;

	}

	/**
	 * 学生番号最大値＋１を返します。
	 * @param context
	 * @return 学生番号最大値＋１
	 */
	public static int selectMaxNo(Context context){
		// ＤＢ接続
		DatabaseHelper hp= new DatabaseHelper(context);			// データベースヘルパー
		final SQLiteDatabase db = hp.getReadableDatabase();		// SQLiteオブジェクト
		Cursor cursor = null;									// カーソル

		// 戻り値
		int result = 0;

		// SQL処理
		try {
			// SQLECT文
			String sql = "";
			sql =  "";
			sql += " SELECT";
			sql += "      MAX(no) + 1 AS no";					// 学生番号最大値＋１ （ASは別名定義）
			sql += " FROM";
			sql += "     schedule";								// テーブル名

			// SQL実行
			cursor = db.rawQuery(sql, null);

			// データの取得
			if(!cursor.moveToFirst()) return 0;
			do{
				// DBから取得
				result = cursor.getInt(cursor.getColumnIndex("no"));				// 学生番号最大値＋１
			}while(cursor.moveToNext());

		} catch (SQLiteException e) {
			e.printStackTrace();
		} catch (IllegalStateException ie) {
			ie.printStackTrace();
		} finally {
			// DB接続切断
			cursor.close();
			db.close();
			hp.close();
		}
		return result;

	}

	/**
	 * 更新を行います。
	 * @param context
	 * @param scheduleData
	 */
	public static void update(Context context, ScheduleData scheduleData){
		// ＤＢ接続
		DatabaseHelper helper = new DatabaseHelper(context);
		final SQLiteDatabase db = helper.getReadableDatabase();
		db.beginTransaction();
		try {
			// SQL実行
			String sql = "";
			sql += " UPDATE";
			sql += "     schedule";
			sql += " SET";
			sql += "     kamoku  = '" + scheduleData.getKamoku()+ "'";
			sql += "    ,basyo   = '"+ scheduleData.getBasyo()	+ "'";
			sql += "    ,teacher = '"+ scheduleData.getTeacher()	+ "'";
			sql += "    ,hisu    = " + scheduleData.getHisu();
			sql += "    ,color   = '"+ scheduleData.getColor()	+ "'";
			sql += " WHERE";
			sql += "     no     = " + String.valueOf(scheduleData.getNo());

			// トランザクション開始
			SQLiteStatement stmt = db.compileStatement(sql);
			stmt.execute();
			db.setTransactionSuccessful();

		} catch (SQLiteException e) {
			e.printStackTrace();
		} catch (IllegalStateException ie) {
			ie.printStackTrace();
		} finally {
			db.endTransaction();
			db.close();
			helper.close();
		}
	}

	/**
	 * 削除を行います。
	 * @param context
	 * @param scheduleData
	 */
	public static void delete(Context context, ScheduleData scheduleData){
		// ＤＢ接続
		DatabaseHelper helper = new DatabaseHelper(context);
		final SQLiteDatabase db = helper.getReadableDatabase();
		db.beginTransaction();
		try {
			// SQL実行
			String sql = "";
			sql += " UPDATE";
			sql += "     schedule";
			sql += " SET";
			sql += "     kamoku  = ''";
			sql += "    ,basyo   = ''";
			sql += "    ,teacher = ''";
			sql += "    ,hisu    = 0";
			sql += "    ,color   = '#000000'";
			sql += " WHERE";
			sql += "     no     = " + String.valueOf(scheduleData.getNo());

			// トランザクション開始
			SQLiteStatement stmt = db.compileStatement(sql);
			stmt.execute();
			db.setTransactionSuccessful();

		} catch (SQLiteException e) {
			e.printStackTrace();
		} catch (IllegalStateException ie) {
			ie.printStackTrace();
		} finally {
			db.endTransaction();
			db.close();
			helper.close();
		}
	}

}