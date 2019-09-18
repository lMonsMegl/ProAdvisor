import {
  REQUEST_ALL_CATERINGS,
  SET_CURRENT_CATERING,
  GET_CURRENT_CATERING_MENU,
    LOAD_CATERING_DATA
} from '../actions/action-types';

const INITIAL_STATE = {
  loading: false,
  caterings: [],
  current: null
};

export default function (state = INITIAL_STATE, action) {
  switch (action.type) {
    case REQUEST_ALL_CATERINGS: {
      return {
        ...state,
        caterings: action.data
      };
    }
    case SET_CURRENT_CATERING: {
      return {
        ...state,
        current: action.data,
        loading: false
      };
    }
    case GET_CURRENT_CATERING_MENU: {
      const currentCatering = state.current;
      currentCatering.menu = action.data;
      return {
        ...state,
        current: currentCatering,
        loading: false
      };
    }
    case LOAD_CATERING_DATA: {
      return {
        loading: action.data
      }
    }
    default :
      return state;
  }
}
