# ProAdvisor

## Categories 

####Get all categories
/catalogue/categories                  
All categories.
####Get main categories
/catalogue/categories/main                   
Main categories for catalog page in maximum 3 nesting.
####Get subcategories
/catalogue/categories/sub/:category1:/:category2:/...
Get subcategories by path.

## Menu

#### Get menu
/item/caterings/{cateringId}/menu (GET)  

Returns all menu - chapters, subchapters and dishes

#### Add chapter
/item/caterings/{cateringId}/menu/chapter (POST)

Params: 
 - name

#### Add subchapter
/item/caterings/{cateringId}/menu/chapter/{chapterName}/subchapter (POST)

Params: 
 - name

#### Add menudish
/item/caterings/{cateringId}/menu/chapter/{chapterName}/subchapter/{subchapterName}/dish (POST)

Params:
 - String name
 - String description
 - String ingredients
 - BigDecimal price
 - MultipartFile image
 - long dishId 

#### Get menudish
/item/caterings/{cateringId}/menu/chapter/{chapterName}/subchapter/{subchapterName}/dish/{dishName} (GET)

#### Get menudish by id
/items/menuDishes/{menuDishId}

## Comments

#### Add comment
/items/{itemId}/comments (POST)

Params:
 - String title
 - String text
 - int rating


## Registration


## Authorization

If access to route is prohibited in server level user will get 403

## Products
GET             /items/products             ProductController.getAllCateringPreviews()                              Preview for product items in catalogue
POST            /items/products             ProductController.addNewProduct(ProductDto productDto)                  Add new product item
GET             /items/products/{id}        ProductController.getProductById(long id)                               Get certain product item from catalogue

## Stores
GET             /items/stores               StoreController.getAllStorePreviews()                                   Preview for store items in catalogue
POST            /items/stores               StoreController.addNewStore(StoreDto storeDto)                          Add new store item
GET             /items/stores/{id}          StoreController.getStoreById(long id)                                   Get certain store item from catalogue

## Showplaces
GET             /items/showplaces           ShowplaceController.getAllShowplacePreviews()                           Preview for showplace items in catalogue
POST            /items/showplaces           ShowplaceController.addNewShowplace(ShowplaceDto showplaceDto)          Add new showplace item
GET             /items/showplaces/{id}      ShowplaceController.getShowplaceById(long id)                           Get certain showplace item from catalogue

## Dishes
GET             /items/dishes         DishController.getAllShowplacePreviews()                           Preview for showplace items in catalogue
POST            /items/dishes         DishController.addNewShowplace(ShowplaceDto showplaceDto)          Add new showplace item
GET             /items/dishes/{id}    DishController.getShowplaceById(long id)                           Get certain showplace item from catalogue

## Caterings
GET             /items/caterings         CateringController.getAllShowplacePreviews()                           Preview for showplace items in catalogue
POST            /items/caterings         CateringController.addNewShowplace(ShowplaceDto showplaceDto)          Add new showplace item
GET             /items/caterings/{id}    CateringController.getShowplaceById(long id)                           Get certain showplace item from catalogue

To all previous:
 - String name
 - String description
 - MultipartFile image

## Images

#### Get image 
/images/{imageId} (GET)

Returns image file 

#### Add image
/items/{itemId}/images

Params:
 - image - multipart form file

#### Set main image
/items/{itemId}/mainImage

Params:
 - image - multipart form file
 