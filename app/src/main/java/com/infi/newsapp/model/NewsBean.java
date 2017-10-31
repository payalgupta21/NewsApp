package com.infi.newsapp.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/*
 Encapsulation Concept
 */
public class NewsBean {

@SerializedName("mTitle")
@Expose
private String mTitle;
@SerializedName("rows")
@Expose
private List<Row> rows = null;

public String getmTitle() {
return mTitle;
}

public void setmTitle(String mTitle) {
this.mTitle = mTitle;
}

public List<Row> getRows() {
return rows;
}

public void setRows(List<Row> rows) {
this.rows = rows;
}

}