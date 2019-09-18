import {
  REQUEST_ALL_CATERINGS,
  SET_CURRENT_CATERING,
  GET_CURRENT_CATERING_MENU,
  LOAD_CATERING_DATA
} from '../action-types';
import {
  getCateringsPreview,
  getCatering,
  getMenu
} from '../request/caterings';

export function getAllCateringsPreview() {
  return dispatch => {
    getCateringsPreview()
        .then(res => res.json())
        .then(data => dispatch({
          type: REQUEST_ALL_CATERINGS,
          data
        }))
        .catch(() => {
          console.log('Something went wrong while fetching categories');
        });
  };
}

export function setCurrentCatering(id) {
  return dispatch => {
    getCatering(id)
        .then(res => res.json())
        .then(data => dispatch({
          type: SET_CURRENT_CATERING,
          data
        }));
  };
}

export function getCurrentCateringMenu(id) {
  return dispatch => {
    getMenu(id)
        .then(res => res.json())
        .then(data => dispatch({
          type: GET_CURRENT_CATERING_MENU,
          data
        }))
        .catch(() => console.log('Something went wrong'));
  };
}

export function loading(flag) {
  return dispatch => dispatch({
    type: LOAD_CATERING_DATA,
    data: flag
  })
}
