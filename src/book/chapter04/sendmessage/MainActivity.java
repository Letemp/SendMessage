package book.chapter04.sendmessage;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText etPhone,etMessage;
	Button myBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etPhone=(EditText)this.findViewById(R.id.etPhone);
		etMessage=(EditText)this.findViewById(R.id.etMessage);
		myBtn=(Button)this.findViewById(R.id.myBtn);//获取发送按钮
		
		myBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String mobile=etPhone.getText().toString();//获取收件人号码
				String content=etMessage.getText().toString();//获取短信内容
				Intent intent=new Intent();
				intent.setData(Uri.parse("smsto:"+mobile));//设置Intent数据
				intent.putExtra("sms_body", content);//存放短信内容(smsto,sms_body都是系统规定的写法，不能改变)
				startActivity(intent);
			}
			
		} );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
