package pe.warrenth.cleanmvvm;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pe.warrenth.cleanmvvm.R;
import pe.warrenth.cleanmvvm.presentation.main.MainFragment;

public class JavaTestCode extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.layout_root, new MainFragment()).commit();
    }
}
