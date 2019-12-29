import React from 'react';
import { connect } from "react-redux";
import { createSelector } from "reselect";
import { Typography, List, ListItem, ListItemText } from "@material-ui/core";
// import { getCartProducts } from "../../../reducers";
import withStyles from '@material-ui/core/styles/withStyles';

const Styles = {
   list: {
      maxHeight: 170
   }
};

const MenuList = ({ handleClickMenu, products, classes }) => {
   return (
      <List component="nav" dense classes={{ root: classes.list }}>
         {
            products.length > 0 ? products.map((product, index) => (
               <ListItem
                  key={product.id}
                  button
                  aria-haspopup="true"
                  aria-controls="cart-menu"
                  aria-label="Cart Menu"
                  onClick={() => handleClickMenu(product.title)}
               >
                  <ListItemText
                     primary={product.title}
                     secondary={'Rp ' + product.price.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,") + ' | Quantity:' + product.quantity}
                  />
               </ListItem>
            )) : <ListItem><Typography variant="subtitle1">You have no item in the bag</Typography></ListItem>
         }
      </List>
   )
};

const getProducts = state => 0;
// const getProducts = state => getCartProducts(state)
const getProductsSelector = createSelector(
   getProducts,
   products => products
);

const mapStateToProps = (state) => ({
   products: getProductsSelector(state)
});

export default withStyles(Styles)(connect(mapStateToProps)(MenuList))