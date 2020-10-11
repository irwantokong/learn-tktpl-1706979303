package id.ac.ui.cs.mobileprogramming.irwanto.lab4.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import id.ac.ui.cs.mobileprogramming.irwanto.lab4.R;

public class ItemListFragment extends Fragment {
    private View view;
    private FragmentManager fragmentManager;
    private ItemDetailFragment itemDetailFragment;

    public ItemListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_item_list, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();

        Button button = (Button) view.findViewById(R.id.go_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ItemDetailFragment itemDetailFragment = new ItemDetailFragment();
                fragmentTransaction.replace(R.id.main_container, itemDetailFragment);
                fragmentTransaction.addToBackStack(this.getClass().getName());
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}