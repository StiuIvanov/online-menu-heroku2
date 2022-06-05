package com.example.demo.web;

import com.example.demo.model.binding.AddByTypeBindingModel;
import com.example.demo.model.binding.EventBindingModel;
import com.example.demo.model.binding.ProductEditBindingModel;
import com.example.demo.model.binding.SpecialProductBindingModel;
import com.example.demo.model.entity.ProductEntity;
import com.example.demo.model.entity.enums.TypeEnum;
import com.example.demo.service.EventService;
import com.example.demo.service.ProductService;
import com.example.demo.service.SpecialProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("isAdmin()")
@RequestMapping("/admin")
public class AdminController {
    private final ProductService productService;
    private final EventService eventService;
    private final SpecialProductService specialProductService;

    public AdminController(
            ProductService productService,
            EventService eventService,
            SpecialProductService specialProductService) {
        this.productService = productService;
        this.eventService = eventService;
        this.specialProductService = specialProductService;
    }


    @PostMapping("/remove/{id}")
    public String removeProduct(@PathVariable Long id) {
        productService.removeProductById(id);
        return "redirect:/admin/full-menu";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id,
                              Model model) {

        ProductEntity currentProduct = productService.findById(id);
        model.addAttribute("currentProduct", currentProduct);
        return "edit-product";
    }

    @GetMapping("/add-event")
    public String addEvent() {
        return "add-event";
    }

    @GetMapping("/add-special")
    public String addSpecial() {
        return "add-special";
    }

    @PostMapping("/add-special")
    public String addSpecialConfirm(@RequestParam("file") MultipartFile multipartFile,
                                    SpecialProductBindingModel specialProductBindingModel) {
        specialProductService.addSpecial(specialProductBindingModel,multipartFile);
        return "redirect:/";
    }

    @PostMapping("/delete-specialty")
    public String deleteSpecialtyConfirm(){
        specialProductService.deleteSpecialty();
        return "redirect:/";
    }

    @PostMapping("/add-event")
    public String addEventConfirm(EventBindingModel eventBindingModel){
        eventService.addEvent(eventBindingModel);
        return "redirect:/";
    }

    @PostMapping("/delete-event")
    public String deleteEventConfirm(){
        eventService.deleteEvent();
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String editProductConfirm(ProductEditBindingModel productEditBindingModel) {
        productService.editProduct(productEditBindingModel);
        return "redirect:/admin/full-menu";
    }

    @PostMapping("/add-by-type")
    public String addByType(AddByTypeBindingModel addByTypeBindingModel) {
        productService.addByType(addByTypeBindingModel);
        return "redirect:/admin/full-menu";
    }

    @GetMapping("/full-menu")
    public ModelAndView adminFullMenu() {
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

        modelAndView.setViewName("admin-full-menu");
        return modelAndView;
    }

}

