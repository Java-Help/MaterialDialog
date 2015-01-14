package ru.javahelp.materialdialog;

import android.app.*;
import android.os.*;
import android.view.View.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import java.util.*;
import me.drakeet.materialdialog.MaterialDialog;

public class MainActivity extends Activity{

	Button btnSetContentView, btnNoTitle, btnMaterialDialog, btnImageBackground;
	Context context = this;
	MaterialDialog materialDialog;
	ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		btnSetContentView = (Button) findViewById(R.id.btnSetContentView);
		btnNoTitle = (Button) findViewById(R.id.btnNoTitle);
		btnMaterialDialog = (Button) findViewById(R.id.btnMaterialDialog);
		btnImageBackground = (Button) findViewById(R.id.btnImageBackground);
		
		
		
		btnSetContentView.setOnClickListener(onClick);
		btnImageBackground.setOnClickListener(onClick);
		btnNoTitle.setOnClickListener(onClick);
		btnMaterialDialog.setOnClickListener(onClick);
	}
	
	OnClickListener onClick = new OnClickListener(){

		@Override
		public void onClick(View v){
			switch(v.getId()){
				
				case R.id.btnMaterialDialog:
					materialDialog = new MaterialDialog(context);
					materialDialog.setTitle("Material Dialog")
						.setMessage("Ваш текст")
						
						.setPositiveButton("OK", new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								materialDialog.dismiss();
								Toast.makeText(context, "OK", Toast.LENGTH_LONG).show();
							}})
						.setNegativeButton("Cancel", new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								materialDialog.dismiss();
								
								Toast.makeText(context, "Cancel", Toast.LENGTH_LONG).show();
							}})
						.setCanceledOnTouchOutside(false)
						.setOnDismissListener(new DialogInterface.OnDismissListener() {
							@Override
							public void onDismiss(DialogInterface dialog) {
								
								Toast.makeText(context, "onDismiss", Toast.LENGTH_SHORT).show();
								
							}}).show();
							
					
				break;
				
				case R.id.btnNoTitle:
					materialDialog = new MaterialDialog(context);
					materialDialog.setMessage("Ваш текст")

						.setPositiveButton("OK", new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								materialDialog.dismiss();
								Toast.makeText(context, "OK", Toast.LENGTH_LONG).show();
							}})
						.setNegativeButton("отмена", new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								materialDialog.dismiss();

								Toast.makeText(context, "Cancel", Toast.LENGTH_LONG).show();
							}})
						.setCanceledOnTouchOutside(false)
						.setOnDismissListener(new DialogInterface.OnDismissListener() {
							@Override
							public void onDismiss(DialogInterface dialog) {

								Toast.makeText(context, "onDismiss", Toast.LENGTH_SHORT).show();

							}});
							materialDialog.show();
				break;
				
				case R.id.btnSetContentView:
					
					LayoutInflater layoutInflater= getLayoutInflater();
					View content = getLayoutInflater().inflate(R.layout.custom_layout, null);
					
					materialDialog = new MaterialDialog(context);
					materialDialog.setTitle("Material Dialog");
					materialDialog.setContentView(content);
					
					listView = (ListView) content.findViewById(R.id.customLayoutListView);
					ArrayList<String> arrayList = new ArrayList<String>();
					arrayList.add("Пункт 1");
					arrayList.add("Пункт 2");
					ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (context, R.layout.lv_item, R.id.lvItemTextView, arrayList);
					listView.setAdapter(arrayAdapter);
					materialDialog.setPositiveButton("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                materialDialog.dismiss();
								Toast.makeText(context, "OK", Toast.LENGTH_LONG).show();
                            }});
					materialDialog.show();
				break;
				
				case R.id.btnImageBackground:
					materialDialog = new MaterialDialog(context);
					materialDialog.setMessage("Ваше сообщение");
					materialDialog.setBackgroundResource(R.drawable.background);
					materialDialog.setCanceledOnTouchOutside(true).show();
				break;
				
			}
		}
	};
	
   
}
