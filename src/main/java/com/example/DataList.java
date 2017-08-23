package com.example;

import java.util.ArrayList;
import java.util.List;

public class DataList {
	public static List<String> nameList =new ArrayList<String>();

	public static List<String> getNameList() {
		return nameList;
	}

	public static void setNameList(List<String> nameList) {
		DataList.nameList = nameList;
	}


}
