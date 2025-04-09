package question02.dao;

import question02.ds.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemsDao extends CrudRepository<TodoItem, Integer> {
}
