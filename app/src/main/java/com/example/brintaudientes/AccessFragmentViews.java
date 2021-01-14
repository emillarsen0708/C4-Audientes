package com.example.brintaudientes;

import android.view.View;
import android.widget.Button;

public interface AccessFragmentViews {
    public void setVisibilityForButton(boolean bool);
    public void readExternalStorage();
    public void setButtonText(String name, Button button);
    public String getEditText();
    public void onInputSend(CharSequence charSequence);

}
