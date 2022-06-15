package com.example.demo.service;

import com.example.demo.model.binding.AddByTypeBindingModel;
import com.example.demo.model.binding.ProductEditBindingModel;
import com.example.demo.model.entity.ProductEntity;
import com.example.demo.model.entity.enums.TypeEnum;

import java.util.Set;

public interface ProductService {
    void initWhiskeys();

    Set<ProductEntity> getAllByType(TypeEnum typeEnum);

    void initGin();

    void initVodka();

    void initCognacAndBrendy();

    void initRum();

    void initTequila();

    void initRakia();

    void initWhiskeyCocktails();

    void initGinCocktails();

    void initVodkaCocktails();

    void initTequilaCocktails();

    void initBrandyCocktails();

    void initSchroedingerCocktails();

    void initBeer();

    void initWineGlass();

    void initWhiteWine();

    void initRedWine();

    void initRose();

    void initNonAlcoholic();

    void initHotBeverages();

    void initNuts();

    void initMenu();

    void removeProductById(Long id);

    ProductEntity findById(Long id);

    void editProduct(ProductEditBindingModel productEditBindingModel);

    void addByType(AddByTypeBindingModel addByTypeBindingModel);
}
