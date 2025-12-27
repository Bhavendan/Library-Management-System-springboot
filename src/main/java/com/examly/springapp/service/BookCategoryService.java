package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.BookCategory;
import com.examly.springapp.repository.BookCategoryRepo;

@Service
public class BookCategoryService {
    BookCategoryRepo bcr;

    public BookCategoryService(BookCategoryRepo bcr) {
        this.bcr = bcr;
    }
    public BookCategory createBookCategory(BookCategory bookcategory){
        return bcr.save(bookcategory);
    }
    public List<BookCategory>getAllBookCategory(){
        return bcr.findAll();
    }
    public Optional<BookCategory>getBookCategoryById(long id){
        return bcr.findById(id);
    }
    public BookCategory updateBookCategory(long id,BookCategory bookcategory){
        Optional<BookCategory>opt=bcr.findById(id);
        if(opt.isPresent()){
             BookCategory bc=opt.get();
             bc.setCategoryName(bookcategory.getCategoryName());
             return bcr.save(bc);
        }
        return null;
    }
    public Page<BookCategory>paginated(int page,int size){
        Pageable pg=PageRequest.of(page, size,Sort.by("categoryId"));
        return bcr.findAll(pg);
    }
    public boolean deleteBookCategory(long id){
        if(bcr.existsById(id)){
            bcr.deleteById(id);
            return true;
        }
        return false;
    }
}
