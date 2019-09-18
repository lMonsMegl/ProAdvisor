import {
  CATERINGS,
  GET_CATERING,
  CATERING_MENU,
  CATERING_CHAPTER,
  CATERING_SUB_CHAPTER,
  ADD_DISH,
  GET_DISH
} from '../../config/urls';

import sendRequest from '../../config/api';

export const getCateringsPreview = () => fetch(CATERINGS);

export const addCatering = data => sendRequest(CATERINGS, 'post', data);

export const getCatering = id => fetch(GET_CATERING(id));

export const getMenu = cateringId => fetch(CATERING_MENU(cateringId));

export const addChapter = (cateringId, data) =>
    sendRequest(CATERING_CHAPTER(cateringId), 'post', data );

export const addSubChapter = (cateringId, chapterName, data) =>
    sendRequest(CATERING_SUB_CHAPTER(cateringId, chapterName), 'post', data);

export const addDish = (cateringId, chapterName, subChapterName, data ) =>{
  console.log("ADD DISH");
  console.log(data);
  return sendRequest(ADD_DISH(cateringId, chapterName, subChapterName), 'post', data);
};

export const getDish = (chapterId, chapterName, subChapterName, dishName) =>
    fetch(GET_DISH(chapterId, chapterName, subChapterName, dishName));
