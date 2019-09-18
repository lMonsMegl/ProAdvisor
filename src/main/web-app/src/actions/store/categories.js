import { REQUEST_ALL_CATEGORIES, GET_CURRENT_CATEGORY_ITEMS } from '../action-types';
import { getAllCategories, fetchItemsByCategory } from '../request/categories';

export function getCategories() {
  return dispatch => {
    getAllCategories()
        .then(res => res.json())
        .then(data => dispatch({
          type: REQUEST_ALL_CATEGORIES,
          data
        }))
        .catch(() => {
          console.log('Something went wrong while fetching categories');
        });
  };
}

export function getItemsByCategory(URL) {
  return dispatch => {
    fetchItemsByCategory(URL)
        .then(res => res.json())
        .then(data => dispatch({
          type: GET_CURRENT_CATEGORY_ITEMS,
          data
        }))
        .catch(() => {
          console.log('Something went wrong while fetching categories');
        });
  }
}
