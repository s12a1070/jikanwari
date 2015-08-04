package jp.ac.fit.jikanwari;

import java.util.ArrayList;

import jp.ac.fit.jikanwari.data.ScheduleData;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * リストビュー１件分の表示制御
 */
public class ListAdapter extends ArrayAdapter<ScheduleData> {

	private ArrayList<ScheduleData> scheduleDataList;
	private final LayoutInflater inflater;
//	private Context context;

	/**
	 * コンストラクタ
	 * @param context
	 * @param textViewResourceId
	 * @param items
	 */
	public ListAdapter(Context context, int textViewResourceId, ArrayList<ScheduleData> scheduleDataList) {
		super(context, textViewResourceId, scheduleDataList);
//		this.context = context;
		this.scheduleDataList = scheduleDataList;
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	/**
	 * リストビューに追加するビューを返します。
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			// 受け取ったビューがnullなら新しくビューを生成
			convertView = inflater.inflate(R.layout.list, null);
		}
		// １件のデータを設定
		ScheduleData scheduleData = this.scheduleDataList.get(position);

		// リストビュー１件のコントロールを設定
		TextView textViewKamoku = (TextView)convertView.findViewById(R.id.textViewKamoku);
		TextView textViewBasyo = (TextView)convertView.findViewById(R.id.textViewBasyo);
		TextView textViewTeacher = (TextView)convertView.findViewById(R.id.textViewTeacher);




		textViewKamoku.setText(scheduleData.getKamoku());
		textViewBasyo.setText(scheduleData.getBasyo());
		textViewTeacher.setText(scheduleData.getTeacher());



		if (scheduleData.getHisu() == 1) {
			textViewKamoku.setTextColor(Color.RED);
			textViewBasyo.setTextColor(Color.RED);
			textViewTeacher.setTextColor(Color.RED);
		}else {
			textViewKamoku.setTextColor(Color.BLUE);
			textViewBasyo.setTextColor(Color.BLUE);
			textViewTeacher.setTextColor(Color.BLUE);
		}

		return convertView;
	}
}