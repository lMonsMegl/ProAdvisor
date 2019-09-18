import { GET_CATEGORIES } from '../../config/urls';
import sendRequest from '../../config/api';

export function getAllCategories() {
  return fetch(GET_CATEGORIES);
}

export function fetchItemsByCategory(URL) {
  return fetch(URL);
}

export function postItemByCategory(URL, data) {
  return sendRequest(URL, 'post', data);
}

