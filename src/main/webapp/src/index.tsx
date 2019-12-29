import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import * as serviceWorker from './serviceWorker';
import {BrowserRouter} from "react-router-dom";
import { Provider } from "react-redux";
import {createStore, applyMiddleware, combineReducers} from 'redux'
import thunk from 'redux-thunk'
import { createLogger } from 'redux-logger'

const middleware: Array<any> = [thunk];
if (process.env.NODE_ENV !== 'production') {
   middleware.push(createLogger());
}

const persistedState = localStorage.getItem('reduxState') ? JSON.parse("" + localStorage.getItem('reduxState')) : {};
const rootReducer = combineReducers({
   persistedState
});
const store = createStore(
   rootReducer,
   applyMiddleware(...middleware)
);

store.subscribe(() => {
   localStorage.setItem('reduxState', JSON.stringify(store.getState()))
});

ReactDOM.render(
   <Provider store={store}>
      <BrowserRouter>
            <App />
      </BrowserRouter>
   </Provider>,
   document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
