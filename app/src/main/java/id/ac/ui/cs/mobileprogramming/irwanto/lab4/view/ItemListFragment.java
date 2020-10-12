package id.ac.ui.cs.mobileprogramming.irwanto.lab4.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import id.ac.ui.cs.mobileprogramming.irwanto.lab4.R;
import id.ac.ui.cs.mobileprogramming.irwanto.lab4.viewmodel.ItemViewModel;

public class ItemListFragment extends Fragment {
    private View view;
    private FragmentManager fragmentManager;
    private ItemViewModel itemViewModel;

    public ItemListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_item_list, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();
        itemViewModel = new ViewModelProvider(getActivity()).get(ItemViewModel.class);

        ListView itemLV = (ListView) view.findViewById(R.id.item_list);
        itemLV.setAdapter(new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, itemViewModel.getItemList()));
        itemLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                itemViewModel.setSelectedItem(textView.getText().toString());
                ItemDetailFragment itemDetailFragment = new ItemDetailFragment();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
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