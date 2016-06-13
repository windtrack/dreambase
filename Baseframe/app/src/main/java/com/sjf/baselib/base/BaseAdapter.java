package com.sjf.baselib.base;

import java.util.List;


import android.content.Context;

/**
 * @Description:自定义的BaseAdapter，所有adapter的父类。
 */
public abstract class BaseAdapter<T, Q> extends android.widget.BaseAdapter {

	public Context mContext;
	public List<T> mList;//
	public Q mView; // 这里不一定是ListView,比如GridView,CustomListView


	public BaseAdapter(Context context, List<T> list, Q view) {
		this.mContext = context;
		this.mList = list;
		this.mView = view;
	}

	public BaseAdapter(Context context, List<T> list) {
		this.mContext = context;
		this.mList = list;
		
	}
	/**
	 * update
	 * @param list
	 */
	public void updateListView(List<T> list){
		this.mList = list;
		notifyDataSetChanged();
	}
	
	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	


}
