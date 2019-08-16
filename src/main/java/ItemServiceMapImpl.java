import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ItemServiceMapImpl implements IItemService {

    private Map<String, Item> itemMap;

    public ItemServiceMapImpl() {
        itemMap = new HashMap<String, Item>();

    }

    @Override
    public Collection<Item> getItems() {
        return itemMap.values();
    }

    @Override
    public Item getItemsByUser(String id) {
        return itemMap.get(id);
    }

    @Override
    public int addItem(Item item) throws ApiException {
        itemMap.put(item.getId(), item);
        return itemMap.size();
    }
}

