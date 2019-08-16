import java.util.Collection;

public interface IItemService {

    public Collection<Item> getItems();

    public Item getItemsByUser(String id);

    public int addItem(Item item) throws ApiException;


}
