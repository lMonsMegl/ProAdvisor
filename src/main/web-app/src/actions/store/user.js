import { LOG_IN, REGISTER, REQUEST_CURRENT_USER } from '../action-types';
import { fetchUser, register } from '../request/user';

export function logInUser(data) {
  return dispatch => {
    dispatch({ type: REQUEST_CURRENT_USER });
    fetchUser(data)
        .then(() => {
          return dispatch({
            type: LOG_IN,
            userName: data.username
          });
        })
        .catch(() => {
          console.log('Something went wrong');
        });
  };
}

export function registerUser(data) {
  return dispatch => {
    dispatch({ type: REQUEST_CURRENT_USER });
    register(data)
        .then(request => {
          console.log(data);
          console.log(request);
          return dispatch({
            type: REGISTER,
            logInAdvice: data.login,
            password: data.password,
            status: request.status
          });
        })
        .catch(() => {
          console.log('Something went wrong');
        });
  };
}
