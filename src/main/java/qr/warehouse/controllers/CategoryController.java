package qr.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.warehouse.payload.CategoryDTO;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Category;
import qr.warehouse.services.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    private Result addCategory(@RequestBody CategoryDTO categoryDTO) {
        return service.addCategory(categoryDTO);
    }

    @GetMapping
    private List<Category> getAllCategories() {
        return service.getCategories();
    }

    @GetMapping("/{categoryId}")
    private Category getCategoryById(@PathVariable Long categoryId) {
        return service.getCategoryById(categoryId);
    }

    @PutMapping("/{categoryId}")
    private Result updateCategory(@PathVariable Long categoryId,
                                  @RequestBody CategoryDTO categoryDTO) {
        return service.updateCategory(categoryId, categoryDTO);
    }

    @DeleteMapping("/{categoryId}")
    private Result deleteCategory(@PathVariable Long categoryId) {
        return service.deleteCategory(categoryId);
    }

}