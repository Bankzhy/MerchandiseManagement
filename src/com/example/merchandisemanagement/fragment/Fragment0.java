package com.example.merchandisemanagement.fragment;

import android.content.ContentValues;

import com.example.merchandisemanagement.fragment.Fragment1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import com.example.merchandisemanagement.SQLite.MyOpenHelper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.List;

import com.example.merchandisemanagement.R;
import com.example.merchandisemanagement.R.layout;

public class Fragment0 extends Fragment {
	Fragment1 f1=new Fragment1();
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
		return inflater.inflate(R.layout.fragment0, null);		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		 super.onActivityCreated(savedInstanceState);
		 final DBAdapter dbadapter=new DBAdapter(this.getActivity());
		 
		 final EditText editname=(EditText)getActivity().findViewById(R.id.editname);
		 final EditText editqty=(EditText)getActivity().findViewById(R.id.editqty);
		 final EditText editprice=(EditText)getActivity().findViewById(R.id.editprice);
		 Button buttoninsert =(Button)getActivity().findViewById(R.id.buttoninsert);
		 buttoninsert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String nameinsert=editname.getText().toString();
				String qtyinsert=editqty.getText().toString();
				String priceinsert=editprice.getText().toString();
				int insertqty=new Integer(qtyinsert).intValue();
				
				boolean ck=dbadapter.checkName(nameinsert);
				
				dbadapter.buyinsert(nameinsert, qtyinsert,priceinsert);
				if(ck==false){
					dbadapter.sfinsert(nameinsert, qtyinsert);
					dbadapter.close();
					f1.load();
				}else{
					
					dbadapter.addQty(nameinsert, insertqty);
					f1.load();
				}
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
}