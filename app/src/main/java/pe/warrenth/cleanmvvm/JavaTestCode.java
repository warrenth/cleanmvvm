package pe.warrenth.cleanmvvm;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import pe.warrenth.cleanmvvm.presentation.rx.main.MainFragment;

public class JavaTestCode extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.layout_root, new MainFragment()).commit();
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

        }
    };


    abstract class BaseBindingViewHolder<DB extends ViewDataBinding, ITEM> extends RecyclerView.ViewHolder {

        public DB binding;

        abstract void bind(ViewDataBinding DB, ITEM item);

        public BaseBindingViewHolder(@NonNull View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }
    }
}
