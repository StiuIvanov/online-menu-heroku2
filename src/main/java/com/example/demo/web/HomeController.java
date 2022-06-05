package com.example.demo.web;

import com.example.demo.model.entity.EventEntity;
import com.example.demo.model.entity.SpecialProductEntity;
import com.example.demo.model.entity.enums.TypeEnum;
import com.example.demo.service.EventService;
import com.example.demo.service.UserService;
import com.example.demo.service.ProductService;
import com.example.demo.service.SpecialProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final UserService userService;
    private final ProductService productService;
    private final EventService eventService;
    private final SpecialProductService specialProductService;

    public HomeController(UserService userService,
                          ProductService productService,
                          EventService eventService,
                          SpecialProductService specialProductService) {
        this.userService = userService;
        this.productService = productService;
        this.eventService = eventService;
        this.specialProductService = specialProductService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();

        SpecialProductEntity specialProductImage = specialProductService.getSpecialProductImage();

        EventEntity event = eventService.getFirstEvent();

        modelAndView.addObject("event", event);
        modelAndView.addObject("special", specialProductImage);

        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/full-menu")
    public ModelAndView fullMenu() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("scotchWhiskeys", productService.getAllByType(TypeEnum.ScotchWhisky));
        modelAndView.addObject("irishWhiskeys", productService.getAllByType(TypeEnum.IrishWhisky));
        modelAndView.addObject("americanWhiskeys", productService.getAllByType(TypeEnum.AmericanWhisky));
        modelAndView.addObject("singleMaltScotchWhiskyWhiskeys", productService.getAllByType(TypeEnum.SingleMaltScotchWhisky));
        modelAndView.addObject("japaneseWhiskyWhiskeys", productService.getAllByType(TypeEnum.JapaneseWhisky));
        modelAndView.addObject("gin", productService.getAllByType(TypeEnum.Gin));
        modelAndView.addObject("vodka", productService.getAllByType(TypeEnum.Vodka));
        modelAndView.addObject("cognacAndBrendy", productService.getAllByType(TypeEnum.CognacAndBrendy));
        modelAndView.addObject("rum", productService.getAllByType(TypeEnum.Rum));
        modelAndView.addObject("tequila", productService.getAllByType(TypeEnum.Tequila));
        modelAndView.addObject("rakia", productService.getAllByType(TypeEnum.Rakia));
        modelAndView.addObject("whiskeyCocktails", productService.getAllByType(TypeEnum.WhiskeyCocktails));
        modelAndView.addObject("ginCocktails", productService.getAllByType(TypeEnum.GinCocktails));
        modelAndView.addObject("vodkaCocktails", productService.getAllByType(TypeEnum.VodkaCocktails));
        modelAndView.addObject("tequilaCocktails", productService.getAllByType(TypeEnum.TequilaCocktails));
        modelAndView.addObject("brandyCocktails", productService.getAllByType(TypeEnum.BrandyCocktails));
        modelAndView.addObject("schroedingerCocktails", productService.getAllByType(TypeEnum.SchroedingerCocktails));
        modelAndView.addObject("beer", productService.getAllByType(TypeEnum.Beer));
        modelAndView.addObject("wineGlass", productService.getAllByType(TypeEnum.WineGlass));
        modelAndView.addObject("whiteWineGlass", productService.getAllByType(TypeEnum.WhiteWine));
        modelAndView.addObject("redWineGlass", productService.getAllByType(TypeEnum.RedWine));
        modelAndView.addObject("roseWineGlass", productService.getAllByType(TypeEnum.Rose));
        modelAndView.addObject("nonAlcoholic", productService.getAllByType(TypeEnum.NonAlcoholic));
        modelAndView.addObject("hotBeverages", productService.getAllByType(TypeEnum.HotBeverages));
        modelAndView.addObject("nuts", productService.getAllByType(TypeEnum.Nuts));
        modelAndView.addObject("menu", productService.getAllByType(TypeEnum.Menu));


        modelAndView.setViewName("full-menu");
        return modelAndView;
    }

    @GetMapping("/liquors")
    public ModelAndView liquors() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("scotchWhiskeys", productService.getAllByType(TypeEnum.ScotchWhisky));
        modelAndView.addObject("irishWhiskeys", productService.getAllByType(TypeEnum.IrishWhisky));
        modelAndView.addObject("americanWhiskeys", productService.getAllByType(TypeEnum.AmericanWhisky));
        modelAndView.addObject("singleMaltScotchWhiskyWhiskeys", productService.getAllByType(TypeEnum.SingleMaltScotchWhisky));
        modelAndView.addObject("japaneseWhiskyWhiskeys", productService.getAllByType(TypeEnum.JapaneseWhisky));
        modelAndView.addObject("gin", productService.getAllByType(TypeEnum.Gin));
        modelAndView.addObject("vodka", productService.getAllByType(TypeEnum.Vodka));
        modelAndView.addObject("cognacAndBrendy", productService.getAllByType(TypeEnum.CognacAndBrendy));
        modelAndView.addObject("rum", productService.getAllByType(TypeEnum.Rum));
        modelAndView.addObject("tequila", productService.getAllByType(TypeEnum.Tequila));
        modelAndView.addObject("rakia", productService.getAllByType(TypeEnum.Rakia));

        modelAndView.setViewName("liquors");
        return modelAndView;
    }

    @GetMapping("/food")
    public ModelAndView food() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("menu", productService.getAllByType(TypeEnum.Menu));
        modelAndView.addObject("nuts", productService.getAllByType(TypeEnum.Nuts));

        modelAndView.setViewName("food");
        return modelAndView;
    }

    @GetMapping("/non-alcoholic")
    public ModelAndView nonAlcoholic() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("nonAlcoholic", productService.getAllByType(TypeEnum.NonAlcoholic));
        modelAndView.addObject("hotBeverages", productService.getAllByType(TypeEnum.HotBeverages));

        modelAndView.setViewName("non-alcoholic");
        return modelAndView;
    }

    @GetMapping("/cocktails")
    public ModelAndView cocktails() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("whiskeyCocktails", productService.getAllByType(TypeEnum.WhiskeyCocktails));
        modelAndView.addObject("ginCocktails", productService.getAllByType(TypeEnum.GinCocktails));
        modelAndView.addObject("vodkaCocktails", productService.getAllByType(TypeEnum.VodkaCocktails));
        modelAndView.addObject("tequilaCocktails", productService.getAllByType(TypeEnum.TequilaCocktails));
        modelAndView.addObject("brandyCocktails", productService.getAllByType(TypeEnum.BrandyCocktails));
        modelAndView.addObject("schroedingerCocktails", productService.getAllByType(TypeEnum.SchroedingerCocktails));

        modelAndView.setViewName("cocktails");
        return modelAndView;
    }

    @GetMapping("/wine")
    public ModelAndView wine() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("wineGlass", productService.getAllByType(TypeEnum.WineGlass));
        modelAndView.addObject("whiteWineGlass", productService.getAllByType(TypeEnum.WhiteWine));
        modelAndView.addObject("redWineGlass", productService.getAllByType(TypeEnum.RedWine));
        modelAndView.addObject("roseWineGlass", productService.getAllByType(TypeEnum.Rose));

        modelAndView.setViewName("wine");
        return modelAndView;
    }

    @GetMapping("/beer")
    public ModelAndView beer() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("beer", productService.getAllByType(TypeEnum.Beer));

        modelAndView.setViewName("beer");
        return modelAndView;
    }

    @GetMapping("/alcohol-menu")
    public ModelAndView alcoholMenu() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("alcohol-menu");
        return modelAndView;
    }


}
