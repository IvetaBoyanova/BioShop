import React from 'react';
import { Switch } from "react-router-dom";
import LayoutsWrapper from './LayoutsWrapper/LayoutsWrapper'
import Header from './Header/Header'
import Home from './Home/Home'
import Shop from "./Shop/Shop";

const routes = [
   {
      exact: true,
      pathName: '/',
      Component: Home
   },
   {
      exact: false,
      pathName: '/shop',
      Component: Shop
   }
];

const Main = () => (
   <Switch>
      {
         routes.map(page => (
            <LayoutsWrapper exact={page.exact} key={page.pathName} path={page.pathName} layout={Header} component={page.Component} />
         ))
      }
   </Switch>
);

export default Main