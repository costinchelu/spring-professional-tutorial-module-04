package question05.web;

import question05.dao.TodoItemsDao;
import question05.ds.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TodoController {

    @Autowired
    private TodoItemsDao todoItemsDao;

    @GetMapping("/")
    public String index(TodoItem todoItem, Model model) {
        model.addAttribute("todoItems", todoItemsDao.findAll());
        model.addAttribute("todoItem", todoItem);
        return "index";
    }

    // implemented validation using the spring-boot-starter-validation
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute TodoItem todoItem, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return index(todoItem, model);
        } else {
            todoItemsDao.save(todoItem);
            return "redirect:/";
        }
    }
}
