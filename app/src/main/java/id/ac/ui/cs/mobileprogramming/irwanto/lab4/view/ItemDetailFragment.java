package id.ac.ui.cs.mobileprogramming.irwanto.lab4.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.ac.ui.cs.mobileprogramming.irwanto.lab4.R;
import id.ac.ui.cs.mobileprogramming.irwanto.lab4.model.Item;
import id.ac.ui.cs.mobileprogramming.irwanto.lab4.viewmodel.ItemViewModel;

public class ItemDetailFragment extends Fragment {
    private View view;
    private ItemViewModel itemViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_item_detail, container, false);
        itemViewModel = new ViewModelProvider(getActivity()).get(ItemViewModel.class);

        itemViewModel.getSelectedItem().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String name) {
                Item selectedItem = itemViewModel.getItem(name);
                TextView itemNameTV = (TextView) view.findViewById(R.id.item_name);
                TextView itemDescTV = (TextView) view.findViewById(R.id.item_desc);
                itemNameTV.setText("Name: " + selectedItem.getName());
                itemDescTV.setText("Description: " + selectedItem.getDescription());
            }
        });
        return view;
    }

}