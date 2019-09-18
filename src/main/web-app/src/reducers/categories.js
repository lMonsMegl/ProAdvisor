import {
  REQUEST_ALL_CATEGORIES,
  GET_CURRENT_CATEGORY_ITEMS
} from '../actions/action-types';

const INITIAL_STATE = {
  categories: '',
  currentCategoryItems: ''
};

export default function (state = INITIAL_STATE, action) {
  switch (action.type) {
    case REQUEST_ALL_CATEGORIES: {
      return {
        ...state,
        categories: action.data
      }
    }
    case GET_CURRENT_CATEGORY_ITEMS: {
      return {
        ...state,
        currentCategoryItems: action.data
      }
    }
    default : return state;
  }
}
