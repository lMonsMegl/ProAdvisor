const API = 'http://localhost:9000';

export const LOG_IN_USER = `${API}/login`;
export const ADD_USER = `${API}/user/add`;
export const GET_CATEGORIES = `${API}/catalogue/categories`;

export const CATERINGS = `${API}/items/caterings`;
export const GET_CATERING = id => `${CATERINGS}/${id}`;

export const CATERING_MENU = cateringId => `${CATERINGS}/${cateringId}/menu`;
export const CATERING_CHAPTER = cateringId => `${CATERING_MENU(cateringId)}/chapter`;
export const CATERING_SUB_CHAPTER = (cateringId, chapterName) => `${CATERING_CHAPTER(cateringId)}/${chapterName}/subchapter`;
export const ADD_DISH = (cateringId, chapterName, subChapterName) => `${CATERING_SUB_CHAPTER(cateringId, chapterName)}/${subChapterName}/dish`;
export const GET_DISH = (cateringId, chapterName, subChapterName, dishName) => `${ADD_DISH(cateringId, chapterName, subChapterName)}/${dishName}`;

export const SHOP_ITEMS = `${API}/items/stores`;
export const PRODUCT_ITEMS = `${API}/items/products`;
export const SHOWPLACES_ITEMS = `${API}/items/showplaces`;
export const DISHES = `${API}/items/dishes`;

export const ADD_ITEM_COMMENT = itemId => `${API}/items/${itemId}/comments`;
