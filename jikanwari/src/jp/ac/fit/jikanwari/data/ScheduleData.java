package jp.ac.fit.jikanwari.data;

import java.io.Serializable;

/**
 * Personテーブルのデータクラス
 */
public class ScheduleData implements Serializable {

	/** バージョン */
	private static final long serialVersionUID = 1L;

	/** コマ */
	private int no;
	/** 科目 */
	private String kamoku;
	/** 場所 */
	private String basyo;
	/** 先生 */
	private String teacher;
	/** 必須 */
	private int hisu;
	/** 色 */
	private String color;


	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getKamoku() {
		return kamoku;
	}
	public void setKamoku(String kamoku) {
		this.kamoku = kamoku;
	}
	public String getBasyo() {
		return basyo;
	}
	public void setBasyo(String basyo) {
		this.basyo = basyo;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public int getHisu() {
		return hisu;
	}
	public void setHisu(int hisu) {
		this.hisu = hisu;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}