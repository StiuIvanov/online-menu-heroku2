package com.example.demo.init;

import com.example.demo.service.UserService;
import com.example.demo.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final UserService userService;
    private final ProductService productService;


    public DatabaseInitializer(UserService userService,
                               ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        if (userService.isEmpty()) {
            userService.initAdmin();

            productService.initWhiskeys();
            productService.initGin();
            productService.initVodka();
            productService.initCognacAndBrendy();
            productService.initRum();
            productService.initTequila();
            productService.initRakia();
            productService.initWhiskeyCocktails();
            productService.initGinCocktails();
            productService.initVodkaCocktails();
            productService.initTequilaCocktails();
            productService.initBrandyCocktails();
            productService.initSchroedingerCocktails();
            productService.initBeer();
            productService.initWineGlass();
            productService.initWhiteWine();
            productService.initRedWine();
            productService.initRose();
            productService.initNonAlcoholic();
            productService.initHotBeverages();
            productService.initNuts();
            productService.initMenu();
        }
    }


}
