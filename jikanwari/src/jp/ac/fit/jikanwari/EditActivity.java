package jp.ac.fit.jikanwari;

import jp.ac.fit.jikanwari.dao.ScheduleDao;
import jp.ac.fit.jikanwari.data.ScheduleData;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

/**
 * 編集用画面
 */
public class EditActivity extends Activity {

//	/** 新規追加フラグ */
//	private boolean createFlag = false;

	/**
	 * 画面生成時
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit);

		// scheduleData
		ScheduleData intentScheduleData = new ScheduleData();

		// インテントを取得
		Intent intent = getIntent();

		intentScheduleData = (ScheduleData) intent.getSerializableExtra("scheduleData");

//		// 新規追加・編集確認
//		if( !TextUtils.isEmpty(intent.getAction()) &&  intent.getAction().equals("create") ){
//			// 新規追加モード
//			scheduleData.setNo(scheduleDao.selectMaxNo(this));		// 学生番号 最大番号+1 取得
//			scheduleData.setGakubu(1);							// デフォルトは先頭
//			scheduleData.setName("");								// 名前は空
//			scheduleData.setNen(0);								// デフォルトは先頭
//			createFlag = true;		// 新規追加フラグ設定
//		}
//		else{
//			// 編集モード
//			scheduleData = (scheduleData) intent.getSerializableExtra("scheduleData");
//		}


		final EditText editTextKamoku = (EditText)findViewById(R.id.editTextName);
		editTextKamoku.setText(intentScheduleData.getKamoku());
		final EditText editTextBasyo = (EditText)findViewById(R.id.editText1);
		editTextBasyo.setText(intentScheduleData.getBasyo());
		final EditText editTextTeacher = (EditText)findViewById(R.id.editText2);
		editTextTeacher.setText(intentScheduleData.getTeacher());
		final TextView bango = (TextView)findViewById(R.id.bango);
		bango.setText(String.valueOf(intentScheduleData.getNo()));

		final CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox1);
		checkBox.setChecked(false);

//
//
//
		// 保存ボタン
		Button btn = (Button) findViewById(R.id.buttonEntry);
		btn.setOnClickListener(new OnClickListener() {
			// クリック時の処理
			public void onClick(View v) {
				// 名前が空の場合
				if( TextUtils.isEmpty(editTextKamoku.getText()) ){
					editTextKamoku.setError("名前を入力して下さい。");
					return;
				}

				// 入力データの取得
				ScheduleData scheduleData = new ScheduleData();
				scheduleData.setNo( Integer.valueOf(bango.getText().toString()));
				scheduleData.setKamoku( editTextKamoku.getText().toString() );
				scheduleData.setBasyo( editTextBasyo.getText().toString() );
				scheduleData.setTeacher( editTextTeacher.getText().toString() );
				if (checkBox.isChecked()) {
					scheduleData.setHisu(1);
				}
				else {
					scheduleData.setHisu(0);
				}

				// データベースに登録
//				if(createFlag){
//					// 追加
//					ScheduleDao.insert(EditActivity.this, scheduleData);
//				}
//				else{
					// 更新
					ScheduleDao.update(EditActivity.this, scheduleData);
//				}

				// 登録メッセージ通知
				Toast.makeText(EditActivity.this, "登録しました。", Toast.LENGTH_SHORT).show();

				// メイン画面に戻る
				Intent intent = new Intent(EditActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});

	}

	/**
	 * キー制御
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// 戻るボタン
		if(keyCode == KeyEvent.KEYCODE_BACK){
			// メイン画面に戻る
			Intent intent = new Intent(EditActivity.this, MainActivity.class);
			startActivity(intent);
			finish();
			return super.onKeyDown(keyCode, event);
		}else{
			return false;
		}
	}
}
