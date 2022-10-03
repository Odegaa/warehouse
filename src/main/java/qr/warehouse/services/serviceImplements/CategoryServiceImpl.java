package qr.warehouse.services.serviceImplements;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.warehouse.finaly.Result;
import qr.warehouse.models.Category;
import qr.warehouse.payload.CategoryDTO;
import qr.warehouse.repositories.CategoryRepository;
import qr.warehouse.services.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public Result addCategory(CategoryDTO categoryDTO) {
        if (categoryDTO.getCategoryName() == null) {
            return new Result("Category name is null", false);
        }
        Category newCategory = new Category();
        newCategory.setCategoryName(categoryDTO.getCategoryName());
        newCategory.setStatus(true);
        if (categoryDTO.getParentCategoryId() != null) {
            Optional<Category> optionalCategory = repository.findById(categoryDTO.getParentCategoryId());
            if (optionalCategory.isEmpty()) {
                return new Result("Parent category not found!", false);
            } else {
                newCategory.setParentCategory(optionalCategory.get());
            }
        }
        repository.save(newCategory);
        return new Result("Category successful saved!", true);
    }

    @Override
    public List<Category> getCategories() {
        return repository.findAll();
    }

    @Override
    public Result updateCategory(Long categoryId, CategoryDTO categoryDTO) {
        Optional<Category> optionalCategory = repository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            Category updatingCategory = optionalCategory.get();
            updatingCategory.setCategoryName(categoryDTO.getCategoryName());
            updatingCategory.setStatus(true);

            Optional<Category> categoryOptional = repository.findById(categoryDTO.getParentCategoryId());
            if (categoryOptional.isPresent()) {
                updatingCategory.setParentCategory(categoryOptional.get());
                repository.save(updatingCategory);
                return new Result("Successfully updated!", true);
            }
        }
        return new Result("Category is not found or Exception!", false);
    }

    @Override
    public Result deleteCategory(Long categoryId) {
        Optional<Category> optionalCategory = repository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            repository.deleteById(categoryId);
            return new Result("Category deleted!", true);
        }
        return new Result("Category is not found or Exception", false);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return repository.findById(categoryId).orElse(null);
    }
}