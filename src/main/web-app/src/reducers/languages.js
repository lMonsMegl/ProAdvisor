import { LANGUAGE_SWITCH } from '../actions/action-types';
import {languageData} from "./api";

const INITIAL_STATE = {
  menuData: languageData()
};

export default function (state = INITIAL_STATE, action) {
  switch (action.type) {
    case LANGUAGE_SWITCH : {
      return { ...state, menuData: languageData(action.data) };
    }
    default:
      return state;
  }
}
