package cn.edu.sdwu.android02.classroom.sn170507180105;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2020/4/29.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    private static final String STUDENT_TB_SQL="create table student(id integer primary key autoincrement,stuname text,stutel text)";
    public MyOpenHelper(Context context){
        //上下文、数据库的名字、传入null、数据库版本
        super(context,"stud.db",null,2);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //当打开数据库时，发现数据库并不存在，此时会自动创建数据库，然后调用onCreate方法
        //在本方法中，完成数据库对象（表、视图、索引等）的创建
        //通过SQLiteDatabase对象，完成SQL执行
        sqLiteDatabase.execSQL(STUDENT_TB_SQL);
        Log.i(MyOpenHelper.class.toString(),"onCreate");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //当构造方法中制定得版本号，与手机中已有数据库得版本号更新的时候，调用本方法
        sqLiteDatabase.execSQL("alter table student add column stuadd text");
    }
}
