package id.ac.ui.cs.mobileprogramming.irwanto.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import id.ac.ui.cs.mobileprogramming.irwanto.lab4.view.ItemListFragment;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ItemListFragment itemListFragment = (ItemListFragment) new ItemListFragment();
        fragmentTransaction.add(R.id.main_container, itemListFragment);
        fragmentTransaction.commit();

    }
}