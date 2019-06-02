package pl.piotrdawidziuk.kotlinnotes02.views;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import pl.piotrdawidziuk.kotlinnotes02.R;
import pl.piotrdawidziuk.kotlinnotes02.models.Todo;

public class TodoView extends ConstraintLayout {

    private CheckBox completeCheckBox;
    private TextView descriptionTextView;

    public TodoView(Context context) {
        super(context);
    }

    public TodoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TodoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initView(Todo todo){

        completeCheckBox = findViewById(R.id.completeCheckBox);
        descriptionTextView = findViewById(R.id.descriptionTextView);

        descriptionTextView.setText(todo.getDescription());
        completeCheckBox.setChecked(todo.isComplete());

        if (todo.isComplete()){
            createStrikeThru();
        }

        setUpCheckStateListener();

    }

    public void setUpCheckStateListener(){
        completeCheckBox.setOnCheckedChangeListener((button, isChecked) -> {
            if (isChecked){
                createStrikeThru();
            } else {
                removeStrikeThru();
            }
                });
    }

    private void createStrikeThru(){
        descriptionTextView.setPaintFlags(descriptionTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }
    private void removeStrikeThru(){
        descriptionTextView.setPaintFlags(descriptionTextView.getPaintFlags() & ~(Paint.STRIKE_THRU_TEXT_FLAG));

    }
}
