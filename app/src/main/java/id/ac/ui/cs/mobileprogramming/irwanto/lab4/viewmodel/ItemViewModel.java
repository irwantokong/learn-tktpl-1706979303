package id.ac.ui.cs.mobileprogramming.irwanto.lab4.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.ac.ui.cs.mobileprogramming.irwanto.lab4.data.ItemRepository;
import id.ac.ui.cs.mobileprogramming.irwanto.lab4.model.Item;

public class ItemViewModel extends ViewModel {
    private final MutableLiveData<String> selectedItem = new MutableLiveData<String>();
    private ItemRepository itemRepository = new ItemRepository();

    public void setSelectedItem(String name) {
        selectedItem.setValue(name);
    }

    public MutableLiveData<String> getSelectedItem() {
        return selectedItem;
    }

    public String[] getItemList() {
        return itemRepository.getItemList();
    }

    public Item getItem(String name) {
        return itemRepository.getItem(name);
    }
}
