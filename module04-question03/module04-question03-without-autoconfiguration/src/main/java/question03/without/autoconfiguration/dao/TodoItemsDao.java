package question03.without.autoconfiguration.dao;

import question03.without.autoconfiguration.ds.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemsDao extends CrudRepository<TodoItem, Integer> {
}
