package cn.edu.sdwu.android02.classroom.sn170507180105;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Ch14Activity1 extends AppCompatActivity {
    private MyOpenHelper myOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch14_1);

        myOpenHelper=new MyOpenHelper(this);

    }

    public void insert(View view){
        //以可写方法打开数据库
        SQLiteDatabase sqLiteDatabase=myOpenHelper.getWritableDatabase();

        try {
            //将插入的数据放置在ContentValues中
            //事务的处理
            sqLiteDatabase.beginTransaction();//开启事务
            ContentValues contentValues=new ContentValues();
            contentValues.put("stuname","Mike");
            contentValues.put("stutel","1355555555");
            sqLiteDatabase.insert("student",null,contentValues);
            sqLiteDatabase.setTransactionSuccessful();//所有操作结束后，调用setTean..方法，才会将数据保存到数据库

        }catch (Exception e){
            Log.e(Ch14Activity1.class.toString(),e.toString());
        }finally {
            sqLiteDatabase.endTransaction();//结束事务
            //使用完毕，关闭数据库
            sqLiteDatabase.close();
        }

    }
    public void query(View view){
        SQLiteDatabase sqLiteDatabase=myOpenHelper.getReadableDatabase();
        try {
            Cursor cursor=sqLiteDatabase.rawQuery("select * from student where stuname=?",new String[]{"Tom"});
            while (cursor.moveToNext()){
                int id=cursor.getInt(cursor.getColumnIndex("id"));
                String stuname=cursor.getString(cursor.getColumnIndex("stuname"));
                String stutel=cursor.getString(cursor.getColumnIndex("stutel"));
                Log.i(Ch14Activity1.class.toString(),"id:"+id+",stuname:"+stuname+",stutel:"+stutel);
            }
            cursor.close();
        }catch (Exception e){
            Log.e(Ch14Activity1.class.toString(),e.toString());
        }finally {

            //使用完毕，关闭数据库
            sqLiteDatabase.close();
        }

    }
    public void delete(View view){
        SQLiteDatabase sqLiteDatabase=myOpenHelper.getWritableDatabase();

        try {
            //将插入的数据放置在ContentValues中
            //事务的处理
            sqLiteDatabase.beginTransaction();//开启事务
            sqLiteDatabase.delete("student","id=?",new String[]{"1"});
            sqLiteDatabase.setTransactionSuccessful();//所有操作结束后，调用setTean..方法，才会将数据保存到数据库

        }catch (Exception e){
            Log.e(Ch14Activity1.class.toString(),e.toString());
        }finally {
            sqLiteDatabase.endTransaction();//结束事务
            //使用完毕，关闭数据库
            sqLiteDatabase.close();
        }

    }
    public void modify(View view){
        SQLiteDatabase sqLiteDatabase=myOpenHelper.getWritableDatabase();

        try {
            //将插入的数据放置在ContentValues中
            //事务的处理
            sqLiteDatabase.beginTransaction();//开启事务
            ContentValues contentValues=new ContentValues();
            contentValues.put("stutel","13777777777");
            sqLiteDatabase.update("student",contentValues,"id=?",new String[]{"2"});
            sqLiteDatabase.setTransactionSuccessful();//所有操作结束后，调用setTean..方法，才会将数据保存到数据库

        }catch (Exception e){
            Log.e(Ch14Activity1.class.toString(),e.toString());
        }finally {
            sqLiteDatabase.endTransaction();//结束事务
            //使用完毕，关闭数据库
            sqLiteDatabase.close();
        }

    }



}
