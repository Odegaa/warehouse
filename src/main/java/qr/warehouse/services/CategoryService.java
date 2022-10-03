package qr.warehouse.services;

import qr.warehouse.payload.CategoryDTO;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Category;

import java.util.List;

public interface CategoryService {
    Result addCategory(CategoryDTO categoryDTO);

    List<Category> getCategories();

    Result updateCategory(Long categoryId, CategoryDTO categoryDTO);

    Result deleteCategory(Long categoryId);

    Category getCategoryById(Long categoryId);
}
