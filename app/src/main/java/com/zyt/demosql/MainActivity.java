package com.zyt.demosql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    SQLiteDatabase db = null;

    private Button create ;
    private Button update ;
    private Button query ;
    private Button query1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create = (Button) findViewById(R.id.create);
        update = (Button) findViewById(R.id.update);
        query = (Button) findViewById(R.id.query);
        query1 = (Button) findViewById(R.id.query1);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedReaderDbHelper helper = new FeedReaderDbHelper(getApplication());
                //得到一个可读的SQLiteDatabase对象
                db = helper.getReadableDatabase();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sqlUpdate = "update student set name=? WHERE age=?";
                Object[] obj = new Object[]{"xiaoming","13"};
                db.execSQL(sqlUpdate,obj);
            }
        });

        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sql = "select * from student where age=13";
                Cursor c = db.rawQuery(sql,null);
                if (c == null){
                    Log.w("ret","null");
                }
                Log.w("ret",c.getCount() + ",");
            }
        });

        query1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sql = "select * from student where age=12";
                Cursor c = db.rawQuery(sql,null);
                if (c == null){
                    Log.w("ret","null");
                }
                Log.w("ret",c.getCount() + ",");
            }
        });
    }
}
