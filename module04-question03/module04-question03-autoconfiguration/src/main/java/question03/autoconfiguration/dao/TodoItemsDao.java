package question03.autoconfiguration.dao;

import question03.autoconfiguration.ds.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemsDao extends CrudRepository<TodoItem, Integer> {
}
