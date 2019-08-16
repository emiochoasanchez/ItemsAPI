import java.util.Collection;

public interface IItemService {

    public Collection<Item> getItems();

    public Collection<Item>  getItemByUser(String username);

    public String addItem(String id,Item item) throws ApiException;


}
