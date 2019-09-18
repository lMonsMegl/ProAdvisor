import { ADD_USER, LOG_IN_USER } from '../../config/urls';
import sendRequest from '../../config/api';

export  const fetchUser = data => sendRequest(LOG_IN_USER, 'post', data);

export const register = data => sendRequest( ADD_USER, 'post', data);
