package jp.ac.fit.jikanwari;

import java.util.ArrayList;

import jp.ac.fit.jikanwari.dao.ScheduleDao;
import jp.ac.fit.jikanwari.data.ScheduleData;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

/**
 * メイン画面
 */

public class MainActivity extends Activity {

	/**
	 * 画面生成時
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// SQLiteから全件取得
		final ArrayList<ScheduleData> scheduleDataList = ScheduleDao.selectAll(this);

		// リストビュー設定
		ListAdapter adapter = new ListAdapter(this, R.layout.list, scheduleDataList);
		GridView listView = (GridView)this.findViewById(R.id.gridView1);
		listView.setAdapter(adapter);

		// リストビューがクリックされた時
		// 編集用画面に遷移
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// 編集画面に遷移

				scheduleDataList.get(position);
				if(position ==0 || (position % 8) ==0 ){
					return;
				}
				else{

				Intent intent = new Intent(MainActivity.this, EditActivity.class);
				intent.putExtra("scheduleData", scheduleDataList.get(position));
				startActivity(intent);
				finish();
				}
			}
		});
		// リストビューが長押しされた時
		// 削除するかのメッセージを表示
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterview,View view, int i, long l) {

				final ScheduleData scheduleData = scheduleDataList.get(i);

				// アラートダイアログ
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setMessage(scheduleData.getKamoku() + "\nこのデータを削除しますか？");
				// はい
				builder.setPositiveButton("はい", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						ScheduleDao.delete(MainActivity.this, scheduleData);

						// リストを再描画するため同じ画面に遷移
						Intent intent = new Intent(MainActivity.this, MainActivity.class);
						startActivity(intent);
						finish();
					}
				});
				// いいえ
				builder.setNegativeButton("いいえ", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// 何もしない
					}
				});

				//ダイアログ表示
				builder.show();

				return false;
			}
		});


		// 新規追加ボタン
//		Button btn = (Button) findViewById(R.id.buttonEntry);
//		btn.setOnClickListener(new OnClickListener() {
//			// クリック時の処理
//			public void onClick(View v) {
//				// 編集画面に遷移
//				Intent intent = new Intent(MainActivity.this, EditActivity.class);
//				intent.setAction("create");		// 新規追加Action
//				startActivity(intent);
//				finish();
//			}
//		});

	}
}
