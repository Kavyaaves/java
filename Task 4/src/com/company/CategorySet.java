package com.company;

import java.util.EnumSet;

public class CategorySet {
    // static nested class
    public static class GetCategory{
        public void displayCategories(){
            EnumSet<Category> categories = EnumSet.allOf(Category.class);
            System.out.println(categories);
        }
    }
}
