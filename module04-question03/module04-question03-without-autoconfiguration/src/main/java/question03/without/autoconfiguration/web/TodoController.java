package question03.without.autoconfiguration.web;

import lombok.AllArgsConstructor;
import question03.without.autoconfiguration.dao.TodoItemsDao;
import question03.without.autoconfiguration.ds.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class TodoController {

    private TodoItemsDao todoItemsDao;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("todoItems", todoItemsDao.findAll());
        model.addAttribute("newTodoItem", new TodoItem());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute TodoItem todoItem) {
        todoItemsDao.save(todoItem);
        return "redirect:/";
    }
}
