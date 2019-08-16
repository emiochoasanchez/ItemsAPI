import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ItemServiceMapImpl implements IItemService {

    private Map<String, Item> itemMap;


    public ItemServiceMapImpl() {
        itemMap = new HashMap<String, Item>();
        Item i1 = new Item("item1" , "comida", "u1", "MLA", "CAT1");
        Item i2 = new Item("item2" , "bebida", "u2", "MLA", "CAT2");
        Item i3 = new Item("item3" , "pelotas", "u3", "MLA", "CAT3");
        Item i4 = new Item("item4" , "guantes", "u4", "MLA", "CAT4");
        itemMap.put("item1", i1);
        itemMap.put("item2", i2);
        itemMap.put("item3", i3);
        itemMap.put("item4", i4);
    }


    @Override
    public Collection<Item> getItems() {
        return itemMap.values();
    }

    @Override
    public Collection<Item> getItemByUser(String username) {
        Collection<Item> items1 = itemMap.values();
        Map<String, Item> itemfiltered = new HashMap<String, Item>();

        items1.forEach(it -> {
            if (it.getUser().equalsIgnoreCase(username)) {
                itemfiltered.put(it.getId(), it);
            }
        });
        return itemfiltered.values();
    }

    @Override
    public String addItem(String id,Item item) throws ApiException {
        itemMap.put(item.getId(), item);
        return id;
    }
}

