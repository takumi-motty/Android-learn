package com.example.motty.listsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SubSubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        String selectedText = intent.getStringExtra("Text");
        int selectedPhoto = intent.getIntExtra("Photo", 0);

        TextView textView = (TextView) findViewById(R.id.selected_text);
        textView.setText(selectedText);
        ImageView imageView = (ImageView) findViewById(R.id.selected_photo);
        imageView.setImageResource(selectedPhoto);

        // リストビューに表示するためのデータを設定
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1);
        adapter.add("listview2 item 2-1");
        adapter.add("listview2 item 2-2");
        adapter.add("listview2 item 3");

        // リストビューにデータを設定
        ListView listView1 = (ListView)findViewById(R.id.listView3);
        listView1.setAdapter(adapter);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        // 指定した ID のラジオボタンをチェックします
        radioGroup.check(R.id.radioButtonFile);
        // チェックされているラジオボタンの ID を取得します
        RadioButton radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());

        // ラジオグループのチェック状態が変更された時に呼び出されるコールバックリスナーを登録します
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            // ラジオグループのチェック状態が変更された時に呼び出されます
            // チェック状態が変更されたラジオボタンのIDが渡されます
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                Toast.makeText(SubSubActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();

                switch(checkedId){
                    case R.id.radioButtonFile:

                        break;
                    case R.id.radioButtonInfo:

                        break;
                }

            }
        });
    }
}
