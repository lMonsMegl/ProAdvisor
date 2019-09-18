import React from "react";
import "./styles/_base.scss";
import { Route } from "react-router";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import { applyMiddleware, combineReducers, createStore } from "redux";
import { Provider } from "react-redux";
import { routerReducer as routing } from "react-router-redux";
import thunk from "redux-thunk";
import App from "./App";

import "./styles/main.scss";
import reducers from "./reducers";

const createStoreWithMiddleware = applyMiddleware(thunk)(createStore);
const reducer = combineReducers({ ...reducers, routing });
const store = createStoreWithMiddleware(reducer);

ReactDOM.render(
    <Provider store={store}>
      <BrowserRouter>
        <Route component={App} />
      </BrowserRouter>
    </Provider>,
    document.getElementById("root")
);

