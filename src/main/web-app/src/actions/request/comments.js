import sendRequest from '../../config/api';
import {ADD_ITEM_COMMENT} from '../../config/urls';

export const addItemComment = (itemId, data) =>
    sendRequest(ADD_ITEM_COMMENT(itemId), 'post', data);
