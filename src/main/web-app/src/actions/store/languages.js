import {LANGUAGE_SWITCH} from '../action-types';

export  function changeLanguage(language) {
  return dispatch => dispatch({
    type: LANGUAGE_SWITCH,
    data: language
  })
}
