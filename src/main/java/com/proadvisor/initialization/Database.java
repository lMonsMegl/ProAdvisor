package com.proadvisor.initialization;

import com.proadvisor.model.builder.CateringBuilder;
import com.proadvisor.model.entity.common.User;
import com.proadvisor.model.entity.item.Category;
import com.proadvisor.model.entity.item.Catering;
import com.proadvisor.model.entity.item.Product;
import com.proadvisor.model.entity.item.Showplace;
import com.proadvisor.model.entity.item.Store;
import com.proadvisor.model.entity.menu.Dish;
import com.proadvisor.model.entity.menu.Menu;
import com.proadvisor.model.entity.menu.MenuChapter;
import com.proadvisor.model.entity.menu.MenuDish;
import com.proadvisor.model.entity.menu.MenuSubchapter;
import com.proadvisor.service.CategoryService;
import com.proadvisor.service.CateringService;
import com.proadvisor.service.DishService;
import com.proadvisor.service.ProductService;
import com.proadvisor.service.ShowplaceService;
import com.proadvisor.service.StoreService;
import com.proadvisor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;

@Component
public class Database {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private CateringService cateringService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private StoreService storeService;
    
    @Autowired
    private ShowplaceService showplaceService;
    
    @Autowired
    private DishService dishService;
    
    @Autowired
    private CategoryService categoryService;
    
    @PostConstruct
    public void insertDefaultUsers() {
        //USERS
        User user1 = new User("admin", "a", "b", "email@email.com", "admin");
        User user2 = new User("user", "a", "b", "user@email.com", "user");
        userService.addNewUser(user1);
        userService.addNewUser(user2);
        
        //MENU
        MenuDish menuDish1 = new MenuDish();
        menuDish1.setName("Daivy Djohns");
        menuDish1.setDescription("Супер вкусный бургер");
        menuDish1.setIngredients("свежий огурец, зеленый помидор");
        menuDish1.setPrice(BigDecimal.valueOf(123));
        
        MenuDish menuDish2 = new MenuDish();
        menuDish2.setName("Yankee");
        menuDish2.setDescription("Фирменный бургер");
        menuDish2.setIngredients("свежий огурец, зеленый помидор");
        menuDish2.setPrice(BigDecimal.valueOf(321));
        
        MenuSubchapter yankeeBarMenuSubchapter1 = new MenuSubchapter();
        yankeeBarMenuSubchapter1.setName("Burgers");
        yankeeBarMenuSubchapter1.setMenuDishes(Arrays.asList(menuDish1, menuDish2));
        menuDish1.setMenuSubchapter(yankeeBarMenuSubchapter1);
        menuDish2.setMenuSubchapter(yankeeBarMenuSubchapter1);
        
        MenuChapter yankeeBarMenuChapter1 = new MenuChapter();
        yankeeBarMenuChapter1.setName("Food");
        yankeeBarMenuChapter1.setMenuSubchapters(Arrays.asList(yankeeBarMenuSubchapter1));
        yankeeBarMenuSubchapter1.setMenuChapter(yankeeBarMenuChapter1);
        
        MenuChapter yankeeBarMenuChapter2 = new MenuChapter();
        yankeeBarMenuChapter2.setName("Drinks");
        
        Menu yankeeBarMenu = new Menu();
        yankeeBarMenu.setMenuChapters(Arrays.asList(yankeeBarMenuChapter1, yankeeBarMenuChapter2));
        yankeeBarMenuChapter1.setMenu(yankeeBarMenu);
        yankeeBarMenuChapter2.setMenu(yankeeBarMenu);
        
        //CATEGORIES
        final Category categoryCaterings = new Category();
        categoryCaterings.setName("Caterings");
        categoryCaterings.setMain(true);
        
        
        final Category categoryProducts = new Category();
        categoryProducts.setName("Products");
        categoryProducts.setMain(true);
        
        
        final Category categoryStores = new Category();
        categoryStores.setName("Stores");
        categoryStores.setMain(true);
        
        final Category categoryShowplaces = new Category();
        categoryShowplaces.setName("Showplaces");
        categoryShowplaces.setMain(true);
        
        final Category categoryHotels = new Category();
        categoryHotels.setName("Hotels");
        categoryHotels.setMain(true);
        
        categoryService.importCategory(categoryCaterings);
        categoryService.importCategory(categoryProducts);
        categoryService.importCategory(categoryStores);
        categoryService.importCategory(categoryShowplaces);
        categoryService.importCategory(categoryHotels);
        
        final Category categoryBars = new Category();
        categoryBars.setName("Bars");
        categoryBars.setParent(categoryCaterings);
        categoryBars.setMain(true);
        
        final Category categoryCafes = new Category();
        categoryCafes.setName("Cafes");
        categoryCafes.setParent(categoryCaterings);
        categoryCafes.setMain(true);
        
        final Category categoryRestaurants = new Category();
        categoryRestaurants.setName("Restaurants");
        categoryRestaurants.setParent(categoryCaterings);
        categoryRestaurants.setMain(true);
        
        categoryService.importCategory(categoryBars);
        categoryService.importCategory(categoryCafes);
        categoryService.importCategory(categoryRestaurants);
        
        final Category categoryCornerShops = new Category();
        categoryCornerShops.setName("Corner shops");
        categoryCornerShops.setParent(categoryStores);
        categoryCornerShops.setMain(true);
        
        final Category categoryDepartmentStores = new Category();
        categoryDepartmentStores.setName("Department stores");
        categoryDepartmentStores.setParent(categoryStores);
        categoryDepartmentStores.setMain(true);
        
        final Category categoryGiftShops = new Category();
        categoryGiftShops.setName("Gift shops");
        categoryGiftShops.setParent(categoryStores);
        categoryGiftShops.setMain(true);
        
        final Category categoryLiquorStores = new Category();
        categoryLiquorStores.setName("Liquor stores");
        categoryLiquorStores.setParent(categoryStores);
        categoryLiquorStores.setMain(true);
        
        final Category categorySouvenirShops = new Category();
        categorySouvenirShops.setName("Souvenir shops");
        categorySouvenirShops.setParent(categoryStores);
        categorySouvenirShops.setMain(true);
        
        final Category categorySupermarkets = new Category();
        categorySupermarkets.setName("Supermarkets");
        categorySupermarkets.setParent(categoryStores);
        categorySupermarkets.setMain(true);
        
        categoryService.importCategory(categoryCornerShops);
        categoryService.importCategory(categoryDepartmentStores);
        categoryService.importCategory(categoryGiftShops);
        categoryService.importCategory(categoryLiquorStores);
        categoryService.importCategory(categorySouvenirShops);
        categoryService.importCategory(categorySupermarkets);
        
        final Category categoryEntertainment = new Category();
        categoryEntertainment.setName("Entertainment");
        categoryEntertainment.setParent(categoryShowplaces);
        categoryEntertainment.setMain(true);
        
        final Category categoryHistorical = new Category();
        categoryHistorical.setName("Historical");
        categoryHistorical.setParent(categoryShowplaces);
        categoryHistorical.setMain(true);
        
        categoryService.importCategory(categoryEntertainment);
        categoryService.importCategory(categoryHistorical);
        
        final Category categoryResortHotels = new Category();
        categoryResortHotels.setName("Resort hotels");
        categoryResortHotels.setParent(categoryHotels);
        categoryResortHotels.setMain(true);
        
        final Category categoryBusinessHotels = new Category();
        categoryBusinessHotels.setName("Business hotels");
        categoryBusinessHotels.setParent(categoryHotels);
        categoryBusinessHotels.setMain(true);
        
        final Category categoryHostels = new Category();
        categoryHostels.setName("Hostels");
        categoryHostels.setParent(categoryHotels);
        categoryHostels.setMain(true);
        
        final Category categoryMotels = new Category();
        categoryMotels.setName("Motels");
        categoryMotels.setParent(categoryHotels);
        categoryMotels.setMain(true);
        
        categoryService.importCategory(categoryResortHotels);
        categoryService.importCategory(categoryBusinessHotels);
        categoryService.importCategory(categoryHostels);
        categoryService.importCategory(categoryMotels);
        
        final Category categoryFood = new Category();
        categoryFood.setName("Food");
        categoryFood.setParent(categoryProducts);
        categoryFood.setMain(true);
        
        final Category categoryDrinks = new Category();
        categoryDrinks.setName("Drinks");
        categoryDrinks.setParent(categoryProducts);
        categoryDrinks.setMain(true);
        
        categoryService.importCategory(categoryFood);
        categoryService.importCategory(categoryDrinks);
        
        final Category categoryAlcohol = new Category();
        categoryAlcohol.setName("Alcohol");
        categoryAlcohol.setParent(categoryDrinks);
        categoryAlcohol.setMain(true);
        
        final Category categoryNonAlcohol = new Category();
        categoryNonAlcohol.setName("Non alcohol");
        categoryNonAlcohol.setParent(categoryDrinks);
        categoryNonAlcohol.setMain(true);
        
        categoryService.importCategory(categoryAlcohol);
        categoryService.importCategory(categoryNonAlcohol);
        
        //CATERINGS
        final Catering yankeeBar = new Catering();
        yankeeBar.setName("Yankee BBQ & Bar");
        yankeeBar.setDescription("Если сегодня вечером вы хотите съесть сочный стейк, пропустить стаканчик-другой и посмотреть баскетбол, мы знаем, куда вам отправится! Yankee BBQ AND BAR — современный американский бар в самом центре Харькова.");
        yankeeBar.setRating(4.7);
        yankeeBar.setMenu(yankeeBarMenu);
        yankeeBar.setMainImage("imageYankee.png");
        yankeeBar.setCommentsCount(121);
        yankeeBar.setItemViewingCount(128);
        yankeeBar.setCategory(categoryBars);
        
        cateringService.importCatering(yankeeBar);
        
        final Catering shobar = new Catering();
        shobar.setName("ШО Бар");
        shobar.setDescription("Desctiption of this amazing bar");
        shobar.setRating(4.9);
        shobar.setMainImage("2018-12-26-04.15.56-1.jpg");
        shobar.setCommentsCount(54);
        shobar.setItemViewingCount(89);
        shobar.setCategory(categoryBars);
        
        cateringService.importCatering(shobar);
        
        cateringService.importCatering(new CateringBuilder<>(new Catering())
                .name("Cat1")
                .description("Short description")
                .mainImage("image.jpg")
                .category(categoryBars)
                .comment()
                .title("Cool")
                .text("I like this catering the most")
                .user(user1)
                .rating(10)
                .createdDateTime(ZonedDateTime.now())
                .done()
                .comment()
                .title("So bad")
                .text("I dont like this catering the most")
                .user(user2)
                .rating(2)
                .createdDateTime(ZonedDateTime.now())
                .done()
                .menu()
                .chapter()
                .name("Chapter1")
                .subchapter()
                .name("Subchapter1")
                .dish()
                .name("Dish1")
                .description("DishDescription1")
                .price(BigDecimal.valueOf(120))
                .ingredients("One two three")
                .weightGrams(200)
                .comment()
                .title("Very tasty")
                .text("Recommend it to everybody. Cool")
                .user(user2)
                .rating(9)
                .createdDateTime(ZonedDateTime.now())
                .done()
                .done()
                .dish()
                .name("Dish2")
                .description("DishDescription2")
                .price(BigDecimal.valueOf(220))
                .ingredients("One two three")
                .weightGrams(300)
                .done()
                .done()
                .done()
                .done()
                .build());
        
        //PRODUCTS
        final Product product1 = new Product();
        product1.setName("Сыр `Бри`");
        product1.setDescription("Бри — мягкий сыр из коровьего молока, получивший своё имя по названию французской провинции, где его впервые стали делать. " +
                "Бри — один из самых знаменитых французских сыров, известный по всему миру.");
        product1.setRating(4.8);
        product1.setCommentsCount(11);
        product1.setManufacture("Alti");
        product1.setAvgPrice(new BigDecimal(229));
        product1.setMainImage("159358549_zakvaska-dlya-syra.jpg");
        product1.setItemViewingCount(34);
        product1.setCategory(categoryFood);
        
        final Product product2 = new Product();
        product2.setName("Портвейн `Valdouro` Ruby Porto");
        product2.setDescription("Les Grands Chais de France – лидирующая французская компания, производитель вин и крепкого алкоголя. " +
                "На сегодняшний день Les Grands Chais de France является крупнейшим экспортером вин из Франции. " +
                "Вина компании продаются более, чем в 250 странах мира. ");
        product2.setRating(4.7);
        product2.setCommentsCount(19);
        product2.setManufacture("Valdouro");
        product2.setAvgPrice(new BigDecimal(335));
        product2.setMainImage("0_0_orig.jpg");
        product2.setItemViewingCount(67);
        product2.setCategory(categoryAlcohol);
        
        final Product product3 = new Product();
        product3.setName("Печенье Milka Cookie Nut XL 184г");
        product3.setDescription("MILKA XL COOKIE NUT - это классический вариант американского печенья! " +
                "Они представляют из себя песочные пшеничные кругляши, на поверхности которых расположились кусочки лесных орешков и шоколадные дропсы)");
        product3.setRating(4.4);
        product3.setCommentsCount(14);
        product3.setManufacture("Milka");
        product3.setAvgPrice(new BigDecimal(84));
        product3.setMainImage("Milka_Logo.svg");
        product3.setItemViewingCount(21);
        product3.setCategory(categoryFood);
        
        productService.importProduct(product1);
        productService.importProduct(product2);
        productService.importProduct(product3);

        //STORES
        final Store store1 = new Store();
        store1.setName("АТБ-Маркет");
        store1.setDescription("«АТБ-Маркет» — украинская компания, специализирующаяся на розничной торговле. " +
                "Основана в 1993 году в Днепропетровске. Магазины сети «АТБ» работают в формате «дискаунтер»");
        store1.setRating(3.7);
        store1.setCommentsCount(228);
        store1.setItemViewingCount(322);
        store1.setMainImage("Логотип_АТБ.svg.png");
        store1.setCategory(categorySupermarkets);

        final Store store2 = new Store();
        store2.setName("Digma");
        store2.setDescription("Компания «Дигма» – сеть продуктовых магазинов для тех, кому важны удобство и качество обслуживания, продуманный ассортимент и близость к дому. ");
        store2.setRating(4.4);
        store2.setCommentsCount(12);
        store2.setItemViewingCount(34);
        store2.setMainImage("digma.jpg");
        store2.setCategory(categorySupermarkets);

        storeService.importStore(store1);
        storeService.importStore(store2);

        //SHOWPLACES
        final Showplace showplace1 = new Showplace();
        showplace1.setName("Родина-мать (Киев)");
        showplace1.setDescription("«Ро́дина-мать» (укр. Батьківщина-мати) — монументальная скульптура в Киеве на правом берегу Днепра. Расположена на территории Музея истории Украины во Второй мировой войне. ");
        showplace1.setMainImage("Rodina_mat.jpg");
        showplace1.setCategory(categoryHistorical);

        showplaceService.importShowplace(showplace1);
        
        Dish dish = new Dish();
        dish.setName("Carbonara");
        dish.setMainImage("pastacarbona.jpg");
        dish.setDescription("Carbonara (Italian: [karboˈnaːra]) is an Italian pasta dish from Rome[1][2] made with egg, hard cheese, guanciale (or pancetta), and black pepper. The dish arrived at its modern form, with its current name");
        
        Dish dish1 = new Dish();
        dish1.setName("Saperavi");
        dish1.setMainImage("saperavi.jpg");
        dish1.setDescription("Saperavi (Georgian: საფერავი; literally \"paint, dye, give color\") is an acidic, teinturier-type grape variety native to Georgia (country), where it is used to make many of the region's most well-known wines");
        
        Dish dish2 = new Dish();
        dish2.setName("Waffle");
        dish2.setMainImage("330px-Waffles_with_Strawberries.jpg");
        dish2.setDescription("A waffle is a dish made from leavened batter or dough that is cooked between two plates that are patterned to give a characteristic size, shape, and surface impression");
        
        dishService.addNewDish(dish);
        dishService.addNewDish(dish1);
        dishService.addNewDish(dish2);
    }
}
