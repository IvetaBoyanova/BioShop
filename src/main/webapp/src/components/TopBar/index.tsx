import React from 'react';
import { Link } from "react-router-dom";
import { AppBar, Toolbar, IconButton, Badge, Button } from "@material-ui/core";
import { LocalGroceryStore } from "@material-ui/icons";
import CartMenu from './partial/PopOver';
import logo from '../../images/logo50.png';
import NavBar from "./partial/NavBar";

const TopBar = ({ classes, badgeContent, cartProducts, handleDrawer, handlePopOver, PopOverOpen, menuIconCounter, AnchorEl, cartBtn, handleClickMenu, menuAnchorEl, menuSelectedIndex, redirectToDetail = null }) => {
   return (
      <AppBar position="fixed">
         <Toolbar style={{backgroundColor: '#9aad00'}}>
            <div>
               <Link to="/" style={{ textDecoration: 'none' }}>
                  <img src={logo} className={'logo'} alt="Logo" />
               </Link>
            </div>
            <div className={classes.flex}>
               <NavBar />
            </div>
            <IconButton onClick={handlePopOver} ref={node => cartBtn = node}>
               {
                  badgeContent ? <Badge badgeContent={badgeContent}>
                     <LocalGroceryStore />
                  </Badge> : <LocalGroceryStore />
               }
            </IconButton>
            <CartMenu
               handlePopOver={handlePopOver}
               PopOverOpen={PopOverOpen}
               AnchorEl={AnchorEl}
               cartProducts={cartProducts.cartProducts}
               handleClickMenu={handleClickMenu}
               menuAnchorEl={menuAnchorEl}
               menuSelectedIndex={menuSelectedIndex}
            />
            <Button href='/login'>Login</Button>
         </Toolbar>
      </AppBar>
   )
};

export default TopBar