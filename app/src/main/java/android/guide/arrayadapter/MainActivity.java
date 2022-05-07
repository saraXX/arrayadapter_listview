package android.guide.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// TODO 0 THIS PROJECT SHOW HOW TO CREATE A DYNAMIC LAYOUT
public class MainActivity extends AppCompatActivity {
    EditText mEditTextView;
    Button mButtonView;
    ListView mListView;
    List<String> mNoteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextView = findViewById(R.id.editview);
        mButtonView = findViewById(R.id.addtext);
        mListView = findViewById(R.id.listview);

// TODO 3 DECLARE AND INITIALIZE THE ARRAY LIST, TYPE STRING.
        mNoteList = new ArrayList<String>();
//        TODO 4 CREATE AN ADAPTER to fill the view with data |
//         ARGS {THIS ACTIVITY, ITEM LAYOUT, LIST}
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_layout, R.id.textitem, mNoteList);
//        TODO 5 SET THE ADAPTER TO THE LIST VIEW
        mListView.setAdapter(adapter);


        mButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = mEditTextView.getText().toString().trim();
                //      check if the edit text has any data or not
                if (temp.isEmpty()) {
                    Toast.makeText(MainActivity.this, "write something", Toast.LENGTH_SHORT).show();
                } else
//                    all these steps will work if the button clicked and edit text has data
//                    TODO 6 ADD THE WRITTEN DATA INSIDE LIST
                    mNoteList.add(mEditTextView.getText().toString());
//                    TODO 7 UPDATE THE ADAPTER / LIST VIEW, so we can see each item added
                adapter.notifyDataSetChanged();
//                    show all list item in log
                Log.d("myarray", "onCreate: " + Arrays.toString(mNoteList.toArray()));
//                    clear edit text once the item is added.
                mEditTextView.getText().clear();
            }


        });


    }
}