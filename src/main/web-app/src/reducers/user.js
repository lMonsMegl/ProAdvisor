import { LOG_IN, REGISTER } from '../actions/action-types';

const INITIAL_STATE = {
  username: '',
  logInAdvice: null,
  password: null,
  status: 0
};

export default function (state = INITIAL_STATE, action) {
  switch (action.type) {
    case LOG_IN: {
      return { ...state, username: action.userName };
    }
    case REGISTER: {
      return {
        ...state,
        logInAdvice: action.logInAdvice,
        password: action.password,
        status: action.status
      };
    }
    default:
      return state;
  }
}
